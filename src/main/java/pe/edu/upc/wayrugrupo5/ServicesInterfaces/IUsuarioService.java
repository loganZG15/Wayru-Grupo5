package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import pe.edu.upc.wayrugrupo5.Entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public Usuario insert(Usuario u);
    Usuario buscarPorEmail(String email);
    List<Usuario> buscarPorNombre(String nombre);
}
