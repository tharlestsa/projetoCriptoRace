/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.Model;

/**
 *
 * @author tatuapu
 * int idCandidato, int idContest, String resposta
 */
public class RespostaEnviada {
    private final int idCandidato;
    private final int idContest;
    private final String resposta;
    public RespostaEnviada(int idCa, int idC, String rep){
        idCandidato = idCa;
        idContest = idC;
        resposta = rep;
    }

    /**
     * @return the idCandidato
     */
    public int getIdCandidato() {
        return idCandidato;
    }

    /**
     * @return the idContest
     */
    public int getIdContest() {
        return idContest;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }
}
