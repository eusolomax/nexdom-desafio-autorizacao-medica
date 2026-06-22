package br.com.nexdom.config;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.resource.ClassLoaderResourceAccessor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.DriverManager;

@WebListener
public class LiquibaseInitializer
            implements ServletContextListener {

      @Override
      public void contextInitialized(
                  ServletContextEvent sce) {

            try {

                  Class.forName("org.h2.Driver");
                  Connection connection = DriverManager.getConnection(
                              "jdbc:h2:./database/autorizacao",
                              "nexdom",
                              "");

                  Database database = DatabaseFactory.getInstance()
                              .findCorrectDatabaseImplementation(
                                          new liquibase.database.jvm.JdbcConnection(
                                                      connection));

                  Liquibase liquibase = new Liquibase(
                              "db/changelog/db.changelog-master.xml",
                              new ClassLoaderResourceAccessor(),
                              database);

                  liquibase.update(
                              new Contexts(),
                              new LabelExpression());

            } catch (Exception e) {
                  throw new RuntimeException(e);
            }
      }
}