public class GerenciadorEmbalagem extends Gerenciador {
    @Override
    public void verificar(Artigo artigo) {


        boolean isEmbalagemSaudavel = "Saudavel".equals(artigo.getEmbalagem());
        boolean isEmbalagemNaoSaudavel = "Não Saudavel".equals(artigo.getEmbalagem());


        if (isEmbalagemSaudavel || isEmbalagemNaoSaudavel) {
            //this.proximoGerenciador.verificar(artigo);
            System.out.println("Produto enviado com sucesso");
        } else {
            System.out.println("O peso esta errado");
        }
    }
}
