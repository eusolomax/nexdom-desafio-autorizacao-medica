package br.com.nexdom.service;

import br.com.nexdom.model.RegraAutorizacao;
import br.com.nexdom.repository.RegraAutorizacaoRepository;

public class AutorizacaoService {

   private final RegraAutorizacaoRepository repository = new RegraAutorizacaoRepository();

   public boolean autorizar(
         Integer procedimento,
         Integer idade,
         String sexo) {

      RegraAutorizacao regra = repository.buscarProcedimento(
            procedimento,
            idade,
            sexo);

      if (regra == null) {
         return false;
      }

      return regra.getPermitido();
   }
}