package pe.edu.upc.wayrugrupo5.DTOS;
import pe.edu.upc.wayrugrupo5.Entities.Usuario;

public class GrupoDTO {
    private int idGrupo;
    private String nombreGrupo;
    private String descripcion;
    private String tipoGrupo;
    private Usuario usuario;

    public int getIdGrupo() {return idGrupo;}

    public void setIdGrupo(int idGrupo) {this.idGrupo = idGrupo;}

    public String getNombreGrupo() {return nombreGrupo;}

    public void setNombreGrupo(String nombreGrupo) {this.nombreGrupo = nombreGrupo;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getTipoGrupo() {return tipoGrupo;}

    public void setTipoGrupo(String tipoGrupo) {this.tipoGrupo = tipoGrupo;}
}
