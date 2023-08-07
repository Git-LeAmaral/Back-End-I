import menu.Menu;
import menu.MenuHappyHour;
import menu.MenuInfantil;
import menu.MenuPadrao;

import java.util.List;

public class Pedido {

    List<Menu> menus;

    public Pedido(List<Menu> menus) {
        this.menus = menus;
    }

    public float calcularTotal() {
        float resultado = 0;
        for (Menu menu: this.menus) {

            if (menu instanceof MenuPadrao) {
                System.out.println("Menu padrão selecionando, será adicionado a compra o seguinte valor: " + menu.preparar());
            }

            if (menu instanceof MenuInfantil menuInfantil) {
                System.out.println("Menu infantil selecionando!");
                System.out.println("Nome do brinquedo adequirido: " + menuInfantil.getNomeBrinquedo());
                System.out.println("Preço unitário do brinquedo: " + menuInfantil.getValorAgregado());
                System.out.println("será adicionado a compra o seguinte valor: " + menu.preparar());
            }

            if (menu instanceof MenuHappyHour) {
                MenuHappyHour happyHour = (MenuHappyHour) menu;
                System.out.println("Menu happyhour selecionando!");
                System.out.println("Hoje é: " + happyHour.diaDaSemana());
                System.out.println("será adicionado a compra o seguinte valor: " + menu.preparar());
            }

            System.out.println("---------------------------------------------------------------------");
            resultado += menu.preparar();
            System.out.println("---------------------------------------------------------------------");
        }
        return resultado;
    }
}
