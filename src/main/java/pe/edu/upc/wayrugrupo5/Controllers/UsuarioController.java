package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.UsuarioDTO;
import pe.edu.upc.wayrugrupo5.Entities.Usuario;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @PostMapping("/crear-usuario")
    public ResponseEntity<UsuarioDTO> registrar(@RequestBody UsuarioDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        Usuario cur =uS.insert(u);
        UsuarioDTO responseDTO = m.map(cur, UsuarioDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/por-email")
    public ResponseEntity<?> buscarPorEmail(@RequestParam("email") String email) {
        ModelMapper m = new ModelMapper();
        Usuario u = uS.buscarPorEmail(email);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un usuario con ese email");
        } else {
            return ResponseEntity.ok(m.map(u, UsuarioDTO.class));
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorNombre(@RequestParam("nombre") String nombre) {
        ModelMapper m = new ModelMapper();
        List<UsuarioDTO> lista = uS.buscarPorNombre(nombre)
                .stream()
                .map(u -> m.map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios con ese nombre");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Usuario u = uS.buscarPorId(id);

        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el usuario con el ID: " + id);
        } else {
            return ResponseEntity.ok(m.map(u, UsuarioDTO.class));
        }
    }

    @GetMapping("/listar")
    public List<UsuarioDTO> listar() {
        ModelMapper m = new ModelMapper();
        return uS.listarTodo().stream()
                .map(u -> m.map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
    }
}