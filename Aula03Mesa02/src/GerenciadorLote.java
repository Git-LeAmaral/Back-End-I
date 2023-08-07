public class GerenciadorLote extends Gerenciador {
    @Override
    public void verificar(Artigo artigo) {
        boolean isLote = artigo.getLote() >= 1000 && artigo.getLote() <= 2000;

        if (isLote) {
            this.proximoGerenciador.verificar(artigo);
        } else {
            System.out.println("O lote esta errado");
        }
    }


}
