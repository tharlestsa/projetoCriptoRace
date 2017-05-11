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
public class RespDesafio {
    private final int idResp;
    private final String resposta;
    private final int idDesafio;
    
    public RespDesafio(int idR, String resp, int idD){
        idResp = idR;
        resposta = resp;
        idDesafio = idD;
    }

    /**
     * @return the idResp
     */
    public int getIdResp() {
        return idResp;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @return the idDesafio
     */
    public int getIdDesafio() {
        return idDesafio;
    }
}
