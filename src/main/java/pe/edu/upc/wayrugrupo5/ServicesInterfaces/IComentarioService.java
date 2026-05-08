package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Comentario;

import java.util.List;
import java.util.Optional;

@Service
public interface IComentarioService {
    Comentario insert(Comentario comentario);
    List<Comentario> getAll();
    Optional<Comentario> getById(int id);
    List<Comentario> getByIncidencia(int idIncidencia);
}
