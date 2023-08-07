import menu.Menu;
import menu.MenuHappyHour;
import menu.MenuInfantil;
import menu.MenuPadrao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    public void check() {
        Menu padrao = new MenuPadrao("Hambuger", 27.50f);
        Menu infantil = new MenuInfantil("MiniBurger", 16.50f, "Mickey", 69.90f);
        Menu happyHour = new MenuHappyHour("Rodizio Hambuger", 59.90f);

        List<Menu> menus = List.of(padrao, infantil, happyHour);
        Pedido pedido = new Pedido(menus);

        float resultado = pedido.calcularTotal();
        Assertions.assertEquals(0, resultado);
    }
}