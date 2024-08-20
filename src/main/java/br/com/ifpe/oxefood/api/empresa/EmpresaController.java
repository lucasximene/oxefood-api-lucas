package br.com.ifpe.oxefood.api.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import br.com.ifpe.oxefood.modelo.empresa.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/empresa")
@CrossOrigin
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@Operation(summary = "Serviço para salvar uma Empresa.", description = "Endpoint responsável por salvar um Empresa no sistema.")
	@PostMapping
	public ResponseEntity<Empresa> save(@RequestBody @Valid EmpresaRequest request) {

		Empresa empresa = request.build();

		if (request.getPerfil() != null && !"".equals(request.getPerfil())) {

			if (request.getPerfil().equals("EMPRESA_USER")) {

				empresa.getUsuario().getRoles().add(Usuario.ROLE_EMPRESA_USER);

			} else if (request.getPerfil().equals("EMPRESA_ADMIN")) {

				empresa.getUsuario().getRoles().add(Usuario.ROLE_EMPRESA_ADMIN);
			}
		}
		
		Empresa empresaCriada = empresaService.save(empresa);
		return new ResponseEntity<Empresa>(empresaCriada, HttpStatus.CREATED);
	}

    @Operation(summary = "Serviço para listar todas as Empresas.", description = "Endpoint responsável por listar todas as Empresas no sistema.")
    @GetMapping
    public List<Empresa> listarTodos() {
        return empresaService.listarTodos();
    }

    @Operation(summary = "Serviço para listar uma Empresa pelo seu id.", description = "Endpoint responsável por listar uma Empresa no sistema pelo seu id.")
    @GetMapping("/{id}")
    public Empresa obterPorID(@PathVariable Long id) {
        return empresaService.obterPorID(id);
    }

    @Operation(summary = "Serviço para atualizar uma Empresa.", description = "Endpoint responsável por atualizar um Empresa no sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable("id") Long id, @RequestBody EmpresaRequest request) {

        empresaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço para deletar um Empresa.", description = "Endpoint responsável por deletar um Empresa no sistema pelo seu id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
