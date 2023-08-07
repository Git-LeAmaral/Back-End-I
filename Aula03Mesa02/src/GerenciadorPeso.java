public class GerenciadorPeso extends Gerenciador {
    @Override
    public void verificar(Artigo artigo) {

        boolean isPeso = artigo.getLote() >= 1200 && artigo.getLote() <= 1300;


        if (isPeso) {
            this.proximoGerenciador.verificar(artigo);
        } else {
            System.out.println("O peso esta errado");
        }
    }
}
