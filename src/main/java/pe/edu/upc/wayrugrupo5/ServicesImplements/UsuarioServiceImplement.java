package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Usuario;
import pe.edu.upc.wayrugrupo5.Repositories.IUsuarioRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;


    @Override
    public Usuario insert(Usuario u) {
        return uR.save(u);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return uR.findByEmail(email);
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return uR.findByNombreUsuarioContainingIgnoreCase(nombre);
    }

    @Override
    public Usuario buscarPorId(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> listarTodo() {
        return uR.findAll();
}
}
