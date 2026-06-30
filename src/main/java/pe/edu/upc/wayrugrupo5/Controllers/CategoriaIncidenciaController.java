package pe.edu.upc.wayrugrupo5.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.CategoriaIncidenciaDTO;
import pe.edu.upc.wayrugrupo5.Entities.CategoriaIncidencia;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.ICategoriaIncidenciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categoria-incidencia")
//@PreAuthorize("hasAuthority('cliente') or hasAuthority('soporte')")
public class CategoriaIncidenciaController {

    @Autowired
    private ICategoriaIncidenciaService iS;

    @PostMapping("/Crear-categorias-incidencias")
    //@PreAuthorize("hasAuthority('cliente')")
    private ResponseEntity<CategoriaIncidenciaDTO> registrar(@RequestBody CategoriaIncidenciaDTO dto)
    {
        ModelMapper m = new ModelMapper();
        CategoriaIncidencia cI = m.map(dto, CategoriaIncidencia.class);
        CategoriaIncidencia cur = iS.insert(cI);
        CategoriaIncidenciaDTO responsedto = m.map(cur, CategoriaIncidenciaDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsedto);
    }

    @GetMapping("/por-nombre")
    //@PreAuthorize("hasAuthority('soporte') or hasAuthority('admin')")
    public ResponseEntity<?> buscarPorNombre(@RequestParam("nombre") String nombre) {
        ModelMapper m = new ModelMapper();
        List<CategoriaIncidenciaDTO> lista = iS.buscarPorNombre(nombre)
                .stream()
                .map(c -> m.map(c, CategoriaIncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron categorías con ese nombre");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/por-subcategoria")
    public ResponseEntity<?> buscarPorSubCategoria(@RequestParam("subCategoria") String subCategoria) {
        ModelMapper m = new ModelMapper();
        List<CategoriaIncidenciaDTO> lista = iS.buscarPorSubCategoria(subCategoria)
                .stream()
                .map(c -> m.map(c, CategoriaIncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron categorías con esa subCategoría");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        ModelMapper m = new ModelMapper();
        List<CategoriaIncidenciaDTO> lista = iS.listarTodo()
                .stream()
                .map(c -> m.map(c, CategoriaIncidenciaDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay categorías registradas");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        CategoriaIncidencia c = iS.buscarPorId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría con id " + id + " no encontrada");
        }
        return ResponseEntity.ok(m.map(c, CategoriaIncidenciaDTO.class));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody CategoriaIncidenciaDTO dto) {
        ModelMapper m = new ModelMapper();
        CategoriaIncidencia c = m.map(dto, CategoriaIncidencia.class);
        CategoriaIncidencia actualizada = iS.update(c);
        return ResponseEntity.ok(m.map(actualizada, CategoriaIncidenciaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        CategoriaIncidencia existente = iS.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría con id " + id + " no encontrada");
        }
        iS.delete(id);
        return ResponseEntity.ok("Categoría eliminada correctamente");
    }
}
