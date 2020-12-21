package Daos;

import Beans.Cadena;
import Beans.Cartelera;
import Beans.Cine;
import Beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class DaoCartelera extends BaseDao {
    public ArrayList<Cartelera> listaCartelera() {
        ArrayList<Cartelera> carteleras = new ArrayList<>();
        String sql = "select cd.nombre_comercial, c.nombre, p.nombre, ct.horario, ct.3d, ct.doblada, ct.subtitulada" +
                "from cartelera ct, cine c, pelicula p, cadena cd " +
                "where cd.idcadena=c.idcadena and ct.idcine=c.idcine and ct.idpelicula=p.idpelicula;";
        try (Connection conn = getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cartelera cartelera = new Cartelera();

                Cine cine = new Cine();
                cine.setNombre(rs.getString(2));
                Cadena cadena = new Cadena();
                cadena.setNombreComercial(rs.getString(1));
                cine.setCadena(cadena);
                cartelera.setCine(cine);

                Pelicula pelicula =new Pelicula();
                pelicula.setNombre(rs.getString(3));
                cartelera.setPelicula(pelicula);

                cartelera.setHorario(rs.getString(4));
                cartelera.setTresD(rs.getInt(5));
                cartelera.setDoblada(rs.getInt(6));
                cartelera.setSubtitulada(rs.getInt(7));

                carteleras.add(cartelera);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carteleras;
    }
}
