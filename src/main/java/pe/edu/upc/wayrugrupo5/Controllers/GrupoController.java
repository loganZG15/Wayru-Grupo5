package pe.edu.upc.wayrugrupo5.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wayrugrupo5.DTOS.GrupoDTO;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IGrupoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    @Autowired
    private IGrupoService gS;

    @GetMapping("/listar")
    public List<GrupoDTO> listar() {
        ModelMapper m = new ModelMapper();
        return gS.listarTodo().stream()
                .map(g -> m.map(g, GrupoDTO.class))
                .collect(Collectors.toList());
    }
}