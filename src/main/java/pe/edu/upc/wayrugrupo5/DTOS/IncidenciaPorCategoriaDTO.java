package pe.edu.upc.wayrugrupo5.DTOS;

public class IncidenciaPorCategoriaDTO {

    private String nombreCategoria;
    private int total;

    public IncidenciaPorCategoriaDTO() {}

    public IncidenciaPorCategoriaDTO(String nombreCategoria, int total) {
        this.nombreCategoria = nombreCategoria;
        this.total = total;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}