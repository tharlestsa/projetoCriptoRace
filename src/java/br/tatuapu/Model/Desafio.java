/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tatuapu
 */
public class Desafio {
    private final int idDesafio;
    private final String descricaoDesafio;
    private final int idContest;
    private final String status;
    private final int pontuacao;
    
    private List<RespDesafio> respDesafio;
    
    public Desafio(int id, String desc, int idC, String sta, int pont){
        idDesafio = id;
        descricaoDesafio = desc;
        idContest = idC;
        status = sta;
        pontuacao = pont;
        respDesafio = new ArrayList<RespDesafio>();
    }

    public void addRespDesafio(RespDesafio rD){
        respDesafio.add(rD);
    }
    
    /**
     * @return the idDesafio
     */
    public int getIdDesafio() {
        return idDesafio;
    }

    /**
     * @return the descricaoDesafio
     */
    public String getDescricaoDesafio() {
        return descricaoDesafio;
    }

    /**
     * @return the idContest
     */
    public int getIdContest() {
        return idContest;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the pontuacao
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * @return the respDesafio
     */
    public List<RespDesafio> getRespDesafio() {
        return respDesafio;
    }
}
