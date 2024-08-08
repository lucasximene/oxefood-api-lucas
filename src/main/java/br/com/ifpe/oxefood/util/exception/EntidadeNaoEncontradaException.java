package br.com.ifpe.oxefood.util.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

  public EntidadeNaoEncontradaException(String entidade, Long id) {
    super(String.format("Não foi encontrado(a) um(a) %s com o id %s", entidade, id.toString()));
  }

}