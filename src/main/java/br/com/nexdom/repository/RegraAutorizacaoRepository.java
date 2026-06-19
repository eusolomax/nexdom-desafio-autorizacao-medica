package br.com.nexdom.repository;

import br.com.nexdom.config.ConnectionConfig;
import br.com.nexdom.model.RegraAutorizacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegraAutorizacaoRepository {

   public RegraAutorizacao buscarProcedimento(
         Integer procedimento,
         Integer idade,
         String sexo
      ) {

      String sql = "SELECT * FROM regra_autorizacao WHERE procedimento = ? AND idade = ? AND sexo = ?";

      try (
            Connection connection = ConnectionConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

         statement.setInt(1, procedimento);
         statement.setInt(2, idade);
         statement.setString(3, sexo);

         ResultSet result = statement.executeQuery();

         if (result.next()) {

            RegraAutorizacao regra = new RegraAutorizacao();

            regra.setId(result.getLong("id"));
            
            regra.setProcedimento(result.getInt("procedimento"));
            
            regra.setIdade(result.getInt("idade"));
            
            regra.setSexo(result.getString("sexo"));
            
            regra.setPermitido(result.getBoolean("permitido"));

            return regra;
         }

      } catch (SQLException e) {
         throw new RuntimeException(
               "erro ao consultar autorização",
               e);
      }

      return null;
   }
}