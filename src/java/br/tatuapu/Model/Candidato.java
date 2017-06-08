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
public class Candidato {
    private final int idCandidato;
    private final String nomeCompleto;
    private final String nick;
    private final String matriculaIFG;
    private final String cpf;
    public Candidato(int id, String nm, String nk, String mat, String c){
        idCandidato = id;
        nomeCompleto = nm;
        nick = nk;
        matriculaIFG = mat;
        cpf = c;
    }

    /**
     * @return the idCandidato
     */
    public int getIdCandidato() {
        return idCandidato;
    }

    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @return the matriculaIFG
     */
    public String getMatriculaIFG() {
        return matriculaIFG;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }
}
