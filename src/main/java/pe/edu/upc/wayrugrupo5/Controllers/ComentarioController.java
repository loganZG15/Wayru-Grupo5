package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.ComentarioDTO;
import pe.edu.upc.wayrugrupo5.Entities.Comentario;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IComentarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comentario")
@PreAuthorize("hasAuthority('cliente') or hasAuthority('admin')")
public class ComentarioController {

        @Autowired
        private IComentarioService cS;

        @PostMapping("/crear")
        public ResponseEntity<ComentarioDTO> registrar(@RequestBody ComentarioDTO dto) {
                ModelMapper m = new ModelMapper();
                Comentario comentario = m.map(dto, Comentario.class);
                Comentario guardado = cS.insert(comentario);
                ComentarioDTO responseDTO = m.map(guardado, ComentarioDTO.class);
                return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }

        @GetMapping("/listar")
        public ResponseEntity<?> listar() {
                ModelMapper m = new ModelMapper();
                List<ComentarioDTO> lista = cS.getAll()
                        .stream()
                        .map(c -> m.map(c, ComentarioDTO.class))
                        .collect(Collectors.toList());
                if (lista.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("No hay comentarios registrados");
                }
                return ResponseEntity.ok(lista);
        }

        @GetMapping("/buscar/{id}")
        public ResponseEntity<?> buscarPorId(@PathVariable int id) {
                ModelMapper m = new ModelMapper();
                Optional<Comentario> comentario = cS.getById(id);
                if (comentario.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("Comentario con id " + id + " no encontrado");
                }
                return ResponseEntity.ok(m.map(comentario.get(), ComentarioDTO.class));
        }

        @GetMapping("/por-incidencia/{idIncidencia}")
        public ResponseEntity<?> listarPorIncidencia(@PathVariable int idIncidencia) {
                ModelMapper m = new ModelMapper();
                List<ComentarioDTO> lista = cS.getByIncidencia(idIncidencia)
                        .stream()
                        .map(c -> m.map(c, ComentarioDTO.class))
                        .collect(Collectors.toList());
                if (lista.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("No hay comentarios para la incidencia con id " + idIncidencia);
                }
                return ResponseEntity.ok(lista);
        }
}
