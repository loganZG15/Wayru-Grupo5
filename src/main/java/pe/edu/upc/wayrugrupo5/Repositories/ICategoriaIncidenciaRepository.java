package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.CategoriaIncidencia;

import java.util.List;

@Repository
public interface ICategoriaIncidenciaRepository extends JpaRepository<CategoriaIncidencia, Integer>
{
    List<CategoriaIncidencia> findByNombreCategoria(String nombreCategoria);

    @Query("SELECT c FROM CategoriaIncidencia c WHERE c.subCategoria = :subCategoria")
    List<CategoriaIncidencia> findBySubCategoria(String subCategoria);
}
