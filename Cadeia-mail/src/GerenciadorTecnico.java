public class GerenciadorTecnico extends Gerenciador {
    @Override
    public void verificar(Mail email) {
        boolean isTecnico = "Tecnico".equals(email.getAssunto());
        boolean emailDestinoIsTecnico = "tecnico@colmeia.com".equals(email.getDestino());

        if (isTecnico || emailDestinoIsTecnico) {
            System.out.println("Olá, estou enviando esse email para o time de TI (Tecnico)");
        } else {
            this.gerenciadorSeguinte.verificar(email);
        }
    }
}
