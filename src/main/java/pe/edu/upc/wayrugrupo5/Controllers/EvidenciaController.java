package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.EvidenciaDTO;
import pe.edu.upc.wayrugrupo5.Entities.Evidencia;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IEvidenciaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/evidencia")
@PreAuthorize("hasAuthority('soporte') or hasAuthority('admin')")
public class EvidenciaController {

    @Autowired
    private IEvidenciaService eS;

    @PostMapping("/crear")
    public ResponseEntity<EvidenciaDTO> registrar(@RequestBody EvidenciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Evidencia evidencia = m.map(dto, Evidencia.class);
        Evidencia guardada = eS.insert(evidencia);
        EvidenciaDTO responseDTO = m.map(guardada, EvidenciaDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        ModelMapper m = new ModelMapper();
        List<EvidenciaDTO> lista = eS.getAll()
                .stream()
                .map(e -> m.map(e, EvidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay evidencias registradas");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Evidencia> evidencia = eS.getById(id);
        if (evidencia.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Evidencia con id " + id + " no encontrada");
        }
        return ResponseEntity.ok(m.map(evidencia.get(), EvidenciaDTO.class));
    }

    @GetMapping("/por-incidencia/{idIncidencia}")
    public ResponseEntity<?> listarPorIncidencia(@PathVariable int idIncidencia) {
        ModelMapper m = new ModelMapper();
        List<EvidenciaDTO> lista = eS.getByIncidencia(idIncidencia)
                .stream()
                .map(e -> m.map(e, EvidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay evidencias para la incidencia con id " + idIncidencia);
        }
        return ResponseEntity.ok(lista);
    }
}
