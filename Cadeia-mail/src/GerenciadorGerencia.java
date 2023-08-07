public class GerenciadorGerencia extends Gerenciador {

    @Override
    public void verificar(Mail email) {
        //todo: implementação da validação ou proximo
        boolean isGerencia = "Gerencia".equals(email.getAssunto());
        boolean emailDestinoIsGerencia = "gerencia@colmeia.com".equals(email.getDestino());

        if (isGerencia || emailDestinoIsGerencia) {
            System.out.println("Olá, estou enviando esse email para gerencia");
        } else {
            this.gerenciadorSeguinte.verificar(email);
        }
    }
}
