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
public class Ranking {
    private final Candidato candidato;
    private int pontuacao;
    public Ranking(Candidato candidato, int pontuacao){
        this.candidato = candidato;
        this.pontuacao = pontuacao;
    }

    /**
     * @return the candidato
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * @return the pontuacao
     */
    public int getPontuacao() {
        return pontuacao;
    }
}
