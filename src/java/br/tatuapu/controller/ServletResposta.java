/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.controller;

import br.tatuapu.Model.RespostaEnviada;
import br.tatuapu.Model.ValidaRespSubmetida;
import br.tatuapu.Model.ValidaRespostaSubmetidaDAO;
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
@WebServlet(name = "ServletResposta", urlPatterns = {"/resposta.pvh"})
public class ServletResposta extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF8");
        sessao = request.getSession(true);
        Integer idCandidato = null;
        //Integer idCandidato = (Integer) sessao.getAttribute("idCandidato");
        if (idCandidato == null){
            Cookie[] cookies = request.getCookies();
            if(cookies!= null){
                for(Cookie c:cookies){                    
                    if(c.getName().equalsIgnoreCase("cookieIdCandidato")){ sessao.setAttribute("idCandidato", c.getValue()); idCandidato = Integer.parseInt(c.getValue());}
                    if(c.getName().equalsIgnoreCase("cookieNickCandidato")) sessao.setAttribute("nick", c.getValue());
                }
            }
        }
        
        RequestDispatcher rd=null;
        
        String cmd = request.getParameter("cmd");        
        
        if (cmd.equalsIgnoreCase("add")){
            String resposta = request.getParameter("resposta");
            
            if (resposta != null && resposta != ""){
                ValidaRespostaSubmetidaDAO dao = new ValidaRespostaSubmetidaDAO();
                RespostaEnviada respEnviada = new RespostaEnviada(idCandidato, 1, resposta);
                List<ValidaRespSubmetida> vrS = new ArrayList<ValidaRespSubmetida>();
               
                vrS = dao.procura(respEnviada);
                
                if (vrS.size()>0){
                    //opa, só vem com itens caso tenha acertado, ou caso tenha tentado enviar algo repetido
                    request.setAttribute("statusResposta", vrS.get(0).isStatus());
                    request.setAttribute("respostaSubmissao", vrS.get(0).getPontuacao());
                }else{
                    request.setAttribute("statusResposta", "erro");
                    request.setAttribute("respostaSubmissao", 0);
                }
                rd = request.getRequestDispatcher("respSubmitAnswer.jsp");
                rd.forward(request, response);
            }else{
                request.setAttribute("statusResposta", "vazio");
                request.setAttribute("respostaSubmissao", 0);
                rd = request.getRequestDispatcher("respSubmitAnswer.jsp");
                rd.forward(request, response);
                throw new Exception("Resposta inválida");              
                
            }
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletResposta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletResposta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
