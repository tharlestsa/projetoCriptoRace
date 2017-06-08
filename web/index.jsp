<%

    HttpSession sessao = request.getSession();
    
    
    if (sessao.getAttribute("idCandidato")!= null){
        Cookie[] cookies = request.getCookies();
        if(cookies!= null){
            if(cookies.length <=1 ){
                Cookie cookieIdCandidato = new Cookie("cookieIdCandidato", sessao.getAttribute("idCandidato").toString());
                Cookie cookieNickCandidato = new Cookie("cookieNickCandidato", (String) sessao.getAttribute("nick"));
                cookieIdCandidato.setMaxAge(604800);
                cookieNickCandidato.setMaxAge(604800);
                response.addCookie(cookieIdCandidato);
                response.addCookie(cookieNickCandidato);
                response.sendRedirect("index.jsp");
            }    
        }
    }else{
        Cookie[] cookies = request.getCookies();
        if(cookies!= null){
            for(Cookie c:cookies){
                if(c.getName().equalsIgnoreCase("cookieIdCandidato")) sessao.setAttribute("idCandidato", c.getValue());
                if(c.getName().equalsIgnoreCase("cookieNickCandidato")) sessao.setAttribute("nick", c.getValue());
            }
        }    
    }       
         
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
    </head>
    <body>
        <!-- início do corpo do site -->
        <div class="container">
            <!-- <%@include file="/template/cabecalho.jsp" %> -->
            <c:import url="/template/cabecalho.jsp" />
            <br />
            <div class="row">
                
                <div class="col-md-12">    
                    <%
                        if (sessao.getAttribute("idCandidato")!= null){
                    %>    
                    <script>alert('Olá <%= sessao.getAttribute("nick") %>');</script>
                      <a href="submitAnswer.jsp" class="btn btn-primary btn-lg btn-block">Enviar Resposta</a>
                      <br />
                      <a href="controlador.pvh?cmd=ranking" class="btn btn-primary btn-lg btn-block">Ranking</a>
                    <%
                        }else{
                    %>  
                    <h3>Cadastro de Candidato</h3>
                    <form method="POST" action="cadastro.pvh">
                        <div class="form-group">
                            <label for="nome" class="label label-warning">Nome Completo</label>
                            <input class="form-control input-lg" id="nome" name="nome" type="text">
                            <label for="nick" class="label label-warning">Nick</label>
                            <input class="form-control input-lg" id="nick" name="nick" type="text">
                            <label for="matricula" class="label label-warning">Matrícula IFG</label>
                            <input class="form-control input-lg" id="matricula" name="matricula" type="text">                            
                            
                            <button type="submit" class="btn btn-lg btn-block btn-danger">Cadastrar e Entrar</button>
                        </div>
                    </form>
                    <%
                        }
                    %> 
                </div>
            </div>
            <br />
            <br />
            <%@include file="/template/rodape.jsp" %>
        </div><!-- /container -->
    </body>
</html>
