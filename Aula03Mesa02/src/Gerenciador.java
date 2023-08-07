public abstract class Gerenciador {

    protected Gerenciador proximoGerenciador;

    public void setProximoGerenciador(Gerenciador proximoGerenciador) {
        this.proximoGerenciador = proximoGerenciador;
    }

    public abstract void verificar(Artigo artigo);
}
