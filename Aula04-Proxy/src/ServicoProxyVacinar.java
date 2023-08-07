import java.time.LocalDate;

public class ServicoProxyVacinar implements Vacinar {
    private final Vacinar servicoVacinar = new ServicoVacinar();
    @Override
    public String vacinar(String rg, LocalDate dataVacina, String nomeVacina) {
        System.out.println("Validando cidadão!");

        boolean dataVacinaAntesDeHoje = dataVacina.isBefore(LocalDate.now());
        if (dataVacinaAntesDeHoje) {

            servicoVacinar.vacinar(rg, dataVacina, nomeVacina);
            System.out.println("Cidadão validado com sucesso");
            return "cidadão vacinado com proxy";
        }
        System.out.println("Cidadao inválido, vacinação interrompida!");
        return "Cidadão não vacinado com proxy";
    }
}
