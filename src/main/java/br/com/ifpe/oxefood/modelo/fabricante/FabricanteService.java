package br.com.ifpe.oxefood.modelo.fabricante;

import jakarta.transaction.Transactional;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricanteService {

   @Autowired
   private FabricanteRepository repository;

   @Transactional
   public Fabricante save(Fabricante fabricante) {

        fabricante.setHabilitado(Boolean.TRUE);
        fabricante.setVersao(1L);
        fabricante.setDataCriacao(LocalDate.now());
       return repository.save(fabricante);
   }

   public List<Fabricante> listarTodos() {
  
        return repository.findAll();
    }

    public Fabricante obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Fabricante fabricanteAlterado) {
 
        Fabricante fabricante = repository.findById(id).get();
        fabricante.setNome(fabricanteAlterado.getNome());
        fabricante.setEndereco(fabricanteAlterado.getEndereco());
        fabricante.setValorMercado(fabricanteAlterado.getValorMercado());
        fabricante.setPaginaWeb(fabricanteAlterado.getPaginaWeb());
        fabricante.setQtdFuncionarios(fabricanteAlterado.getQtdFuncionarios());
        fabricante.setInicioContrato(fabricanteAlterado.getInicioContrato());
         
        fabricante.setVersao(fabricante.getVersao() + 1);
        repository.save(fabricante);
   }
   
   @Transactional
   public void delete(Long id) {

       Fabricante fabricante = repository.findById(id).get();
       fabricante.setHabilitado(Boolean.FALSE);
       fabricante.setVersao(fabricante.getVersao() + 1);

       repository.save(fabricante);
   }

}
