package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.CategoriaIncidencia;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoriaIncidenciaRepository extends JpaRepository<CategoriaIncidencia, Integer>
{
    List<CategoriaIncidencia> findByNombreCategoriaContainingIgnoreCase(String nombreCategoria);

    Optional<CategoriaIncidencia> findByNombreCategoriaIgnoreCase(String nombreCategoria);

    @Query("SELECT c FROM CategoriaIncidencia c WHERE c.subCategoria = :subCategoria")
    List<CategoriaIncidencia> findBySubCategoria(@Param("subCategoria") String subCategoria);
}
