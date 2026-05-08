package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Foro;

import java.util.List;

@Service
public interface IForoService {
    List<Foro> listarTodo();

    void insertar(Foro foro);
}
