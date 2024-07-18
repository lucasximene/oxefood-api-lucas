package br.com.ifpe.oxefood.api.fornecedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import br.com.ifpe.oxefood.modelo.fornecedor.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Operation(
       summary = "Serviço responsável por salvar um fornecedor no sistema.",
       description = "Endpoint responsável por inserir um fornecedor no sistema."
   )
    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody FornecedorRequest request) {

        Fornecedor fornecedor = fornecedorService.save(request.build());
        return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
    }
    @Operation(
       summary = "Serviço responsável por listar todos os fornecedores no sistema.",
       description = "Endpoint responsável por inserir um fornecedor no sistema."
   )
    @GetMapping  
    public List<Fornecedor> listarTodos(){
        return fornecedorService.listarTodos();
    }
    @Operation(
       summary = "Serviço responsável por listar um fornecedor pelo seu id no sistema.",
       description = "Endpoint responsável por listar um fornecedor no sistema pelo seu id."
   )
    @GetMapping("/{id}")
    public Fornecedor obterPorId(@PathVariable Long id){
        return fornecedorService.obterPorID(id);
    }
    @Operation(
        summary = "Serviço responsável por atualizar um fornecedor no sistema.",
        description = "Endpoint responsável por atualizar um fornecedor no sistema."
    )
     @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable("id") Long id, @RequestBody FornecedorRequest request) {

        fornecedorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    @Operation(
        summary = "Serviço responsável por deletar um fornecedor no sistema.",
        description = "Endpoint responsável por deletar um fornecedor no sistema pelo seu id."
    )
     @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       fornecedorService.delete(id);
       return ResponseEntity.ok().build();
   }
    
}