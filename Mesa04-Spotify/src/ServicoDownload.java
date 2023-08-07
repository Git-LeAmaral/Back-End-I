public class ServicoDownload implements Download {


    @Override
    public String Verificar(String nome, String tipoUsuario) {
        System.out.println(
                """
                Usuário: %s
                É cadastrado com a conta: %s
                -----------------------------------------------
                """.formatted(nome, tipoUsuario)
                );

        return "Download validado com proxy!";
    }
}
