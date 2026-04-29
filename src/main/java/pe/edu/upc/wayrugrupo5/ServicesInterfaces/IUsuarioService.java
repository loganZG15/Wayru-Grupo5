package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Usuario;

import java.util.List;

@Service
public interface IUsuarioService {
    public Usuario insert(Usuario u);
    Usuario buscarPorEmail(String email);
    List<Usuario> buscarPorNombre(String nombre);
    Usuario buscarPorId(Long id);
}
