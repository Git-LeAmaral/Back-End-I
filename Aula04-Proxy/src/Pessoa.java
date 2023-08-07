import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String rg;
    private String nomeVacina;
    private LocalDate dataVacina;

    public Pessoa(String nome, String sobrenome, String rg, String nomeVacina, LocalDate dataVacina) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.nomeVacina = nomeVacina;
        this.dataVacina = dataVacina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(LocalDate dataVacina) {
        this.dataVacina = dataVacina;
    }
}
