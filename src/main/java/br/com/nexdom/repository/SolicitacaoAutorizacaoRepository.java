package br.com.nexdom.repository;

import br.com.nexdom.config.ConnectionConfig;
import br.com.nexdom.model.SolicitacaoAutorizacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class SolicitacaoAutorizacaoRepository {

      public void salvar(
                  SolicitacaoAutorizacao solicitacao) {

            String sql = "INSERT INTO solicitacao_autorizacao (procedimento, idade, sexo, autorizado) VALUES (?, ?, ?, ?)";

            try (
                        Connection connection = ConnectionConfig.getConnection();

                        PreparedStatement statement = connection.prepareStatement(sql)) {

                  statement.setInt(
                              1,
                              solicitacao.getProcedimento());

                  statement.setInt(
                              2,
                              solicitacao.getIdade());

                  statement.setString(
                              3,
                              solicitacao.getSexo());

                  statement.setBoolean(
                              4,
                              solicitacao.getAutorizado());

                  statement.executeUpdate();

            } catch (SQLException e) {

                  throw new RuntimeException(
                              "Erro ao salvar solicitação",
                              e);
            }
      }

      public List<SolicitacaoAutorizacao> listarTodos() {

            List<SolicitacaoAutorizacao> solicitacoes = new ArrayList<>();

            String sql = "SELECT * FROM solicitacao_autorizacao";

            try (
                        Connection connection = ConnectionConfig.getConnection();

                        PreparedStatement statement = connection.prepareStatement(sql);

                        ResultSet result = statement.executeQuery()
                  ) {

                  while (result.next()) {

                        SolicitacaoAutorizacao solicitacao = new SolicitacaoAutorizacao();

                        solicitacao.setId(
                                    result.getLong("id"));

                        solicitacao.setProcedimento(
                                    result.getInt("procedimento"));

                        solicitacao.setIdade(
                                    result.getInt("idade"));

                        solicitacao.setSexo(
                                    result.getString("sexo"));

                        solicitacao.setAutorizado(
                                    result.getBoolean("autorizado"));

                        solicitacoes.add(solicitacao);
                  }

            } catch (SQLException e) {

                  throw new RuntimeException(
                              "Erro ao listar solicitações",
                              e);
            }

            return solicitacoes;
      }
}