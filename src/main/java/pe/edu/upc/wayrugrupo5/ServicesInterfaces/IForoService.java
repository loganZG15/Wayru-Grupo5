package pe.edu.upc.wayrugrupo5.ServicesInterfaces;

import pe.edu.upc.wayrugrupo5.Entities.Foro;

import java.util.List;

public interface IForoService {
    List<Foro> listarTodo();

    void insertar(Foro foro);
}
