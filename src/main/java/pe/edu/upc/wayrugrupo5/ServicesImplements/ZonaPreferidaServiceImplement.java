package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.wayrugrupo5.Entities.ZonaPreferida;
import pe.edu.upc.wayrugrupo5.Repositories.IZonaPreferidaRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IZonaPreferidaService;

import java.util.List;

public class ZonaPreferidaServiceImplement implements IZonaPreferidaService {

    @Autowired
    private IZonaPreferidaRepository zR;


    @Override
    public ZonaPreferida insert(ZonaPreferida zp) {
        return zR.save(zp);
    }

    @Override
    public List<Object[]> listarZonasConDetalle(int idUsuario) {
        return zR.findZonasConDetalleByUsuario(idUsuario);
    }
}
