package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Incidencia;

import java.util.List;

@Service
public interface IIncidenciaService {
    public Incidencia insert(Incidencia i);
    List<Incidencia> listarPorDistrito(int idDistrito);
    List<Incidencia> listarActivas();
    List<Object[]> contarPorCategoria();
    List<Incidencia> listarTodo();
    Incidencia buscarPorId(int id);
    Incidencia update(Incidencia i);
    void delete(int id);
}
