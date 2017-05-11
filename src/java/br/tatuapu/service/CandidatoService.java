/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.service;

import br.tatuapu.Model.CandidatoDAO;
import cdc.util.DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author tatuapu
 */
@WebService(serviceName = "CandidatoService")
public class CandidatoService implements Candidato {

    @Override
    public int cadastraCandidato(int idCandidato, String nomeCompleto, String nick, String matriculaIFG, String cpf) {
        br.tatuapu.Model.Candidato candidato = new br.tatuapu.Model.Candidato(idCandidato, nomeCompleto, nick, matriculaIFG, cpf);
        CandidatoDAO dao = new CandidatoDAO();
        List<br.tatuapu.Model.Candidato> candidatos = new ArrayList<br.tatuapu.Model.Candidato>();
        int idC = 0;
        try {
            candidatos = dao.procura(candidato);
            //idC = candidatos.size();
            if (candidatos.size()==0){//opa, não existe este cabra, cadastrar-lhe-ei
               dao.salvar(candidato);//feito
               candidatos = dao.procura(candidato);
               idC = candidatos.get(0).getIdCandidato();
            }else{
                idC = candidatos.get(0).getIdCandidato();
            }
        } catch (Exception ex) {
            Logger.getLogger(CandidatoService.class.getName()).log(Level.SEVERE, null, ex);
            idC = 1990000;
       }
        return idC;
    }
    
}
