package br.com.ifpe.oxefood.api.empresa;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

	private String email;

    private String password;

    private String perfil;

	private String site;

	@NotBlank(message = "O CNPJ é de preenchimento obrigatório")
	@Pattern(regexp = "\\d{14}", message = "O CNPJ deve ter exatamente 14 dígitos")
	private String cnpj;

	@NotBlank(message = "A Inscrição Estadual é de preenchimento obrigatório")
	@Pattern(regexp = "\\d{9}", message = "O Inscrição Estadual deve ter exatamente 9 dígitos")
	private String inscricaoEstadual;

	@NotBlank(message = "A Razão Social é de preenchimento obrigatório")
	private String nomeEmpresarial;

	@NotBlank(message = "O Nome Fantasia é de preenchimento obrigatório")
	private String nomeFantasia;

	@NotBlank(message = "O Fone é de preenchimento obrigatório")
	private String fone;

	private String foneAlternativo;

	public Empresa build() {

		Empresa empresa = Empresa.builder()
				.usuario(buildUsuario())
				.site(site)
				.cnpj(cnpj)
				.inscricaoEstadual(inscricaoEstadual)
				.nomeEmpresarial(nomeEmpresarial)
				.nomeFantasia(nomeFantasia)
				.fone(fone)
				.foneAlternativo(foneAlternativo)
				.build();

		return empresa;
	}

	public Usuario buildUsuario() {

		return Usuario.builder()
			.username(email)
			.password(password)
			.build();
		}
	
}


