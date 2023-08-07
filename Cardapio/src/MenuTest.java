import menu.Menu;
import menu.MenuHappyHour;
import menu.MenuInfantil;
import menu.MenuPadrao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    public void dadoUmMenuPadrao_quandoCompramos_entaoCalcularPrecoApenasDoPrato() {
        //dado
        float esperadoAPagar = 27.50f;
        //menu.Menu padrao = new menu.Menu("Hamburger", 27,50f); Nunca implementar classes abstratas
        Menu padrao = new MenuPadrao("Hambuger", 27.50f);
        //quando
        float aPagar = padrao.preparar(); //pegar o produto e devolver o valor
        //entao
        Assertions.assertEquals(esperadoAPagar, aPagar);
    }

    @Test
    public void dadoUmMenuInfantil_quandoCompramos_entaoCalcularPrecoDoPratoEBoneco() {
        //dado
        float esperadoAPagar = 86.40f;
        Menu infantil = new MenuInfantil("MiniBurger", 16.50f, "Mickey", 69.90f);
        //quando
        float aPagar = infantil.preparar();
        //então
        Assertions.assertEquals(esperadoAPagar, aPagar);
    }

    @Test
    public void dadoUmMenuHappyHour_quandoCompramos_entaoCalcularPrecoComDesconto() {
        //dado
        float esperadoAPagar = 47.92f;
        Menu happyHour = new MenuHappyHour("Rodizio Hambuger", 59.90f);
        //quando
        float aPagar = happyHour.preparar();
        //então
        Assertions.assertEquals(esperadoAPagar, aPagar);
    }
}