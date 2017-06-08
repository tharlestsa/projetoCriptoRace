/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tatuapu.controller;

import br.tatuapu.Model.CandidatoDAO;
import br.tatuapu.Model.ContestDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tatuapu
 */
@WebServlet(name = "ServletCandidato", urlPatterns = {"/ServletCandidato"})
public class ServletCandidato extends HttpServlet {

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
        String cmd = request.getParameter("cmd");
        DAO dao;                
                
        //setando o valor default do cmd
        if(cmd==null)
            cmd = "principal";
        
        try{
            dao = new CandidatoDAO();
            RequestDispatcher rd = null; //setando o objeto "despachador"
            if(cmd.equalsIgnoreCase("listar")){
                List candidatoList = dao.listaTodos();//recebendo o ArrayList com todos autores
                request.setAttribute("candidatoList", candidatoList);//enviando parâmetros via request
                //setando o despachador
                rd = request.getRequestDispatcher("candidato.jsp");
            }else if(cmd.equalsIgnoreCase("update")){
//                Autor autor;
//                Integer id = Integer.parseInt(request.getParameter("id"));//pegando o param id
//                List autorList = dao.procura(new Autor(null,null,id));
//                request.setAttribute("autorList", autorList);
//                rd = request.getRequestDispatcher("/alteraAutores.jsp");
            }else if(cmd.equalsIgnoreCase("saveUpdate")){
//                Integer id = Integer.parseInt(request.getParameter("idAutor"));
//                String nomeAutor = request.getParameter("nomeAutor");
//                String nmCitacao = request.getParameter("nmCitacao");
//                Autor autor = new Autor(nomeAutor, nmCitacao, id);
//                dao.atualizar(autor);
//                rd = request.getRequestDispatcher("/autores?cmd=listar");
            }else if(cmd.equalsIgnoreCase("del")){
//                Integer id = Integer.parseInt(request.getParameter("id"));
//                Autor autor = new Autor(null,null,id);
//                dao.excluir(autor);
//                rd = request.getRequestDispatcher("/autores?cmd=listar");
            }else if(cmd.equalsIgnoreCase("add")){
                rd = request.getRequestDispatcher("/addAutor.jsp");
            }else if(cmd.equalsIgnoreCase("saveAdd")){
//                String nomeAutor = request.getParameter("nomeAutor");
//                String nmCitacao = request.getParameter("nmCitacao");
//                Autor autor = new Autor(nomeAutor, nmCitacao, 0);
//                dao.salvar(autor);
//                rd = request.getRequestDispatcher("/autores?cmd=listar");
            }else{
                rd = request.getRequestDispatcher("/index.html");
            }
            //despachando para a página setada, segundo as opções acima
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
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
