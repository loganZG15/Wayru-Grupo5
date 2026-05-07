package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Repositories.IEvidenciaRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IEvidenciaService;

@Service
public class EvidenciaServiceImplement implements IEvidenciaService {

    @Autowired
    private IEvidenciaRepository eR;
}
