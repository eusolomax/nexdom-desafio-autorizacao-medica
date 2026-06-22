package br.com.nexdom.service;

import br.com.nexdom.model.RegraAutorizacao;
import br.com.nexdom.model.SolicitacaoAutorizacao;
import br.com.nexdom.repository.SolicitacaoAutorizacaoRepository;
import br.com.nexdom.repository.RegraAutorizacaoRepository;

public class AutorizacaoService {

   private final RegraAutorizacaoRepository autorizacaoRepository;
   private final SolicitacaoAutorizacaoRepository solicitacaoRepository;

   public AutorizacaoService(
         RegraAutorizacaoRepository autorizacaoRepository,
         SolicitacaoAutorizacaoRepository solicitacaoRepository) {

      this.autorizacaoRepository = autorizacaoRepository;
      this.solicitacaoRepository = solicitacaoRepository;
   }

   public boolean autorizar(
         Integer procedimento,
         Integer idade,
         String sexo) {

      RegraAutorizacao regra = autorizacaoRepository.buscarProcedimento(
            procedimento,
            idade,
            sexo);

      if (regra == null) {
         return false;
      }

      SolicitacaoAutorizacao solicitacao = new SolicitacaoAutorizacao();

      solicitacao.setProcedimento(procedimento);
      solicitacao.setIdade(idade);
      solicitacao.setSexo(sexo);
      solicitacao.setAutorizado(regra.getPermitido());

      solicitacaoRepository.salvar(solicitacao);

      return regra.getPermitido();
   }
}