package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
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
public class EntregadorRequest {

    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    private String nome;

    @NotBlank(message = "O Cpf é de preenchimento obrigatório")
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "O numero de telefone é de preenchimento obrigatório")
    private String foneCelular;

    private String foneFixo;

    private int qtdEntregasRealizadas;

    @NotNull
    @Min(value=1, message = "O frete precisa ter um valor")
    private Double valorFrete;

    @NotBlank(message = "O endereço é de preenchimento obrigatório")
    private String enderecoRua;

    @NotBlank(message = "O numero de endereço é de preenchimento obrigatório")
    private String enderecoNumero;

    @NotBlank(message = "O bairro é de preenchimento obrigatório")
    private String enderecoBairro;

    @NotBlank(message = "A cidade é de preenchimento obrigatório")
    private String enderecoCidade;

    @NotBlank(message = "O cep é de preenchimento obrigatório")
    private String enderecoCep;

    @NotBlank(message = "A uf é de preenchimento obrigatório")
    private String enderecoUf;

    @NotBlank(message = "O endereço é de preenchimento obrigatório")
    private String enderecoCompleto;

    @NotNull(message = "é preciso dizer se o entregador esta ativo")
    private Boolean ativo; 

    public Entregador build() {
        return Entregador.builder()
            .nome(nome)
            .cpf(cpf)
            .dataNascimento(dataNascimento)
            .foneCelular(foneCelular)
            .foneFixo(foneFixo)
            .qtdEntregasRealizadas(qtdEntregasRealizadas)
            .valorFrete(valorFrete)
            .enderecoRua(enderecoRua)
            .enderecoNumero(enderecoNumero)
            .enderecoBairro(enderecoBairro)
            .enderecoCidade(enderecoCidade)
            .enderecoCep(enderecoCep)
            .enderecoUf(enderecoUf)
            .enderecoCompleto(enderecoCompleto)
            .ativo(ativo)
            .build();
    }
}
