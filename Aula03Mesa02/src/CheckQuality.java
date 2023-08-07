public class CheckQuality {

    Gerenciador gerenciador;

    public CheckQuality() {

        gerenciador = new GerenciadorLote();

        Gerenciador peso = new GerenciadorLote();
        Gerenciador embalagem = new GerenciadorEmbalagem();

        gerenciador.setProximoGerenciador(peso);
        peso.setProximoGerenciador(embalagem);
    }

    public void verificar(Artigo artigo) {
        gerenciador.verificar(artigo);
    }
}
