/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.Model;

import br.tatuapu.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tatuapu
 */
public class ValidaRespostaSubmetidaDAO implements DAO {

    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List procura(Object ob) throws Exception {
        RespostaEnviada respEnviada = (RespostaEnviada) ob;
        Desafio desafio = null;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        List<ValidaRespSubmetida> vrS = new ArrayList<ValidaRespSubmetida>();
        
        try{
           conn = ConnectionDAO.getConnection();
           ps = conn.prepareStatement("SELECT * FROM respDesafio inner join desafios on desafios.idDesafio = respDesafio.idDesafio where respDesafio.resposta = ? AND desafios.status='Ativo';");           
           ps.setString(1, respEnviada.getResposta());
           
           rs = ps.executeQuery();
           while(rs.next()){
               int idDesafio = rs.getInt(3);
               RespostaSubmetida respostaSubmetida = new RespostaSubmetida(0, respEnviada.getResposta(), respEnviada.getIdCandidato(), idDesafio);
               ValidaRespSubmetida valida = new ValidaRespSubmetida();
               valida.setPontuacao(rs.getInt("pontuacao"));
               valida.setStatus(true);
               valida.setRespostaSubmetida(respostaSubmetida);
               valida.setRespDesafio(new RespDesafio(rs.getInt("idResp"), respEnviada.getResposta(), idDesafio));
               vrS.add(valida);
               int idRespSubmetida = cadastraRespostaSubmetida(respostaSubmetida);
               //tentando cadastrar o acerto, e caso ele já tenha enviado esta reposta, voltara false, ou true, CC.
               if (!cadastraAcertoCandidato(new AcertoCandidato(0, idDesafio, idRespSubmetida), respEnviada.getIdCandidato(), respEnviada.getResposta())){
                   vrS.clear();
                   ValidaRespSubmetida invalida = new ValidaRespSubmetida();
                   invalida.setStatus(false);
                   invalida.setPontuacao(-1000);//vai permitir controlar isso
                   vrS.add(invalida);
               }
                   
           }
        }catch(SQLException sqle){
           throw new Exception(sqle);
       }finally{
           ConnectionDAO.closeConnection(conn, ps, rs);
       }   
        
        return vrS;
    }

    @Override
    public Object procuraPeloId(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int cadastraRespostaSubmetida(RespostaSubmetida respostaSubmetida) throws Exception {
        PreparedStatement ps = null;
        Statement stmt = null;
        Connection conn = null;
        int insertedId = 0;
        if (respostaSubmetida == null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        try{
            String SQL = "INSERT INTO respostaSubmetida (respostaSubmetida, idCandidato, idDesafio) VALUES (?,?,?)";
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, respostaSubmetida.getRespostaSubmetida());
            ps.setInt(2, respostaSubmetida.getIdCandidato());
            ps.setInt(3, respostaSubmetida.getIdDesafio());
            ps.executeUpdate(); 
            //recuperando o id inserido
            ResultSet rss = ps.getGeneratedKeys();
            if (rss.next()) {
                insertedId = rss.getInt(1);
            }
            
        }catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados da resposta submetida: \n"+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn,ps);
        }
        return insertedId;
    }

    private boolean cadastraAcertoCandidato(AcertoCandidato acertoCandidato, int idCandidato, String resposta) throws Exception {
        PreparedStatement ps = null;
        Statement stmt = null;
        Connection conn = null;
        int insertedId = 0;
        if (acertoCandidato == null){
            throw new Exception("O valor passado não pode ser nulo - objeto AcertoCandidato");
        }
        try{
            //antes de cadastrar o acerto, preciso certificar que o velhaco já não mandou mesma resposta para este desafio
            String SQLb = "SELECT * FROM `acertoCandidato` inner join respostaSubmetida on respostaSubmetida.idRespSubmetida = "
                    + "acertoCandidato.idRespostaSubmetida where (idCandidato = ? and respostaSubmetida=?)";
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQLb);
            ps.setInt(1, idCandidato);
            ps.setString(2, resposta);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow()>0)
                return false;//impedindo que o cabra envie a mesma reposta de novo
            else{
                String SQL = "INSERT INTO acertoCandidato (idDesafio, idRespostaSubmetida) VALUES (?,?)";
                conn = ConnectionDAO.getConnection();
                ps = conn.prepareStatement(SQL);
                ps.setInt(1, acertoCandidato.getIdDesafio());
                ps.setInt(2, acertoCandidato.getIdRespostaSubmetida());
                ps.executeUpdate(); 
                
                //agora que o acerto foi cadastrado, bora ver se o desafio precisa ser inativado
                InativoDAO iDAO = new InativoDAO();
                if (iDAO.procura(acertoCandidato.getIdDesafio()).size()>0){
                    DesafioDAO dDAO = new DesafioDAO();
                    dDAO.atualizar(new Desafio(acertoCandidato.getIdDesafio(), null, 0, "Inativo", 0));
                }
                
                return true;
            }    
                        
        }catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados do acerto do candidato: \n"+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn,ps);
        }
    }
    
}
