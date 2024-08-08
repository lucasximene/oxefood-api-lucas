package br.com.ifpe.oxefood.modelo.produto;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@SQLRestriction("habilitado = true")
@Builder        
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {

   @ManyToOne
   private CategoriaProduto categoria;

   @Column(nullable = false)
   private String codigo;

   @Column(nullable = false, length = 30)
   private String titulo;

   @Column(nullable = false, length = 100)
   private String descricao;

   @Column(nullable = false)
   private Double valorUnitario;

   @Column(nullable = false)
   private Integer tempoEntregaMinimo;

   @Column(nullable = false)
   private Integer tempoEntregaMaximo;

}