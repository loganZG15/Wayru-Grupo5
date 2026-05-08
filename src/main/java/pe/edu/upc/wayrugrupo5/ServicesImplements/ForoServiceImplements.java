package pe.edu.upc.wayrugrupo5.ServicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wayrugrupo5.Entities.Foro;
import pe.edu.upc.wayrugrupo5.Repositories.IForoRepository;
import pe.edu.upc.wayrugrupo5.ServicesInterfaces.IForoService;

import java.util.List;

@Service
public class ForoServiceImplements implements IForoService {
    @Autowired
    private IForoRepository fR;

    @Override
    public List<Foro> listarTodo() {
        return fR.findAll();
    }

    @Override
    public void insertar(Foro foro) {
        fR.save(foro);
    }


}
