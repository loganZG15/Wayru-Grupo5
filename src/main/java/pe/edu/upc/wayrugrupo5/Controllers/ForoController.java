package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.ForoDTO;
import pe.edu.upc.wayrugrupo5.Entities.Foro;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IForoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/foro")
public class ForoController {
    @Autowired
    private IForoService fS;

    @PostMapping("/insertar")
    public void insertar(@RequestBody ForoDTO dto) {

        ModelMapper m = new ModelMapper();
        Foro f = m.map(dto, Foro.class);

        fS.insertar(f);
    }

    @GetMapping("/listar")
    public List<ForoDTO> listar() {
        ModelMapper m = new ModelMapper();

        return fS.listarTodo().stream()
                .map(f -> m.map(f, ForoDTO.class))
                .collect(Collectors.toList());
    }


}
