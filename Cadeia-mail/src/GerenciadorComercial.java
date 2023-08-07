public class GerenciadorComercial extends Gerenciador {

    @Override
    public void verificar(Mail email) {
        //todo: implementação da validação ou proximo
        boolean isComercial = "Comercial".equals(email.getAssunto());
        boolean emailDestinoIsComercial = "comercial@colmeia.com".equals(email.getDestino());

        if (isComercial || emailDestinoIsComercial) {
            System.out.println("Olá, estou enviando esse email para comercial");
        } else {
            this.gerenciadorSeguinte.verificar(email);
        }
    }
}
