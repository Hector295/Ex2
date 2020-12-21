package Daos;

import Beans.Cine;
import Beans.Empleado;
import Beans.Rol;

import java.sql.*;
import java.util.ArrayList;

public class EmpleadoDao extends BaseDao{
    Empleado empleado = new Empleado();
    public Empleado obtenerEmpleado(int id){
        empleado=null;
        String sql = "SELECT * FROM empleado where idempleado=?;";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setApellido(rs.getString(3));
                    empleado.setDni(rs.getString(4));
                    empleado.setSalario(rs.getBigDecimal(5));
                    empleado.setFechaContrato(rs.getString(6));
                    empleado.setNombreUsuario(rs.getString(7));
                    empleado.setEdad(rs.getInt(8));
                    empleado.setActivo(rs.getBoolean(9));
                    Cine cine = new Cine();
                    cine.setIdCine(rs.getInt(10));
                    empleado.setCine(cine);

                    Empleado jefe = new Empleado();
                    jefe.setIdEmpleado(rs.getInt(11));
                    empleado.setJefe(jefe);
                    empleado.setRoles(listaRoles());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }
    public ArrayList<Rol> listaRoles(){
      ArrayList<Rol> list = new ArrayList<>();
      String sql="SELECT * FROM movies.rol;";
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt(1));
                rol.setNombre(rs.getString(2));
                list.add(rol);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
}
