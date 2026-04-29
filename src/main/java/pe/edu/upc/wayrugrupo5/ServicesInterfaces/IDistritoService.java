package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Distrito;

import java.util.List;
import java.util.Optional;

@Service
public interface IDistritoService {
    public Distrito insert(Distrito d);
    Optional<Distrito> buscarPorNombre(String nombreDistrito);
    List<Distrito> listarConIncidencias();
}
