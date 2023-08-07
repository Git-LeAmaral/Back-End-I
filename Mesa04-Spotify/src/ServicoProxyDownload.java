public class ServicoProxyDownload implements Download {

    private final Download servicoDownload = new ServicoDownload();
    @Override
    public String Verificar(String nome, String tipoUsuario) {

        System.out.println("Verificando tipo de usuário...");

        boolean tipoContaPremium = tipoUsuario.equals("Premium");
        if (tipoContaPremium) {

            servicoDownload.Verificar(nome, tipoUsuario);
            System.out.println("Usuário Premium, aproveite seu download");
        } else {

            System.out.println("Usuário de conta Free, não pode fazer download");
        }
        return "Download validado com proxy!";
    }
}
