package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.CategoriaIncidencia;
import pe.edu.upc.wayrugrupo5.Repositories.ICategoriaIncidenciaRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.ICategoriaIncidenciaService;

import java.util.List;

@Service
public class CategoriaIncidenciaServiceImplement implements ICategoriaIncidenciaService {

    @Autowired
    private ICategoriaIncidenciaRepository cR;


    @Override
    public CategoriaIncidencia insert(CategoriaIncidencia cI) {
        return cR.save(cI);
    }

    @Override
    public List<CategoriaIncidencia> buscarPorNombre(String nombreCategoria) {
        return cR.findByNombreCategoriaContainingIgnoreCase(nombreCategoria);
    }

    @Override
    public List<CategoriaIncidencia> buscarPorSubCategoria(String subCategoria) {
        return cR.findBySubCategoria(subCategoria);
    }
}
