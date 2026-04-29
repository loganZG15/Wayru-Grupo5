package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.Distrito;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito, Integer> {

    Optional<Distrito> findByNombreDistrito(String nombreDistrito);

    @Query(value = "SELECT DISTINCT d.* FROM Distrito d " +
            " INNER JOIN incidencia i ON d.id_distrito = i.id_distrito", nativeQuery = true)
    List<Distrito> findDistritosConIncidencias();
}
