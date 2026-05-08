package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Grupo;

import java.util.List;

@Service
public interface IGrupoService {
    public List<Grupo> listarTodo();
}
