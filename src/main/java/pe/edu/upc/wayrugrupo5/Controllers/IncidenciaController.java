package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.IncidenciaDTO;
import pe.edu.upc.wayrugrupo5.DTOS.IncidenciaPorCategoriaDTO;
import pe.edu.upc.wayrugrupo5.DTOS.IncidenciaPorDistritoDTO;
import pe.edu.upc.wayrugrupo5.Entities.Incidencia;
import pe.edu.upc.wayrugrupo5.Entities.Usuario;
import pe.edu.upc.wayrugrupo5.Repositories.IUsuarioRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IIncidenciaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incidencias")
@PreAuthorize("hasAnyAuthority('cliente', 'soporte', 'admin')")
public class IncidenciaController {

    @Autowired
    private IIncidenciaService iS;

    @Autowired
    private IUsuarioRepository uR;

    private Usuario usuarioActual() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return uR.findByNombreUsuario(username);
    }

    private boolean puedeGestionarTodo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("admin") || a.getAuthority().equals("soporte"));
    }

    @GetMapping("/mis-incidencias")
    public ResponseEntity<?> misIncidencias() {
        Usuario usuario = usuarioActual();
        ModelMapper m = new ModelMapper();
        List<IncidenciaDTO> lista = iS.listarPorUsuario(usuario.getIdUsuario())
                .stream()
                .map(inc -> m.map(inc, IncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No tienes incidencias registradas");
        }
        return ResponseEntity.ok(lista);
    }

    @PreAuthorize("hasAnyAuthority('cliente', 'admin')")
    @PostMapping("/Crear-incidencias")
    public ResponseEntity<IncidenciaDTO> registrar(@RequestBody IncidenciaDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Incidencia i = m.map(dto, Incidencia.class);
        Incidencia cur = iS.insert(i);
        IncidenciaDTO responseDTO = m.map(cur, IncidenciaDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/por-distrito/{idDistrito}")
    public ResponseEntity<?> listarPorDistrito(@PathVariable int idDistrito) {
        ModelMapper m = new ModelMapper();
        List<IncidenciaDTO> lista = iS.listarPorDistrito(idDistrito)
                .stream()
                .map(inc -> m.map(inc, IncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay incidencias para este distrito");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/por-categoria/{idCategoria}")
    public ResponseEntity<?> listarPorCategoria(@PathVariable int idCategoria) {
        ModelMapper m = new ModelMapper();
        List<IncidenciaDTO> lista = iS.listarPorCategoria(idCategoria)
                .stream()
                .map(inc -> m.map(inc, IncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay incidencias para esta categoría");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/activas")
    public ResponseEntity<?> listarActivas() {
        ModelMapper m = new ModelMapper();
        List<IncidenciaDTO> lista = iS.listarActivas()
                .stream()
                .map(inc -> m.map(inc, IncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay incidencias activas");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/conteo-por-categoria")
    public ResponseEntity<?> contarPorCategoria() {
        List<Object[]> listaConteo = iS.contarPorCategoria();
        if (listaConteo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay incidencias registradas por categoría");
        }
        List<IncidenciaPorCategoriaDTO> respuesta = new ArrayList<>();
        for (Object[] fila : listaConteo) {
            IncidenciaPorCategoriaDTO dto = new IncidenciaPorCategoriaDTO();
            dto.setNombreCategoria((String) fila[0]);
            dto.setTotal(((Number) fila[1]).intValue());
            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/conteo-por-distrito")
    public ResponseEntity<?> contarPorDistrito() {
        List<Object[]> listaConteo = iS.contarPorDistrito();
        if (listaConteo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay incidencias registradas por distrito");
        }
        List<IncidenciaPorDistritoDTO> respuesta = new ArrayList<>();
        for (Object[] fila : listaConteo) {
            IncidenciaPorDistritoDTO dto = new IncidenciaPorDistritoDTO();
            dto.setNombreDistrito((String) fila[0]);
            dto.setTotal(((Number) fila[1]).intValue());
            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        ModelMapper m = new ModelMapper();
        List<IncidenciaDTO> lista = iS.listarTodo()
                .stream()
                .map(inc -> m.map(inc, IncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay incidencias registradas");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Incidencia i = iS.buscarPorId(id);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Incidencia con id " + id + " no encontrada");
        }
        return ResponseEntity.ok(m.map(i, IncidenciaDTO.class));
    }

    @PreAuthorize("hasAnyAuthority('cliente', 'soporte', 'admin')")
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody IncidenciaDTO dto) {
        Incidencia existente = iS.buscarPorId(dto.getIdIncidencia());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Incidencia con id " + dto.getIdIncidencia() + " no encontrada");
        }
        if (!puedeGestionarTodo() && existente.getUsuario().getIdUsuario() != usuarioActual().getIdUsuario()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("No puedes actualizar una incidencia que no es tuya");
        }
        ModelMapper m = new ModelMapper();
        Incidencia i = m.map(dto, Incidencia.class);
        Incidencia actualizada = iS.update(i);
        return ResponseEntity.ok(m.map(actualizada, IncidenciaDTO.class));
    }

    @PreAuthorize("hasAnyAuthority('cliente', 'soporte', 'admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Incidencia existente = iS.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Incidencia con id " + id + " no encontrada");
        }
        if (!puedeGestionarTodo() && existente.getUsuario().getIdUsuario() != usuarioActual().getIdUsuario()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("No puedes eliminar una incidencia que no es tuya");
        }
        iS.delete(id);
        return ResponseEntity.ok("Incidencia eliminada correctamente");
    }
}