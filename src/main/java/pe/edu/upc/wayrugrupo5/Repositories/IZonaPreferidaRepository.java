package pe.edu.upc.wayrugrupo5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wayrugrupo5.Entities.ZonaPreferida;

import java.util.List;

@Repository
public interface IZonaPreferidaRepository extends JpaRepository<ZonaPreferida, Integer> {
    @Query(value = "SELECT zp.idZona, zp.nombreDistrito, d.latitud, d.longitud " +
            " FROM zona_preferida zp " +
            " INNER JOIN distrito d ON zp.distrito = d.id_distrito " +
            " WHERE zp.id_usuario = :id_usuario", nativeQuery = true)
    List<Object[]> findZonasConDetalleByUsuario(@Param("id_usuario") int idUsuario);
}
