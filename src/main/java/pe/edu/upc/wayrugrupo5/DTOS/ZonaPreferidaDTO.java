package pe.edu.upc.wayrugrupo5.DTOS;

import pe.edu.upc.wayrugrupo5.Entities.Distrito;
import pe.edu.upc.wayrugrupo5.Entities.Usuario;

public class ZonaPreferidaDTO {
    private int idZona;
    private String nombreDistrito;
    private int idUsuario;
    private int idDistrito;

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }
}
