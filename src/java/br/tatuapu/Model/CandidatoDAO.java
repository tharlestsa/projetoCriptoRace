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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tatuapu
 */
public class CandidatoDAO implements DAO{

    private Connection conn;

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
       PreparedStatement ps = null;
       Connection conn = null;
       ResultSet rs = null;
       List<Candidato> candidatos = new ArrayList<Candidato>();
       try{
           conn = ConnectionDAO.getConnection();
           ps = conn.prepareStatement("select * from candidato");
           rs = ps.executeQuery();
           while(rs.next()){
               int idCandidato = rs.getInt(1);
               String nomeCompleto = rs.getString(2);
               String nick = rs.getString(3);
               String matriculaIFG = rs.getString(4);
               String cpf = rs.getString(5);
               
               Candidato candidato = new Candidato(idCandidato, nomeCompleto, nick, matriculaIFG, cpf);
               candidatos.add(candidato);
           }
       }catch(SQLException sqle){
           throw new Exception(sqle);
       }finally{
           ConnectionDAO.closeConnection(conn, ps, rs);
       }
       return candidatos;
    }

    @Override
    public List procura(Object ob) throws Exception {
       Candidato candidato = (Candidato) ob;
       PreparedStatement ps = null;
       Connection conn = null;
       ResultSet rs = null;
       List<Candidato> candidatos = new ArrayList<Candidato>();
       try{
           conn = ConnectionDAO.getConnection();
           //ps = conn.prepareStatement("select * from candidato WHERE (idCandidato=? or nomeCompleto=? or nick=? or matriculaIFG=? or cpf=?);");
           ps = conn.prepareStatement("select * from candidato WHERE (nomeCompleto=? and matriculaIFG=?);");
           //ps.setInt(1, candidato.getIdCandidato());
           ps.setString(1, candidato.getNomeCompleto());
           //ps.setString(3, candidato.getNick());
           ps.setString(2, candidato.getMatriculaIFG());
           //ps.setString(5, candidato.getCpf());
           
           rs = ps.executeQuery();
           while(rs.next()){
               int idCandidato = rs.getInt(1);
               String nomeCompleto = rs.getString(2);
               String nick = rs.getString(3);
               String matriculaIFG = rs.getString(4);
               String cpf = rs.getString(5);
               
               candidatos.add(new Candidato(idCandidato, nomeCompleto, nick, matriculaIFG, cpf));
           }
       }catch(SQLException sqle){
           throw new Exception(sqle);
       }finally{
           ConnectionDAO.closeConnection(conn, ps, rs);
       }
       return candidatos;
    }

    @Override
    public Object procuraPeloId(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Candidato candidato;
        candidato =  (Candidato) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (candidato == null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        try{
            String SQL = "INSERT INTO candidato (nomeCompleto, nick, matriculaIFG, cpf) VALUES (?,?,?,?)";
            
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setString(1, candidato.getNomeCompleto());
            ps.setString(2, candidato.getNick());
            ps.setString(3, candidato.getMatriculaIFG());
            ps.setString(4, candidato.getCpf());
            ps.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados do candidato: \n"+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn,ps);
        }
    }
    
}
