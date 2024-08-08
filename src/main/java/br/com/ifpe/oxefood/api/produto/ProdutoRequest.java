package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

  @NotNull
  private Long idCategoria;

  @NotBlank(message= "O codigo é de preenchimento obrigatório")
  private String codigo;

  @NotBlank(message= "O titulo é de preenchimento obrigatório")
  private String titulo;

  @NotBlank(message= "A descrição é de preenchimento obrigatório")
  private String descricao;

  @Min(value=100, message= "O valor minimo é 100 reais")
  private Double valorUnitario;

  @Max(value= 30, message = "O valor de entrega mínimo é de 30 minutos")
  private Integer tempoEntregaMinimo;

  
  @Max(value= 100, message = "O valor de entrega máximo é de 100 minutos")
  private Integer tempoEntregaMaximo;

  public Produto build() {

    return Produto.builder()
        .codigo(codigo)
        .titulo(titulo)
        .descricao(descricao)
        .valorUnitario(valorUnitario)
        .tempoEntregaMinimo(tempoEntregaMinimo)
        .tempoEntregaMaximo(tempoEntregaMaximo)
        .build();
  }
}