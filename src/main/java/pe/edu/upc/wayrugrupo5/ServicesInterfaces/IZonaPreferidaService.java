package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.ZonaPreferida;

import java.util.List;

@Service
public interface IZonaPreferidaService {
    public ZonaPreferida insert(ZonaPreferida zp);
    List<Object[]> listarZonasConDetalle(int idUsuario);

}
