/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.controller;

import br.tatuapu.Model.CandidatoDAO;
import br.tatuapu.service.CandidatoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tatuapu
 */
@WebServlet(name = "ServletCadastro", urlPatterns = {"/cadastro.pvh"})
public class ServletCadastro extends HttpServlet {
    private HttpSession sessao;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            this.sessao = request.getSession();
            
             RequestDispatcher rd = null; //setando o objeto "despachador"
             String nomeCandidato=null;
            
            String nomeCompleto = request.getParameter("nome");
            String nick = request.getParameter("nick");
            String matriculaIFG = request.getParameter("matricula");
            
            br.tatuapu.Model.Candidato candidato = new br.tatuapu.Model.Candidato(0, nomeCompleto, nick, matriculaIFG, "");
            CandidatoDAO dao = new CandidatoDAO();
            List<br.tatuapu.Model.Candidato> candidatos = new ArrayList<br.tatuapu.Model.Candidato>();
            int idC = 0;
            try {
                candidatos = dao.procura(candidato);//procurando para saber se temos alguém assim cadastrado
                //idC = candidatos.size();
                if (candidatos.size()==0){//opa, não existe este cabra, cadastrar-lhe-ei
                   dao.salvar(candidato);//feito
                   candidatos = dao.procura(candidato);
                   idC = candidatos.get(0).getIdCandidato();
                   nomeCandidato = candidatos.get(0).getNick();
                }else{
                   idC = candidatos.get(0).getIdCandidato();
                   nomeCandidato = candidatos.get(0).getNick();
                }
            } catch (Exception ex) {
                Logger.getLogger(CandidatoService.class.getName()).log(Level.SEVERE, null, ex);
                idC = 1990000;
           }
           if(sessao.getAttribute("idCandidato") == null || sessao.getAttribute("idCandidato").equals("0") || sessao.getAttribute("idCandidato").equals(1990000)){
               //se entrar aqui, é pq não está devidamente logado
               if(idC != 0 && idC!= 1990000){
                    sessao.setAttribute("idCandidato", idC);
                    sessao.setAttribute("nick", nomeCandidato);
                    Cookie cookieIdCandidato = new Cookie("cookieIdCandidato", Integer.toString(idC));
                    Cookie cookieNickCandidato = new Cookie("cookieNickCandidato", nomeCandidato);
                    cookieIdCandidato.setMaxAge(604800);
                    cookieNickCandidato.setMaxAge(604800);
                    response.addCookie(cookieIdCandidato);
                    response.addCookie(cookieNickCandidato);
               }     
           }
           rd = request.getRequestDispatcher("index.jsp");
           //despachando para a página setada, segundo as opções acima
           rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
