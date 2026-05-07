package pe.edu.upc.wayrugrupo5.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IEvidenciaService;

@RestController
@RequestMapping("/api/evidencia")
public class EvidenciaController {

    @Autowired
    private IEvidenciaService eS;
}
