<%-- 
    Document   : contests
    Created on : 16/04/2017, 09:00:11
    Author     : tatuapu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CriptoRace - Gestor</title> 
        <style>
            .autor{width:100%; clear:both;}
            .idAutor{width:60px; float:left;}
            .nmAutor{width:200px; float:left;}
        </style>
    </head>
    <body>
        <h1>CriptoRace - Gestor</h1>
        <div style="padding:10px; background-color: #cccccc; text-align: center;">
            
        </div>
        <div style="padding: 10px; margin:10px;">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome Completo</th>
                    <th>Nick</th>
                    <th>Matrícula IFG</th>
                    <th>CPF</th>
                </tr>
                <c:forEach var="lista" items="${ requestScope.candidatoList }">
                    <tr>
                        <td>${lista.idCandidato}</td>
                        <td>${lista.nomeCompleto}</td>                     
                        <td>${lista.nick}</td>
                        <td>${lista.matriculaIFG}</td>
                        <td>${lista.cpf}</td>
                    </tr>                    
                </c:forEach>
            </table> 
        </div>
    </body>
</html>
