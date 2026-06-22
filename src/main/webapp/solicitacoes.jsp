<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.nexdom.model.SolicitacaoAutorizacao" %>

<html>
   <head>
      <title>Solicitações</title>
   </head>

   <body>

   <h2>Solicitações de Autorização</h2>

      <table border="1">
         <tr>
            <th>ID</th>
            <th>Procedimento</th>
            <th>Idade</th>
            <th>Sexo</th>
            <th>Autorizado</th>
         </tr>

      <%
      List<SolicitacaoAutorizacao> solicitacoes =
            (List<SolicitacaoAutorizacao>)
                     request.getAttribute("solicitacoes");

      for(SolicitacaoAutorizacao solicitacao : solicitacoes){
      %>

      <tr>
         <td><%= solicitacao.getId() %></td>
         <td><%= solicitacao.getProcedimento() %></td>
         <td><%= solicitacao.getIdade() %></td>
         <td><%= solicitacao.getSexo() %></td>
         <td><%= solicitacao.getAutorizado() %></td>
      </tr>

      <%
      }
      %>

      </table>

   <br>

   <a href="index.jsp">
      Voltar
   </a>

   </body>
</html>