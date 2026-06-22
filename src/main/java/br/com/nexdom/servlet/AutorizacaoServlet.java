package br.com.nexdom.servlet;

import br.com.nexdom.service.AutorizacaoService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/autorizacao")
public class AutorizacaoServlet extends HttpServlet {

        private final AutorizacaoService service = new AutorizacaoService();

        @Override
        protected void doPost(
                        HttpServletRequest req,
                        HttpServletResponse resp) throws ServletException, IOException {

                Integer procedimento = Integer.parseInt(
                                req.getParameter("procedimento"));

                Integer idade = Integer.parseInt(
                                req.getParameter("idade"));

                String sexo = req.getParameter("sexo");

                boolean autorizado = service.autorizar(
                                procedimento,
                                idade,
                                sexo);

                req.setAttribute(
                                "resultado",
                                autorizado ? "AUTORIZADO" : "NEGADO");

                req.getRequestDispatcher("/index.jsp")
                                .forward(req, resp);
        }
}