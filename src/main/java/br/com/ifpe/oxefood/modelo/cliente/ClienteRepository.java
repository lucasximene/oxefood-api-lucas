package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifpe.oxefood.modelo.produto.Produto;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

     //Exemplo de uma busca exata
   @Query(value = "SELECT p FROM Cliente p WHERE p.codigo = :codigo")
   List<Produto> consultarPorCodigo(String codigo);

   @Query(value = "SELECT p FROM Cliente p WHERE p.nome like %:nome = :nome")
   List<Produto> consultarPorNome(String nome);

   @Query(value = "SELECT p FROM Cliente p WHERE p.cpf = :cpf")
   List<Produto> consultarPorCpf(String cpf);

   @Query(value = "SELECT p FROM Produto p WHERE p.nome like %:nome AND p.cpf = :nome")
   List<Produto> consultarPorNomeCpf(String nome, String cpf);

   
}
