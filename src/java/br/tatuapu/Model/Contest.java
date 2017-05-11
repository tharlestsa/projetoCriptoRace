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
public class Contest {
    private final int idContest;
    private final String nomeContest;
    private final String status;
    private final String loc;
    public Contest(int id, String nm, String st, String lo){
        idContest = id;
        nomeContest = nm;
        status = st;
        loc = lo;
    }

    /**
     * @return the idContest
     */
    public int getIdContest() {
        return idContest;
    }

    /**
     * @return the nomeContest
     */
    public String getNomeContest() {
        return nomeContest;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }
}
