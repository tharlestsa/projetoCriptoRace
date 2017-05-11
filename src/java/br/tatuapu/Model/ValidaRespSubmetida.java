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
public class ValidaRespSubmetida {
    private AcertoCandidato acertoCandidato;
    private RespDesafio respDesafio;
    private RespostaSubmetida respostaSubmetida;
    private Candidato candidato;
    private boolean status = false;
    private int pontuacao = 0;

    /**
     * @return the acertoCandidato
     */
    public AcertoCandidato getAcertoCandidato() {
        return acertoCandidato;
    }

    /**
     * @param acertoCandidato the acertoCandidato to set
     */
    public void setAcertoCandidato(AcertoCandidato acertoCandidato) {
        this.acertoCandidato = acertoCandidato;
    }

    /**
     * @return the respDesafio
     */
    public RespDesafio getRespDesafio() {
        return respDesafio;
    }

    /**
     * @param respDesafio the respDesafio to set
     */
    public void setRespDesafio(RespDesafio respDesafio) {
        this.respDesafio = respDesafio;
    }

    /**
     * @return the respostaSubmetida
     */
    public RespostaSubmetida getRespostaSubmetida() {
        return respostaSubmetida;
    }

    /**
     * @param respostaSubmetida the respostaSubmetida to set
     */
    public void setRespostaSubmetida(RespostaSubmetida respostaSubmetida) {
        this.respostaSubmetida = respostaSubmetida;
    }

    /**
     * @return the candidato
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * @param candidato the candidato to set
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the pontuacao
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * @param pontuacao the pontuacao to set
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
