package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Evidencia;
import pe.edu.upc.wayrugrupo5.Repositories.IEvidenciaRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IEvidenciaService;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenciaServiceImplement implements IEvidenciaService {

    @Autowired
    private IEvidenciaRepository eR;

    @Override
    public Evidencia insert(Evidencia evidencia) {
        return eR.save(evidencia);
    }

    @Override
    public List<Evidencia> getAll() {
        return eR.findAll();
    }

    @Override
    public Optional<Evidencia> getById(int id) {
        return eR.findById(id);
    }

    @Override
    public List<Evidencia> getByIncidencia(int idIncidencia) {
        return eR.findByIncidenciaIdIncidencia(idIncidencia);
    }
}
