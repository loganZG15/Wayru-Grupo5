package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.wayrugrupo5.Entities.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    List<Usuario> findByNombreUsuarioContainingIgnoreCase(String nombre);

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, id_usuario) VALUES (:rol, :id_usuario)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("id_usuario") Long id_usuario);

    Usuario findByNombreUsuario(String nombreUsuario);
}
