import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void dadoServicoDeDowload_quandoChamamosDownload_entaoRetornarVerificacaoDoTipoUsuario() {
        //dado
        String nome = "Leandro";
        String tipoUsuario = "Premium";

        Usuario Leandro = new Usuario(nome, tipoUsuario);
        //quando
        Download servico = new ServicoProxyDownload();
        //entao
        String resultado = servico.Verificar(nome, tipoUsuario);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Download validado com proxy!", resultado);

    }

}