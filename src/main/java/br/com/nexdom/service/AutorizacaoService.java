package br.com.nexdom.service;

import br.com.nexdom.model.RegraAutorizacao;
import br.com.nexdom.model.SolicitacaoAutorizacao;
import br.com.nexdom.repository.RegraAutorizacaoRepository;
import br.com.nexdom.repository.SolicitacaoAutorizacaoRepository;

public class AutorizacaoService {

   private final RegraAutorizacaoRepository autorizacaoRepository = new RegraAutorizacaoRepository();
   private final SolicitacaoAutorizacaoRepository solicitacaoRepository = new SolicitacaoAutorizacaoRepository();

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