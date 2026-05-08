package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.DistritoDTO;
import pe.edu.upc.wayrugrupo5.Entities.Distrito;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IDistritoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/distrito")
public class DistritoController {

    @Autowired
    private IDistritoService dS;

    @PostMapping("/crear-distritos")
    @PreAuthorize("hasAuthority('soporte')")
    public ResponseEntity<DistritoDTO> registrar(@RequestBody DistritoDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Distrito d = m.map(dto, Distrito.class);
        Distrito cur = dS.insert(d);
        DistritoDTO responseDTO = m.map(cur, DistritoDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/buscar")
    @PreAuthorize("hasAuthority('cliente') or hasAuthority('soporte')")
    public ResponseEntity<?> buscarPorNombre(@RequestParam("nombre") String nombre) {
        ModelMapper m = new ModelMapper();
        Distrito d = dS.buscarPorNombre(nombre);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el distrito con ese nombre");
        } else {
            return ResponseEntity.ok(m.map(d, DistritoDTO.class));
        }
    }

    @GetMapping("/con-incidencias")
    @PreAuthorize("hasAuthority('cliente') or hasAuthority('soporte')")
    public ResponseEntity<List<DistritoDTO>> listarConIncidencias() {
        ModelMapper m = new ModelMapper();
        List<DistritoDTO> lista = dS.listarConIncidencias()
                .stream()
                .map(d -> m.map(d, DistritoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
