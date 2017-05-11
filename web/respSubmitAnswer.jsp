<%

    HttpSession sessao = request.getSession();
    //out.println("Pegou a sessão");
    if (sessao.getAttribute("idCandidato")!= null){
        Cookie[] cookies = request.getCookies();
        //out.println("Quantidade antes: "+request.getCookies().length);
        if(cookies!= null){
            //out.println("vai tentar criar os cookies");
            if(cookies.length <=1 ){
                //out.println("Criando os cookies a partir dos dados da sessão");
                //Integer id = (Integer) sessao.getAttribute("idCandidato");
                Cookie cookieIdCandidato = new Cookie("cookieIdCandidato", sessao.getAttribute("idCandidato").toString());
                Cookie cookieNickCandidato = new Cookie("cookieNickCandidato", (String) sessao.getAttribute("nick"));
                cookieIdCandidato.setMaxAge(604800);
                cookieNickCandidato.setMaxAge(604800);
                response.addCookie(cookieIdCandidato);
                response.addCookie(cookieNickCandidato);
            }    
        }
    }else{
        //out.println("entrou no else");
        Cookie[] cookies = request.getCookies();
        if(cookies!= null){
            //out.println("cookies não é nulo. Agora vai tentar varrer os cookies\n\n Tamanho de cookies:"+cookies.length);
            for(Cookie c:cookies){
                //out.println("varrendo os cookies");
                //out.println(c.getName() + " - " + c.getValue());
                if(c.getName().equalsIgnoreCase("cookieIdCandidato")) sessao.setAttribute("idCandidato", c.getValue());
                if(c.getName().equalsIgnoreCase("cookieNickCandidato")) sessao.setAttribute("nick", c.getValue());
            }
        }    
    }       
         
    
    //processando o resultado da submissão
    
    String statusResposta = request.getAttribute("statusResposta").toString();
    String respostaHTML = null;
    
    String bodyCSS = "body{background-color: #4F4F4F;}";//cor normal

    int respostaSubmissao = Integer.parseInt(request.getAttribute("respostaSubmissao").toString());
    if (statusResposta.equals("erro")){
        respostaHTML = "<h3>Infelizmente você não acertou! Não desanime!</h3>";
        bodyCSS = "body{background-color: pink;}";
    }else if(statusResposta.equals("false") && respostaSubmissao == -1000){
        respostaHTML = "<h3>Há! Malandragem!!! Não vale mandar de novo!</h3>";
        bodyCSS = "body{background-color: red;}";
    }else if(statusResposta.equals("true") && respostaSubmissao > 0){
        respostaHTML = "<h3>ACERTOU!!!!</h3>";
        respostaHTML += "<h3>Este item lhe rendeu "+respostaSubmissao+" pontos!!</h3>";
        bodyCSS = "body{background-color: yellow;}";
    }else if(statusResposta.equals("vazio")){
        respostaHTML = "<h3>ERRO - Preencha corretamente o campo antes de enviar sua resposta!</h3>";
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
        <style>
            <%= bodyCSS %>
        </style>
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
                    
                      <a href="submitAnswer.jsp" class="btn btn-primary btn-lg btn-block">Enviar Resposta</a>
                      <br />
                      <a href="controlador.pvh?cmd=ranking" class="btn btn-primary btn-lg btn-block">Ranking</a>
                      
                      
                      
                    <%
                            out.println(respostaHTML);
                        }else{
                            response.sendRedirect("index.jsp");
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
