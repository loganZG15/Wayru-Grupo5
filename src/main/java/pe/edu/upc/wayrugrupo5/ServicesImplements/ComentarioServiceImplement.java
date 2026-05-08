package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Comentario;
import pe.edu.upc.wayrugrupo5.Repositories.IComentarioRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IComentarioService;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImplement implements IComentarioService {

    @Autowired
    private IComentarioRepository cR;

    @Override
    public Comentario insert(Comentario comentario) {
        return cR.save(comentario);
    }

    @Override
    public List<Comentario> getAll() {
        return cR.findAll();
    }

    @Override
    public Optional<Comentario> getById(int id) {
        return cR.findById(id);
    }

    @Override
    public List<Comentario> getByIncidencia(int idIncidencia) {
        return cR.findByIncidenciaIdIncidencia(idIncidencia);
    }
}
