public class GerenciadorSpam extends Gerenciador {

    @Override
    public void verificar(Mail email) {
        System.out.println("Meu Deus, caiu no spam");
    }
}
