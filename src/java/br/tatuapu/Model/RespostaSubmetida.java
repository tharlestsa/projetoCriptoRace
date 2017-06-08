/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.Model;

/**
 *
 * @author tatuapu
 */
public class RespostaSubmetida {
    private final int idRespSubmetida;
    private final String respostaSubmetida;
    private final int idCandidato;
    private final int idDesafio;
    public RespostaSubmetida(int idRS, String resp, int idC, int idD){
        idRespSubmetida = idRS;
        respostaSubmetida = resp;
        idCandidato = idC;
        idDesafio = idD;        
    }

    /**
     * @return the idRespSubmetida
     */
    public int getIdRespSubmetida() {
        return idRespSubmetida;
    }

    /**
     * @return the respostaSubmetida
     */
    public String getRespostaSubmetida() {
        return respostaSubmetida;
    }

    /**
     * @return the idCandidato
     */
    public int getIdCandidato() {
        return idCandidato;
    }

    /**
     * @return the idDesafio
     */
    public int getIdDesafio() {
        return idDesafio;
    }
}
