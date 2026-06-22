package br.com.nexdom.servlet;

import br.com.nexdom.repository.SolicitacaoAutorizacaoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/solicitacoes")
public class SolicitacoesServlet extends HttpServlet {

    private final SolicitacaoAutorizacaoRepository repository =
            new SolicitacaoAutorizacaoRepository();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute(
                "solicitacoes",
                repository.listarTodos());

        req.getRequestDispatcher(
                "/solicitacoes.jsp")
                .forward(req, resp);
    }
}