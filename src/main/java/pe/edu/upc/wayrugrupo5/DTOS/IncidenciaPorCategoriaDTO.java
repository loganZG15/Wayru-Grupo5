package pe.edu.upc.wayrugrupo5.DTOS;

public class IncidenciaPorCategoriaDTO {

    private String nombreCategoria;
    private long total;

    public IncidenciaPorCategoriaDTO() {}

    public IncidenciaPorCategoriaDTO(String nombreCategoria, long total) {
        this.nombreCategoria = nombreCategoria;
        this.total = total;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
}