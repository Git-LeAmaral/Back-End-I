import java.time.LocalDate;

public class ServicoVacinar implements Vacinar {


    @Override
    public String vacinar(String rg, LocalDate dataVacina, String nomeVacina) {
        System.out.println(
                """ 
                Usuário de RG: %s
                Foi Vacinado do dia: %s
                Com a Vacina: %s
                ---------------------------------------------------------------------
                """.formatted(rg, dataVacina, nomeVacina)
        );
        return "Usuario vacinado com sucesso";
    }
}
