public class Pessoa {

    private String nome;
    private Integer idade;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public boolean isMaior18() {
        System.out.println(nome + " é maior de 18 anos");
        return this.idade > 18;
    }

    public boolean temMaisDe5Letras() {
        int quantidadeDeLetras = this.nome.length();
        if (quantidadeDeLetras > 5) {
            System.out.println(nome + " tem mais de 5 caracteres");
        } else {
            System.out.println(nome + " não tem mais de 5 caracteres");
        }
        return quantidadeDeLetras > 5;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
