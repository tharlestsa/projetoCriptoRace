/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.service;

import br.tatuapu.Model.Desafio;
import br.tatuapu.Model.DesafioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author tatuapu
 */
@WebService(serviceName = "PontuadorService")
public class PontuadorService implements Pontuador {

   @Override
    public boolean pontua(int idCandidato, int idContest, String resposta){
        DesafioDAO dao = new DesafioDAO();
        Desafio desafio;
       try {
           desafio = dao.procura(resposta, idContest);
           if (desafio != null)
               return true;
           else
               return false;
       } catch (Exception ex) {
           Logger.getLogger(PontuadorService.class.getName()).log(Level.SEVERE, null, ex);
           return false;
       }
    }
    
    @Override
    public double getPontuacaoDoCandidato(int idCandidato, int idContest){
        return 100.0;
    }
    
}
