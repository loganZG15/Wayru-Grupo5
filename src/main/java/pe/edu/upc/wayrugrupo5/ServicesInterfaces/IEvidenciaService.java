package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Evidencia;

import java.util.List;
import java.util.Optional;

@Service
public interface IEvidenciaService {
    Evidencia insert(Evidencia evidencia);
    List<Evidencia> getAll();
    Optional<Evidencia> getById(int id);
    List<Evidencia> getByIncidencia(int idIncidencia);
}
