package pe.edu.upc.wayrugrupo5.DTOS;

public class IncidenciaPorDistritoDTO {

    private String nombreDistrito;
    private int total;

    public IncidenciaPorDistritoDTO() {}

    public IncidenciaPorDistritoDTO(String nombreDistrito, int total) {
        this.nombreDistrito = nombreDistrito;
        this.total = total;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }
    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
