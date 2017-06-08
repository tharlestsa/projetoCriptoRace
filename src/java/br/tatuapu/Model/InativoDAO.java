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
public class InativoDAO implements DAO {

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
        Integer idDesafio = (Integer) ob;
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        List<Integer> vrS = new ArrayList<Integer>();
        
        try{
           conn = ConnectionDAO.getConnection();
           ps = conn.prepareStatement("SELECT * FROM inativos WHERE idDesafio=?;");           
           ps.setInt(1, idDesafio);
           
           rs = ps.executeQuery();
           while(rs.next()){               
               vrS.add(rs.getInt("idDesafio"));                   
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
    
}
