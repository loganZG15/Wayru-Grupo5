package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.Incidencia;

import java.util.List;

@Repository
public interface IIncidenciaRepository extends JpaRepository<Incidencia, Integer> {
    List<Incidencia> findByDistritoIdDistrito(int idDistrito);

    @Query("SELECT i FROM Incidencia i WHERE i.estado = true ORDER BY i.fechaIncidencia DESC")
    List<Incidencia> findIncidenciasActivas();

    @Query(value = "SELECT c.nombreCategoria, COUNT(i.idIncidencia) AS total " +
            " FROM incidencia i " +
            " JOIN categoriaIncidencia c ON i.idCategoria = c.idCategoria " +
            " GROUP BY c.nombreCategoria", nativeQuery = true)
    List<Object[]> countIncidenciasPorCategoria();
}
