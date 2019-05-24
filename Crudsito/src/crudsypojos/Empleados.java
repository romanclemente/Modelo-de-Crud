/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clementejurado_román_crudsypojos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleados {

    private Connection conexion = null;
    private ArrayList<Empleado> empleados;

    public Empleados() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineras", "jardineras", "jardineras");
    }

    public int Create(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement insert = conexion.prepareStatement(sql);

        insert.setInt(1, emp.getCodigoempleado());
        insert.setString(2, emp.getNombre());
        insert.setString(3, emp.getApellido1());
        insert.setString(4, emp.getApellido2());
        insert.setInt(5, emp.getExtension());
        insert.setString(6, emp.getEmail());
        insert.setString(7, emp.getCodigooficina());
        insert.setString(8, emp.getCodigojefe());
        insert.setString(9, emp.getPuesto());

        filas = insert.executeUpdate();
        return filas;
    }

    public Empleado update(String condiciones,Integer codigoempleado) throws SQLException {

        String sql = "UPDATE empleados SET "+condiciones+" WHERE CodigoEmpleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, codigoempleado);

        int rs = ps.executeUpdate();
        return null;
    }

    public ArrayList<Empleado> joinisito(String condiciones) throws SQLException {
        ArrayList<Empleado> resultado = new ArrayList();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM `empleados` INNER JOIN oficinas on empleados.CodigoOficina=oficinas.CodigoOficina " + condiciones);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado(rs.getInt("CodigoEmpleado"), rs.getString("Nombre"),
                        rs.getString("Apellido1"), rs.getString("Apellido2"),
                        rs.getInt("Extension"), rs.getString("Email"),
                        rs.getString("empleados.codigooficina"), rs.getString("CodigoJefe"),
                        rs.getString("Puesto"));
                Oficina ofi = new Oficina(rs.getString("oficinas.codigooficina"), rs.getString("Ciudad"),
                        rs.getString("Pais"), rs.getString("Region"),
                        rs.getString("codigopostal"), rs.getString("telefono"),
                        rs.getString("lineadireccion1"), rs.getString("lineadireccion2")
                );

                emp.setOficina(ofi);
                resultado.add(emp);
            }
        } catch (SQLException e) {
            System.err.println("Error en la base de datos" + e.getMessage());
        }
        return resultado;
    }

    public ArrayList<Empleado> Read(String condiciones) throws SQLException {
        ArrayList<Empleado> resultado = new ArrayList();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleados " + condiciones);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codigoempleado = rs.getInt("CodigoEmpleado");
                String Nombre = rs.getString("Nombre");
                String Apellido1 = rs.getString("Apellido1");
                String Apellido2 = rs.getString("Apellido2");
                int Extension = rs.getInt("Extension");
                String Email = rs.getString("Email");
                String CodigoOficina = rs.getString("CodigoOficina");
                String CodigoJefe = rs.getString("CodigoJefe");
                String Puesto = rs.getString("Puesto");

                Empleado emp = new Empleado(codigoempleado, Nombre, Apellido1, Apellido2, Extension, Email, CodigoOficina, CodigoJefe, Puesto);
                resultado.add(emp);

            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return resultado;
    }

    public Empleado delete(Integer CodigoEmpleado) throws SQLException {
        String sql = "DELETE FROM empleados WHERE CodigoEmpleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, CodigoEmpleado);
        int rs = ps.executeUpdate();
        return null;
    }

    public void Close() throws SQLException {
        conexion.close();
    }
}
