<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <body>
    <h2>Autorização Médica</h2>

    <form action="autorizacao" method="post">
      Procedimento: <input type="number" name="procedimento" />

      <br/><br/>

      Idade: <input type="number" name="idade" />

      <br /><br />

      Sexo:
      <select name="sexo">
        <option value="M">Masculino</option>
        <option value="F">Feminino</option>
      </select>

      <br /><br />

      <button type="submit">Validar</button>
    </form>
    
    <%
      String resultado = (String) request.getAttribute("resultado");
      if(resultado != null){ 
    %>
        <h2><%= resultado %></h2>
    <%
      }
    %>
  </body>
</html>
