package br.com.clicanicaodontologica.clinicacheckpoint;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.ContatoRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.EnderecoRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.PacienteRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.GeneroEnum;
import com.github.javafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Locale;

public class Fixture {
    private static final Faker FAKER = new Faker(new Locale("pt", "BR"));

    public static class PacienteFake {

        public static PacienteRequest anyPaciente() {
            PacienteRequest request = new PacienteRequest();
            request.setNome(FAKER.dragonBall().character());
            request.setDataNascimento(Instant.now());
            request.setGenero(GeneroEnum.M);

            ContatoRequest contatoRequest = new ContatoRequest();
            contatoRequest.setEmail(FAKER.internet().emailAddress());
            contatoRequest.setTelefone("(19) 9991-6659");
            request.setContato(contatoRequest);

            EnderecoRequest enderecoRequest = new EnderecoRequest();
            enderecoRequest.setLogadouro(FAKER.address().streetAddress());
            enderecoRequest.setBairro(FAKER.address().secondaryAddress());
            enderecoRequest.setCidade(FAKER.address().cityName());
            enderecoRequest.setEstado(FAKER.address().state());
            enderecoRequest.setCep(FAKER.address().zipCode());
            request.setEndereco(enderecoRequest);

            return request;
        }
    }
}
