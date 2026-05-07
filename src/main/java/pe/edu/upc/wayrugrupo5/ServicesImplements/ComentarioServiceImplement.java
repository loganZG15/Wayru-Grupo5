package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Repositories.IComentarioRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IComentarioService;

@Service
public class ComentarioServiceImplement implements IComentarioService {

    @Autowired
    private IComentarioRepository cR;

}
