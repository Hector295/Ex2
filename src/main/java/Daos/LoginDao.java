package Daos;

import Beans.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends BaseDao{
    Empleado empleado = new Empleado();
    public Empleado obteneEmpleado(String dni, String pass){
        empleado= null;
        EmpleadoDao empleadoDao=new EmpleadoDao();
        String sql = "SELECT idempleado,dni, (dni-salario) as passw FROM movies.empleado" +
                "where dni=? and passw=?;";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, dni);
            pstmt.setString(2, pass);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    int employeeId = rs.getInt(1);
                    empleado = empleadoDao.obtenerEmpleado(employeeId);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empleado;
    }
}
