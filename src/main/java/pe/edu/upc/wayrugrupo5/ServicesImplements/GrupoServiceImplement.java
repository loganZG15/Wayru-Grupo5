package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Grupo;
import pe.edu.upc.wayrugrupo5.Repositories.IGrupoRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IGrupoService;

import java.util.List;

@Service
public class GrupoServiceImplement implements IGrupoService {

    @Autowired
    private IGrupoRepository gR;

    @Override
    public List<Grupo> listarTodo() {
        return List.of();
    }
}
