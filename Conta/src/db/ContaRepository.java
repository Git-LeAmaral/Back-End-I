package db;

import model.Conta;

import java.sql.Connection;

public class ContaRepository {

    private final Connection connection;

    public ContaRepository() throws Exception {
        this.connection = FactoryConnection.getConnection();
    }

    public Conta buscaContaPorId(String id) {
        return null;
    }

    public void excluiContaPorId(String id) {
        return null;
    }

    public Conta(Conta conta) {
        return ;
    }
}
