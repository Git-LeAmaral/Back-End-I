public abstract class Gerenciador {
    protected Gerenciador gerenciadorSeguinte;

    public void setGerenciadorSeguinte(Gerenciador gerenciadorSeguinte) {
        this.gerenciadorSeguinte = gerenciadorSeguinte;
    }

    public abstract void verificar(Mail email);
}
