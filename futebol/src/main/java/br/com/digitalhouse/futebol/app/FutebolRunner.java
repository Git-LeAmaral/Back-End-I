package br.com.digitalhouse.futebol.app;

import br.com.digitalhouse.futebol.domain.entity.Futebol;
import br.com.digitalhouse.futebol.domain.service.FutebolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
@Slf4j
@Component
public class FutebolRunner implements CommandLineRunner {

    private final FutebolService futebolService;

    public FutebolRunner(FutebolService futebolService) {
        this.futebolService = futebolService;
    }

    @Override
    public void run(String... args) throws Exception {
        /* Todo: 05/09/2023
        Gostaria de buscar todos os futebol do dia 20 de agosto de 2023
        Gostaria de buscar  o futebol com o nome Premier League
        */

        futebolService.criarFutebol( new Futebol("Premier League", LocalDate.of(2023, Month.AUGUST, 20)));
        futebolService.criarFutebol( new Futebol("League One", LocalDate.of(2023, Month.AUGUST, 20)));
        futebolService.criarFutebol( new Futebol("La Liga", LocalDate.of(2023, Month.AUGUST, 20)));

        /*
        LocalDate data = LocalDate.of(2023, Month.AUGUST, 20);
        log.info("buscando pela data {}", data);
        futebolService.buscarFutebolPorData(data)
                .forEach(futebolRetornado -> {
                    log.info("Futebol encontrado: {}", futebolRetornado);
                });

         */


        String prefixo = "pre";
        log.info("Buscando pelo prefixo {}", prefixo);
        futebolService.buscandoComPrefixo(prefixo)
                .forEach(futebolRetornado -> {
                    log.info("futebol encontrado: {}", futebolRetornado);
                });
    }
}
