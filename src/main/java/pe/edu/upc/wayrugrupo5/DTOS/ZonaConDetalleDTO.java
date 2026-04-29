package pe.edu.upc.wayrugrupo5.DTOS;

public class ZonaConDetalleDTO {

    private int idZona;
    private String nombreDistrito;
    private double latitud;
    private double longitud;

    public ZonaConDetalleDTO() {}

    public ZonaConDetalleDTO(int idZona, String nombreDistrito, double latitud, double longitud) {
        this.idZona = idZona;
        this.nombreDistrito = nombreDistrito;
        this.latitud = latitud;
        this.longitud = longitud;
    }

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

    public double getLatitud() {
        return latitud;
    }
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
