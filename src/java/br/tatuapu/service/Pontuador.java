package br.tatuapu.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public interface Pontuador {

    @WebMethod double getPontuacaoDoCandidato(int idCandidato, int idContest);

    @WebMethod boolean pontua(int idCandidato, int idContest, String resposta);
    
}
