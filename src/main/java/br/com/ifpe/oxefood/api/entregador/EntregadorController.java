package br.com.ifpe.oxefood.api.entregador;

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


import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {
    @Autowired
    private EntregadorService entregadorService;

    @Operation(summary = "Serviço para salvar um Entregador.", description = "Endpoint responsável por salvar um Entregador no sistema.")
    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody @Valid EntregadorRequest request) {

        Entregador entregador = entregadorService.save(request.build());
        return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
    }

    @Operation(summary = "Serviço para listar todos os Entregadores.", description = "Endpoint responsável por listar todos fabricantes no sistema.")
    @GetMapping
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }

    @Operation(summary = "Serviço para listar um Entregador pelo seu id.", description = "Endpoint responsável por listar um Entregador no sistema pelo seu id.")
    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }

    @Operation(summary = "Serviço para atualizar um Entregador.", description = "Endpoint responsável por atualizar um Entregador no sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

        entregadorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço para deletar um Entregador.", description = "Endpoint responsável por deletar um Entregador no sistema pelo seu id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entregadorService.delete(id);
        return ResponseEntity.ok().build();
    }
}