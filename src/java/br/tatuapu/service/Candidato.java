/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
/**
 *
 * @author tatuapu
 */
public interface Candidato {
    //@WebMethod double getPontuacaoDoCandidato(int idCandidato, int idContest);
    //@WebMethod boolean checaCandidatoExistente(br.tatuapu.Model.Candidato candidato);
    @WebMethod int cadastraCandidato(int idCandidato, String nomeCompleto, String nick, String matriculaIFG, String cpf);
}
