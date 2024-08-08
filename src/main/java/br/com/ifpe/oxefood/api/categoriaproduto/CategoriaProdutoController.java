package br.com.ifpe.oxefood.api.categoriaproduto;

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

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin

public class CategoriaProdutoController {
    
    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @Operation(summary = "Serviço para salvar uma categoria de produto no sistema.", description = "Endpoint responsável por inserir uma categoria de produto no sistema.")
    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {
       CategoriaProduto categoriaProdutoNovo = request.build();
       CategoriaProduto categoriaProduto = categoriaProdutoService.save(categoriaProdutoNovo);
       return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
        
    }
    @Operation(summary = "Serviço para listar categorias de produtos.", description = "Endpoint responsável por listar todas categorias de produtos no sistema.")
    @GetMapping
    public List<CategoriaProduto> listarTodos(){
        return categoriaProdutoService.listarTodos();
        
    }    
    @Operation(summary = "Serviço para listar uma categoria de produto pelo id.", description = "Endpoint responsável por listar uma categoria de produto no sistema pelo seu id .")
    @GetMapping("/{id}")
    public CategoriaProduto obterPorId(@PathVariable Long id){
        return categoriaProdutoService.obterPorId(id);

    }

    @Operation(summary = "Serviço para atualizar uma categoria de produto.", description = "Endpoint responsável por atualizar uma categoria de produto no sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request){
        categoriaProdutoService.update(id,request.build());
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "Serviço para deletar uma categoria de produto.", description = "Endpoint responsável por deletar uma categoria de produto no sistema.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id){
        categoriaProdutoService.delete(id);
    }


}