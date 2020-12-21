package Daos;

import Beans.Cartelera;

import java.sql.*;
import java.util.ArrayList;

public class DaoCartelera extends DaoBase {
    public ArrayList<Cartelera> listaCartelera() {
        String sql = "select cd.nombre_comercial, c.nombre, p.nombre, ct.horario from cartelera ct, cine c, " +
                "pelicula p, cadena cd where cd.idcadena=c.idcadena and ct.idcine=c.idcine and ct.idpelicula=p.idpelicula;";


    }
}
