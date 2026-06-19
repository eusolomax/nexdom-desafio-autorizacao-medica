package br.com.nexdom;

import br.com.nexdom.model.RegraAutorizacao;
import br.com.nexdom.repository.RegraAutorizacaoRepository;

public class TesteRepository {

    public static void main(String[] args) {

        RegraAutorizacaoRepository repository = new RegraAutorizacaoRepository();

        RegraAutorizacao regra = repository.buscarProcedimento(
                6789,
                10,
                "F");

        if (regra != null) {
            System.out.println("procedimento: " + regra.getProcedimento());
            System.out.println("Permitido: " + regra.getPermitido());
        } else {
            System.out.println("regra nao encontrada");
        }
    }
}