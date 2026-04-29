package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Distrito;
import pe.edu.upc.wayrugrupo5.Repositories.IDistritoRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IDistritoService;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImplement implements IDistritoService {
    @Autowired
    private IDistritoRepository dR;

    @Override
    public Distrito insert(Distrito d) {
        return dR.save(d);
    }

    @Override
    public Distrito buscarPorNombre(String nombreDistrito) {
        return dR.findByNombreDistritoContainingIgnoreCase(nombreDistrito).orElse(null);
    }

    @Override
    public List<Distrito> listarConIncidencias() {
        return dR.findDistritosConIncidenciasContainingIgnoreCase();
    }
}
