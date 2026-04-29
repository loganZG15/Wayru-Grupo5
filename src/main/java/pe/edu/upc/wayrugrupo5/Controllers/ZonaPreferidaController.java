package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.ZonaConDetalleDTO;
import pe.edu.upc.wayrugrupo5.DTOS.ZonaPreferidaDTO;
import pe.edu.upc.wayrugrupo5.Entities.ZonaPreferida;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.ICategoriaIncidenciaService;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IZonaPreferidaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/zona-preferida")
public class ZonaPreferidaController {
    @Autowired
    private IZonaPreferidaService zS;

    @PostMapping("/crear-zona-preferida")
    private ResponseEntity<ZonaPreferidaDTO> registrar(@RequestBody ZonaPreferidaDTO dto)
    {
        ModelMapper m = new ModelMapper();
        ZonaPreferida z = m.map(dto, ZonaPreferida.class);
        ZonaPreferida cur = zS.insert(z);
        ZonaPreferidaDTO responsedto = m.map(cur, ZonaPreferidaDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsedto);

    }

    @GetMapping("/con-detalle/{idUsuario}")
    public ResponseEntity<?> listarZonasConDetalle(@PathVariable int idUsuario) {
        List<Object[]> listaZonas = zS.listarZonasConDetalle(idUsuario);
        if (listaZonas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay zonas preferidas para este usuario");
        }
        List<ZonaConDetalleDTO> respuesta = new ArrayList<>();
        for (Object[] fila : listaZonas) {
            ZonaConDetalleDTO dto = new ZonaConDetalleDTO();
            dto.setIdZona(((Number) fila[0]).intValue());
            dto.setNombreDistrito((String) fila[1]);
            dto.setLatitud(((Number) fila[2]).doubleValue());
            dto.setLongitud(((Number) fila[3]).doubleValue());
            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }

}
