package br.com.digitalhouse.apostas.domain.entity;

public enum StatusEnum {

    AGENDADA("A partida está agendada. Aguardando jogadores.") {
        @Override
        public StatusEnum nextState(StatusEnum statusEnum) {
            if (statusEnum.equals(AO_VIVO)) {
                throw  new IllegalStateException();
            }
            return statusEnum;
        }
    },
    PARA_COMECAR("A partida está para começar. Aguardando autorização!") {
        @Override
        public StatusEnum nextState(StatusEnum statusEnum) {
            return statusEnum;
        }
    },
    AO_VIVO("A partida esta ao-vivo, acompanhe cada lance!") {
        @Override
        public StatusEnum nextState(StatusEnum statusEnum) {
            return statusEnum;
        }
    },
    ENCERRADA("A partida está encerrada. Veja o resultado!") {
        @Override
        public StatusEnum nextState(StatusEnum statusEnum) {
            return statusEnum;
        }
    };

    final String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public abstract StatusEnum nextState(StatusEnum statusEnum);
}
