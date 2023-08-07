package menu;

public abstract class Menu {
    private float preco;
    private String descricao;

    public Menu(String descricao, float preco) {
        this.preco = preco;
        this.descricao = descricao;
    }

    public abstract float preparar();

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
