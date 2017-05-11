<%
    HttpSession sessao = request.getSession();
    
    if (sessao.getAttribute("idCandidato")== null){
        response.sendRedirect("index.jsp");
    }
    //sessao.setAttribute(string, o);
    //sessao.getAttribute(string);
    response.setContentType("text/html;charset=UTF-8");
 %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="formulario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/template/head.jsp" %>
    </head>
    <body>
        <!-- início do corpo do site -->
        <div class="container">
            <!-- <%@include file="/template/cabecalho.jsp" %> -->
            <c:import url="/template/cabecalho.jsp" />
            <br />
            <div class="row">
                <h3>Envio de Resposta</h3>
                <div class="col-md-12">  
                    <form method="POST" action="resposta.pvh">
                        <div class="form-group">
                            <label for="resposta" class="label label-warning">Resposta</label>
                            <input class="form-control input-lg" id="resposta" name="resposta" type="text">
                            <input type="hidden" id="cmd" name="cmd" value="add">
                            <button type="submit" class="btn btn-lg btn-block btn-danger">Submeter Resposta</button>
                        </div>
                    </form>
                      
                      <br />
                      <a href="controlador.pvh?cmd=ranking" class="btn btn-primary btn-lg btn-block">Ranking</a>
                </div>
            </div>
            <br />
            <br />
            <%@include file="/template/rodape.jsp" %>
        </div><!-- /container -->
    </body>
</html>
