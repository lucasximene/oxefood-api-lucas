package br.com.ifpe.oxefood.util.exception;

public class ClienteException extends RuntimeException {
    
 public static final String MSG_NUMERO_INVALIDO= "O numero de telefone precisa ter o prefixo 81" ;

 public ClienteException(String msg){
    super(String.format(msg));
}
}