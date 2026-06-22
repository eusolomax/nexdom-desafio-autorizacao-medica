package br.com.nexdom.service;

import br.com.nexdom.model.RegraAutorizacao;
import br.com.nexdom.repository.RegraAutorizacaoRepository;
import br.com.nexdom.repository.SolicitacaoAutorizacaoRepository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AutorizacaoServiceTest {

   @Test
   void autorizarQuandoRegraPermitir() {

      RegraAutorizacao regra = new RegraAutorizacao();
      regra.setPermitido(true);

      RegraAutorizacaoRepository regraRepository = mock(RegraAutorizacaoRepository.class);

      SolicitacaoAutorizacaoRepository solicitacaoRepository = mock(SolicitacaoAutorizacaoRepository.class);

      when(regraRepository.buscarProcedimento(
            4567,
            20,
            "M"))
            .thenReturn(regra);

      AutorizacaoService service = new AutorizacaoService(
            regraRepository,
            solicitacaoRepository);

      boolean resultado = service.autorizar(
            4567,
            20,
            "M");

      assertTrue(resultado);
   }

   @Test
   void negarQuandoRegraNaoPermitir() {

      RegraAutorizacao regra = new RegraAutorizacao();
      regra.setPermitido(false);

      RegraAutorizacaoRepository regraRepository = mock(RegraAutorizacaoRepository.class);

      SolicitacaoAutorizacaoRepository solicitacaoRepository = mock(SolicitacaoAutorizacaoRepository.class);

      when(regraRepository.buscarProcedimento(
            1234,
            10,
            "M"))
            .thenReturn(regra);

      AutorizacaoService service = new AutorizacaoService(
            regraRepository,
            solicitacaoRepository);

      boolean resultado = service.autorizar(
            1234,
            10,
            "M");

      assertFalse(resultado);
   }

   @Test
   void negarQuandoRegraNaoExistir() {

      RegraAutorizacaoRepository regraRepository = mock(RegraAutorizacaoRepository.class);

      SolicitacaoAutorizacaoRepository solicitacaoRepository = mock(SolicitacaoAutorizacaoRepository.class);

      when(regraRepository.buscarProcedimento(
            anyInt(),
            anyInt(),
            anyString()))
            .thenReturn(null);

      AutorizacaoService service = new AutorizacaoService(
            regraRepository,
            solicitacaoRepository);

      boolean resultado = service.autorizar(
            anyInt(),
            anyInt(),
            anyString());

      assertFalse(resultado);
   }
}