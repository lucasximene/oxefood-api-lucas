package br.com.ifpe.oxefood.api.produto;

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

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin

public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @Operation(summary = "Serviço para salvar um produto.", description = "Endpoint responsável por inserir um produto no sistema.")
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

        Produto produtoNovo = request.build();
        produtoNovo.setCategoria(categoriaProdutoService.obterPorId(request.getIdCategoria()));
        Produto produto = produtoService.save(produtoNovo);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);

    }

    @Operation(summary = "Serviço para listar todos os produtos.", description = "Endpoint responsável por listar todos os produto no sistema.")
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @Operation(summary = "Serviço para listar um produto pelo seu id.", description = "Endpoint responsável por listar um produto no sistema pelo seu id.")
    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }

    @Operation(summary = "Serviço para atualizar um produto.", description = "Endpoint responsável por atualizar um produto no sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody @Valid ProdutoRequest request) {

        Produto produto = request.build();
        produto.setCategoria(categoriaProdutoService.obterPorId(request.getIdCategoria()));
        produtoService.update(id, produto);

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço responsável por deletar um produto no sistema.", description = "Endpoint responsável por deletar um produto no sistema pelo seu id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço responsável por filtrar um produto no sistema.", description = "Endpoint responsável por filtrar um produto no sistema pelo seu id.")
    @PostMapping("/filtrar")
    public List<Produto> filtrar(
            @RequestParam(value = "codigo", required = false) String codigo,
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "idCategoria", required = false) Long idCategoria) {

        return produtoService.filtrar(codigo, titulo, idCategoria);
    }

}