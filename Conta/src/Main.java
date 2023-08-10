import db.ContaRepository;
import model.Conta;
import org.apache.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        log.info("Tudo funcionando até agora");

        Conta conta = new Conta("Leandro Amaral", "0000-0000-0000-0000", 300);

        String contaId = conta.getId();

        ContaRepository repository = new ContaRepository();
        repository.criarConta(conta);

        Conta contaConsultada = repository.buscaContaPorId(contaId);
        log.info("conta encontrada: " + contaConsultada);

        repository.excluiContaPorId(contaId);

        Conta contaQueNaoExiste = repository.buscaContaPorId(contaId);
        log.info("Buscamos uma conta que não existe, deve retornar nulo: " + contaQueNaoExiste);
    }
}