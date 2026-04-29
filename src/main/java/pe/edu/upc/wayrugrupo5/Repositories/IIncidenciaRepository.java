package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.Incidencia;

import java.util.List;

@Repository
public interface IIncidenciaRepository extends JpaRepository<Incidencia, Integer> {
    List<Incidencia> findByDistritoIdDistrito(int idDistrito);

    @Query("SELECT i FROM Incidencia i WHERE i.estado = " +
            " true ORDER BY i.fechaIncidencia DESC")
    List<Incidencia> findIncidenciasActivas();

    @Query(value = "SELECT c.nombre_categoria, COUNT(i.id_incidencia) AS total " +
            " FROM incidencia i " +
            " JOIN categoria_incidencia c ON i.id_categoria = c.id_categoria " +
            " GROUP BY c.nombre_categoria", nativeQuery = true)
    List<Object[]> countIncidenciasPorCategoria();
}
