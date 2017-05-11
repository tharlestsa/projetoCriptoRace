package br.tatuapu.Model;

import br.tatuapu.Model.Contest;
import br.tatuapu.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContestDAO implements DAO {
    private Connection conn;

    public ContestDAO() throws Exception{
        try{
            this.conn = ConnectionDAO.getConnection();
        }catch(Exception e){
            throw new Exception("Erro: \n"+e.getMessage());
        }
    }
    @Override
    public void atualizar(Object ob) throws Exception {
//        Publicacao pub = (Publicacao) ob;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        if(pub == null){
//            throw new Exception("O valor passado não pode ser nulo");
//        }
//        try{
//            String SQL = "UPDATE publicacao SET titulo=?, cidade=?, anoPublicacao=?, isbn=? WHERE idPublicacao=?";
//            conn = this.conn;
//            ps = conn.prepareStatement(SQL);
//            ps.setString(1, pub.getTitulo());
//            ps.setString(2, pub.getCidade());
//            ps.setInt(3, pub.getAnoPublicacao());
//            ps.setInt(4, pub.getIsbn());
//            ps.setInt(5, pub.getIdPublicacao());
//            ps.executeUpdate();
//        }catch(SQLException sqle){
//            throw new Exception("Erro ao atualizar dados: " +sqle);
//        }finally{
//            ConnectionDAO.closeConnection(conn,ps);
//        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List ranking() throws Exception {
        PreparedStatement ps = null;
       Connection conn = null;
       ResultSet rs = null;
       List<Ranking> ranking = new ArrayList<Ranking>();
       try{
           conn = this.conn;
           ps = conn.prepareStatement("SELECT *, sum(pontuacao) as 'totalPontos' FROM `acertoCandidato` inner join "
                   + "desafios on desafios.idDesafio = acertoCandidato.idDesafio inner join respostaSubmetida on "
                   + "respostaSubmetida.idRespSubmetida = acertoCandidato.idRespostaSubmetida inner join candidato on "
                   + "candidato.idCandidato = respostaSubmetida.idCandidato group by candidato.idCandidato ORDER BY totalPontos DESC");
           rs = ps.executeQuery();
           while(rs.next()){
               int idAcertos = rs.getInt(1);
               int idDesafio = rs.getInt(2);
               int idRespostaSubmetida = rs.getInt(3);
               Ranking rank = new Ranking(new Candidato(rs.getInt("idCandidato"), rs.getString("nomeCompleto"), rs.getString("nick"), rs.getString("matriculaIFG"), rs.getString("cpf")), rs.getInt("totalPontos"));
               
               ranking.add(rank);
           }
       }catch(SQLException sqle){
           throw new Exception(sqle);
       }finally{
           ConnectionDAO.closeConnection(conn, ps, rs);
       }
       return ranking;
    }
    
    @Override
    public List listaTodos() throws Exception {
       PreparedStatement ps = null;
       Connection conn = null;
       ResultSet rs = null;
       List<Contest> contests = new ArrayList<Contest>();
       try{
           conn = this.conn;
           ps = conn.prepareStatement("select * from contest");
           rs = ps.executeQuery();
           while(rs.next()){
               int idContest = rs.getInt(1);
               String nome = rs.getString(2);
               String status = rs.getString(3);
               String loc = rs.getString(4);
               
               Contest contest = new Contest(idContest, nome, status, loc);
               contests.add(contest);
           }
       }catch(SQLException sqle){
           throw new Exception(sqle);
       }finally{
           ConnectionDAO.closeConnection(conn, ps, rs);
       }
       return contests;
    }

    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object procuraPeloId(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
