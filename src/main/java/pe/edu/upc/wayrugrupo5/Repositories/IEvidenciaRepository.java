package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.Evidencia;

import java.util.List;

@Repository
public interface IEvidenciaRepository extends JpaRepository<Evidencia, Integer> {
    List<Evidencia> findByIncidenciaIdIncidencia(int idIncidencia);
}
