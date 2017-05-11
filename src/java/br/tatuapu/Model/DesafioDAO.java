/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.Model;

import br.tatuapu.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class DesafioDAO implements DAO{

    @Override
    public void atualizar(Object ob) throws Exception {
        Desafio dd = (Desafio) ob;
        Integer desafio = dd.getIdDesafio();
        PreparedStatement ps = null;
        Connection conn = null;
        if(desafio==null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        try{
            conn = ConnectionDAO.getConnection();                   
            ps = conn.prepareStatement("UPDATE desafios SET status=? WHERE idDesafio=?");
            ps.setString(1, "Inativo");
            ps.setInt(2, desafio);
            ps.executeUpdate();
        }catch(SQLException sqle){
            throw new Exception("Erro ao atualizar dados: "+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps);
        }
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
//        String respostaEnviada = (String) ob;
//        PreparedStatement ps = null;
//       Connection conn = null;
//       ResultSet rs = null;
//       List<RespDesafio> respostasDesafio = new ArrayList<>();
//       List<Desafio> desafios = new ArrayList<>();
//       try{
//           conn = ConnectionDAO.getConnection();
//           //ps = conn.prepareStatement("SELECT * FROM `respDesafio` inner join desafios on desafios.idDesafio = respDesafio.idDesafio WHERE resposta like '%?%';");           
//           ps = conn.prepareStatement("SELECT * FROM `respDesafio` inner join desafios on desafios.idDesafio = respDesafio.idDesafio WHERE resposta like '%?%';");           
//           ps.setString(1, respostaEnviada);
//           
//           Desafio desafio = null;
//           
//           rs = ps.executeQuery();
//           while(rs.next()){
//               int idResposta = rs.getInt(1);
//               String resposta= rs.getString(2);
//               int idDesafio = rs.getInt(3);
//               int idContest = rs.getInt(6);
//               String descricaoDesafio = rs.getString(5);
//               String status = rs.getString(7);
//               int pontuacao = rs.getInt(8);
//               if(desafio == null)
//                    desafio = new Desafio(idDesafio, descricaoDesafio, idContest, status, pontuacao);
//               else{
//                   if (desafio.getIdDesafio()!=idDesafio)
//                       desafio = new Desafio(idDesafio, descricaoDesafio, idContest, status, pontuacao);
//               }
//               respostasDesafio.add(new RespDesafio(idResposta, resposta, idDesafio));
//               desafio.addRespDesafio(new RespDesafio(idResposta, resposta, idDesafio));
//           }
//       }catch(SQLException sqle){
//           throw new Exception(sqle);
//       }finally{
//           ConnectionDAO.closeConnection(conn, ps, rs);
//       }
//       return respostasDesafio;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Desafio procura(String respostaEnviada, int idContest) throws Exception{
        Desafio desafio = null;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
           conn = ConnectionDAO.getConnection();
           ps = conn.prepareStatement("SELECT * FROM `respDesafio` inner join desafios on desafios.idDesafio = respDesafio.idDesafio WHERE respDesafio.resposta like '%?%' and idContest=?;");           
           ps.setString(1, respostaEnviada);
           ps.setInt(2, idContest);
           rs = ps.executeQuery();
           while(rs.next()){
               int idResposta = rs.getInt(1);
               String resposta= rs.getString(2);
               int idDesafio = rs.getInt(3);
               int idContes  = rs.getInt(6);
               String descricaoDesafio = rs.getString(5);
               String status = rs.getString(7);
               int pontuacao = rs.getInt(8);
               desafio = new Desafio(idDesafio, descricaoDesafio, idContest, status, pontuacao);
           }
        }catch(SQLException sqle){
           throw new Exception(sqle);
       }finally{
           ConnectionDAO.closeConnection(conn, ps, rs);
       }   
        
        return desafio;
    }

    @Override
    public Object procuraPeloId(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
