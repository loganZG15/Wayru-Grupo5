package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.Comentario;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
}
