<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.nexdom.model.SolicitacaoAutorizacao" %>

<html>
   
   <head>
  <style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: Arial, Helvetica, sans-serif;
        background: #f4f6f9;
        color: #333;
        padding: 40px;
    }

    .container {
        max-width: 900px;
        margin: 0 auto;
    }

    .card {
        background: white;
        border-radius: 10px;
        padding: 30px;
        box-shadow: 0 2px 12px rgba(0,0,0,.08);
    }

    h1, h2 {
        margin-bottom: 20px;
        color: #1f2937;
    }

    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
    }

    input,
    select {
        width: 100%;
        padding: 10px;
        border: 1px solid #d1d5db;
        border-radius: 6px;
        margin-bottom: 20px;
    }

    button {
        background: #2563eb;
        color: white;
        border: none;
        padding: 12px 20px;
        border-radius: 6px;
        cursor: pointer;
        font-weight: bold;
    }

    button:hover {
        background: #1d4ed8;
    }

    a {
        text-decoration: none;
        color: #2563eb;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }

    .resultado {
        margin-top: 25px;
        padding: 15px;
        border-radius: 6px;
        background: #e5f3ff;
        border-left: 5px solid #2563eb;
        font-weight: bold;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        margin-top: 20px;
        box-shadow: 0 2px 12px rgba(0,0,0,.08);
    }

    th {
        background: #2563eb;
        color: white;
        padding: 12px;
    }

    td {
        padding: 12px;
        border-bottom: 1px solid #e5e7eb;
    }

    tr:nth-child(even) {
        background: #f9fafb;
    }

    .status-true {
        color: #16a34a;
        font-weight: bold;
    }

    .status-false {
        color: #dc2626;
        font-weight: bold;
    }
  </style>

      <title>Solicitações</title>
   </head>

<body>

<div class="container">

    <div style="margin-bottom:20px">
        <a href="index.jsp">← Voltar</a>
    </div>

    <h2>Solicitações de Autorização</h2>

    <table>

        <tr>
            <th>ID</th>
            <th>Procedimento</th>
            <th>Idade</th>
            <th>Sexo</th>
            <th>Status</th>
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

            <td>
                <span>
                    <%= solicitacao.getAutorizado() ? "Autorizado" : "Negado" %>
                </span>
            </td>
        </tr>

        <%
        }
        %>

    </table>

</div>

</body>
</html>