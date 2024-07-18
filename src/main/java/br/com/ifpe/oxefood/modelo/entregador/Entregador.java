package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel  {

   @Column
   private String nome;

   @Column
   private String cpf;

   @Column
   private String rg;

   @Column
   private LocalDate dataNascimento;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

   @Column
   private int qtdEntregas;

   @Column
   private double valorFrete;

   @Column
   private String rua;

   @Column
   private String numero;

   @Column
   private String bairro;

   @Column
   private String cidade;

   @Column
   private String cep;

   @Column
   private String uf;

   @Column
   private String complemento;

   @Column
   private Boolean ativo;

/* 
   Para colocar no Postman
   "nome": "Heloisa",
   "cpf":"123.456.789-10",
   "rg":"123456",
   "dataNascimento":"13/12/2001",
   "foneCelular":"81954545454",
   "foneFixo":"8154545454",
   "qtdEntregas": 2,
   "valorFrete": 3.50,
   "rua":"rua da esquina",
   "numero":"14",
   "bairro":"Centro",
   "cidade":"jab",
   "cep":"5411",
   "uf":"PE",
   "complemento":"funer",
   "ativo":true
*/
}
