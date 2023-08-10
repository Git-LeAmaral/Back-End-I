package db;

import model.Conta;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaRepository {
    private static final Logger log = Logger.getLogger(ContaRepository.class);
    private static final String SQL_BUSCA_POR_ID = "SELECT * FROM Conta WHERE id = ?";
    private static final String SQL_DELETE_POR_ID = "DELETE FROM Conta WHERE id = ?";
    private static final String SQL_DE_CRIACAO = """
                INSERT INTO Conta(id, nome, numero, saldo)
                VALUES(?, ?, ?, ?);
            """;

    private final Connection connection;

    public ContaRepository() throws Exception {  //Nesse método a conexão esta sendo iniciada
         this.connection = FactoryConnection.getConnection();
    }

    public Conta buscaContaPorId(String id) {
        log.info("Buscando uma conta por id:" + id);

        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_BUSCA_POR_ID)){
            preparedStatement.setString(1, id);

            log.info("Executando select por id");
            ResultSet resultSet = preparedStatement.executeQuery();
            Conta conta = null;

            log.info("Lendo resultado encontrado");
            while (resultSet.next()) {
                conta = new Conta(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4));
            }
            return conta;
        } catch (Exception e){
            log.error(e);
            return null;
        }
    }

    public void excluiContaPorId(String id) {
        log.info("Excluindo uma conta por id:" + id);

        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_POR_ID)){
            preparedStatement.setString(1, id);

            log.info("Executando exclusão por id");
            preparedStatement.executeUpdate();
        } catch (Exception e){
            log.error(e);
        }
    }

    public Conta criarConta(Conta conta) {

        log.info("Criando conta");

        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DE_CRIACAO)){
            preparedStatement.setString(1, conta.getId());
            preparedStatement.setString(2, conta.getNome());
            preparedStatement.setString(3, conta.getNumero());
            preparedStatement.setInt(4, conta.getSaldo());

            log.info("Executando crianção");
            preparedStatement.executeUpdate();
            log.info("conta criada com os seguintes valores:\n id: %s | nome: %s | numero: %s | saldo: %d"
                    .formatted(conta.getId(), conta.getNome(), conta.getNumero(), conta.getSaldo()));
            return conta;
        } catch (Exception e){
            log.error(e);
            return null;
        }

    }
}
