package menu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class MenuHappyHour extends Menu {

    public MenuHappyHour(String descricao, float preco) {
        super(descricao, preco);
    }

    @Override
    public float preparar() {
        //System.out.println("Menu happyhour: preparando prato");
        //return dayOfWeek.equals(DayOfWeek.THURSDAY) ? getPreco() * 0.8f : getPreco();
        if (diaDaSemana().equals(DayOfWeek.THURSDAY)) {
            System.out.println("Hoje é dia!!! Desconto aplicado");
            return BigDecimal.valueOf(getPreco() * 0.8f).setScale(2, RoundingMode.HALF_DOWN).floatValue();
        }
        return getPreco();
    }

    public DayOfWeek diaDaSemana() {
        return LocalDate.now().getDayOfWeek();
    }
}
