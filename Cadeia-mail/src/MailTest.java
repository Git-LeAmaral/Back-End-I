import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailTest {

    @Test
    public void dadoUmEmailDeGerencia_quandoChamamosProcessar_entaoEnviarAoGestor() {
        String origem = "email@colmeia.com";
        String destino = "tecnologia@colmeia.com";
        String assunto = "Gerencia";

        CheckMail processador = new CheckMail();

        Mail email = new Mail(destino, origem, assunto);

        processador.verificar(email);
    }

    @Test
    public void dadoUmEmailComercial_quandoChamamosProcessar_entaoEnviarAoComercial() {
        String origem = "email@colmeia.com";
        String destino = "comercial@colmeia.com";
        String assunto = "COMERCIAL";

        CheckMail processador = new CheckMail();

        Mail email = new Mail(destino, origem, assunto);

        processador.verificar(email);
    }

    @Test
    public void dadoUmEmailTecnicol_quandoChamamosProcessar_entaoEnviarAoTecnico() {
        String origem = "email@colmeia.com";
        String destino = "tecnico@colmeia.com";
        String assunto = "TECNICO";

        CheckMail processador = new CheckMail();

        Mail email = new Mail(destino, origem, assunto);

        processador.verificar(email);
    }

    @Test
    public void dadoUmEmailIncorreto_quandoChamamosProcessar_entaoEnviarAoSpam() {
        String origem = "email@colmeia.com";
        String destino = "t3cn1c0@colm3i4.com";
        String assunto = "Fique rico agora!!!";

        CheckMail processador = new CheckMail();

        Mail email = new Mail(destino, origem, assunto);

        processador.verificar(email);
    }

}