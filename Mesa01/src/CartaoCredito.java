public class CartaoCredito {

    private String nome;
    private String numero;

    public CartaoCredito(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public boolean tem20Caracteres() {
        int quantidadeCaracteres = numero.length();
        return quantidadeCaracteres == 20;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
