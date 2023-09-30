package br.com.digitalhouse.games.app.runner;

import br.com.digitalhouse.games.domain.entity.Game;
import br.com.digitalhouse.games.domain.repository.GameRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

@Component
public class PopularBancoDeGames implements CommandLineRunner {
    private final GameRepository gameRepository;
    private final Faker faker;

    @Autowired
    public PopularBancoDeGames(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        faker = new Faker(new Locale("pt", "BR"));
    }

    @Override
    public void run(String... args) throws Exception {
        Game dragonBall = new Game();
        dragonBall.setNome(faker.dragonBall().toString());
        dragonBall.setGeneros(List.of("Anime", "Luta", "Poder"));
        dragonBall.setLancamento(LocalDate.of(2021, Month.NOVEMBER, 11));

        Game godOfWar = new Game();
        godOfWar.setNome("God of War: %s em batalha".formatted(faker.ancient().god()));
        godOfWar.setGeneros(List.of("Luta", "Ação", "Guerra"));
        godOfWar.setLancamento(LocalDate.of(2021, Month.APRIL, 20));

        Game fifa = new Game();
        fifa.setNome(faker.esports().team());
        fifa.setGeneros(List.of("Esportes", "Dois ou mais jogadores", "Simulação"));
        fifa.setLancamento(LocalDate.of(2023, Month.OCTOBER, 10));

        Game mario = new Game();
        mario.setNome(faker.avatar().toString());
        mario.setLancamento(LocalDate.of(2000, Month.JANUARY, 25));
        mario.setGeneros(List.of("Plataforma", "Player", "Divertido"));

        gameRepository.saveAll(List.of(dragonBall, godOfWar, fifa, mario));
    }
}
