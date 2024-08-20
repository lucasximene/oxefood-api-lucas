package br.com.ifpe.oxefood.api.cliente;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;


    @Operation(summary = "Serviço para salvar um cliente no sistema.", description = "Endpoint responsável por inserir um cliente no sistema.")
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest clienterequest, HttpServletRequest request) {

        Cliente cliente = clienteService.save(clienterequest.build(), usuarioService.obterUsuarioLogado(request));
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @Operation(summary = "Serviço para listar todos os clientes no sistema.", description = "Endpoint responsável por listar todos os clientes no sistema.")
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Serviço para listar um cliente pelo seu id .", description = "Endpoint responsável por listar um cliente no sistema pelo seu id.")
    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @Operation(summary = "Serviço para atualizar um cliente .", description = "Endpoint responsável por atualizar um cliente no sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest clienterequest, HttpServletRequest request) {

        clienteService.update(id, clienterequest.build(), usuarioService.obterUsuarioLogado(request));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço para deletar um cliente .", description = "Endpoint responsável por deletar um cliente no sistema pelo seu id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço para salvar um endereço de um cliente no sistema.", description = "Endpoint responsável por inserir um endereço de um cliente no sistema.")
    @PostMapping("/endereco/{clienteId}")
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@PathVariable("clienteId") Long clienteId,
            @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
    }

    @Operation(summary = "Serviço para atualizar um endereço de um cliente.", description = "Endpoint responsável por atualizar um endereço de um cliente no sistema.")
    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("enderecoId") Long enderecoId,
            @RequestBody EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.OK);
    }

    @Operation(summary = "Serviço para deletar um endereço de um cliente.", description = "Endpoint responsável por deletar um endereço de um cliente no sistema pelo seu id.")
    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {

        clienteService.removerEnderecoCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Serviço para filtrar um cliente.", description = "Endpoint responsável por filtrar um cliente no sistema.")
    @PostMapping("/filtrar")
    public List<Cliente> filtrar(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "cpf", required = false) String cpf) {

        return clienteService.filtrar(nome, cpf);
    }

}