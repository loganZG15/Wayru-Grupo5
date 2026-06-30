package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.CategoriaIncidencia;

import java.util.List;

@Service
public interface ICategoriaIncidenciaService {
    public CategoriaIncidencia insert(CategoriaIncidencia cI);
    List<CategoriaIncidencia> buscarPorNombre(String nombreCategoria);
    List<CategoriaIncidencia> buscarPorSubCategoria(String subCategoria);
    List<CategoriaIncidencia> listarTodo();
    CategoriaIncidencia buscarPorId(int id);
    CategoriaIncidencia update(CategoriaIncidencia cI);
    void delete(int id);
}
