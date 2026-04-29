package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.ZonaPreferida;

import java.util.List;

@Repository
public interface IZonaPreferidaRepository extends JpaRepository<ZonaPreferida, Integer> {
    @Query(value = "SELECT zp.idZona, zp.nombreDistrito, d.latitud, d.longitud " +
            " FROM zonaPreferida zp " +
            " INNER JOIN Distrito d ON zp.distrito = d.idDistrito " +
            " WHERE zp.idUsuario = :idUsuario", nativeQuery = true)
    List<Object[]> findZonasConDetalleByUsuario(int idUsuario);
}
