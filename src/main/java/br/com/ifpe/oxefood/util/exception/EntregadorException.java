package br.com.ifpe.oxefood.util.exception;

public class EntregadorException extends RuntimeException {

    public static final String MSG_CPF_NULO ="CPF não pode ser nulo";

    public static final String MSG_NUMERO_INVALIDO= "O numero de telefone precisa ter o prefixo 81" ;


    public EntregadorException(String msg){
        super(String.format(msg));
    }

}