package menu;

public class MenuPadrao extends Menu {

    public MenuPadrao(String descricao, float preco) {
        super(descricao, preco);
    }

    @Override
    public float preparar() {
        //System.out.println("Menu padrão: preparando prato padrão");
        return getPreco();
    }
}
