package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Incidencia;
import pe.edu.upc.wayrugrupo5.Repositories.IIncidenciaRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IIncidenciaService;

import java.util.List;

@Service
public class IncidenciaServiceImplement implements IIncidenciaService {

    @Autowired
    private IIncidenciaRepository iR;


    @Override
    public Incidencia insert(Incidencia i) {
        return iR.save(i);
    }

    @Override
    public List<Incidencia> listarPorDistrito(int idDistrito) {
        return iR.findByDistritoIdDistrito(idDistrito);
    }

    @Override
    public List<Incidencia> listarPorCategoria(int idCategoria) {
        return iR.findByCategoriaIncidenciaIdCategoria(idCategoria);
    }

    @Override
    public List<Incidencia> listarActivas() {
        return iR.findIncidenciasActivas();
    }

    @Override
    public List<Object[]> contarPorCategoria() {
        return iR.countIncidenciasPorCategoria();
    }

    @Override
    public List<Incidencia> listarTodo() {
        return iR.findAll();
    }

    @Override
    public Incidencia buscarPorId(int id) {
        return iR.findById(id).orElse(null);
    }

    @Override
    public Incidencia update(Incidencia i) {
        return iR.save(i);
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }
}
