package Daos;

import Beans.Empleado;

public class LoginDao {
    public Empleado obteneEmpleado(String dni, String pass){
        Empleado empleado = new Empleado();
        String sql = "SELECT e.dni,e.salario,r.nombre FROM empleado e, rol r , rolempleado ro\n" +
                "where e.idempleado=ro.idempleado and ro.idrol=r.idrol;";

        return empleado;
    }
}
