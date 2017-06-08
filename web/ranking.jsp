<%@page import="java.util.ArrayList"%>
<%@page import="br.tatuapu.Model.Ranking"%>
<%@page import="java.util.List"%>
<%
    HttpSession sessao = request.getSession();
    //sessao.setAttribute(string, o);
    //sessao.getAttribute(string);
 %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="formulario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/template/head.jsp" %>
        <title>CriptoRACE - V 1.0 - 2k17 - Ranking</title>
    </head>
    <body>
        <!-- início do corpo do site -->
        <div class="container">
            <!-- <%@include file="/template/cabecalho.jsp" %> -->
            <c:import url="/template/cabecalho.jsp" />
            <br />
            <div class="row">
                
                <div class="col-md-12 texto-preto">                     
                      <a href="submitAnswer.jsp" class="btn btn-primary btn-lg btn-block">Enviar Resposta</a>
                      <br />
                      <table class="table">  
                        <% 
                           int contador = 1;
                        %>
                        <thead>
                            <tr>
                              <th>#</th>
                              <th>Nick</th>
                              <th>Pontuação</th>
                            </tr>
                          </thead>
                          <tbody>
                        <c:forEach var="lista" items="${ requestScope.rankingList }">
                            <tr>
                                <th scope="row"><%= contador++ %> º</th>
                                <td>${lista.candidato.nick}</td>                     
                                <td>${lista.pontuacao}</td>
                            </tr>                    
                        </c:forEach>
                          </tbody>
                    </table> 
                </div>
            </div>
            <br />
            <br />
            <%@include file="/template/rodape.jsp" %>
        </div><!-- /container -->
    </body>
</html>
