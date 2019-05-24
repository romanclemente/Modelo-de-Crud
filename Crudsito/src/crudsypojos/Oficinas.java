package clementejurado_román_crudsypojos;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Oficinas {

    private Connection conexion = null;
    private ArrayList<Oficina> oficinas;

    public Oficinas() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineras", "jardineras", "jardineras");
    }
//codigooficina ciudad pais region codigopostal telefono lineadedireccion1 lineadedireccion2

    public int Create(Oficina ofc) throws SQLException {
        int filas;
        String sql = "INSERT INTO oficinas VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement insert = conexion.prepareStatement(sql);

        insert.setString(1, ofc.getCodigooficina());
        insert.setString(2, ofc.getCiudad());
        insert.setString(3, ofc.getPais());
        insert.setString(4, ofc.getRegion());
        insert.setString(5, ofc.getCodigopostal());
        insert.setString(6, ofc.getTelefono());
        insert.setString(7, ofc.getLineadedireccion1());
        insert.setString(8, ofc.getLineadedireccion2());

        filas = insert.executeUpdate();
        return filas;
    }

    public Oficina update(String codigooficina, String ciudad, String pais, String region, String codigopostal, String telefono, String lineadedireccion1, String lineadedireccion2) throws SQLException {

        String sql = "UPDATE oficinas SET ciudad = ?, pais = ?, region = ?,  codigopostal = ?, telefono = ?, lineadedireccion1 = ?, lineadedireccion2 = ?  WHERE CodigoEmpleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(9, codigooficina);
        ps.setString(1, ciudad);
        ps.setString(2, pais);
        ps.setString(3, region);
        ps.setString(4, codigopostal);
        ps.setString(5, telefono);
        ps.setString(6, lineadedireccion1);
        ps.setString(7, lineadedireccion2);

        ps.executeUpdate();
        return null;
    }

    public ArrayList<Oficina> list(String condiciones) throws SQLException {

        ArrayList<Oficina> resultado = new ArrayList();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM oficinas "+condiciones);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String codigooficina = rs.getString("codigooficina");
                String ciudad = rs.getString("Ciudad");
                String pais = rs.getString("Pais");
                String region = rs.getString("Region");
                String codigopostal = rs.getString("codigopostal");
                String telefono = rs.getString("telefono");
                String lineadireccion1 = rs.getString("lineadireccion1");
                String lineadireccion2 = rs.getString("lineadireccion2");

                Oficina ofc = new Oficina(codigooficina, ciudad, pais, region, codigopostal, telefono, lineadireccion1, lineadireccion2);
                resultado.add(ofc);

            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return resultado;

    }

    public ArrayList<String> ofis() throws SQLException {

        ArrayList<String> resultado = new ArrayList();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT codigooficina FROM oficinas");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String codigooficina = rs.getString("codigooficina");

                resultado.add(codigooficina);

            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return resultado;

    }

    public Oficina delete(String codigooficina) throws SQLException {
        String sql = "DELETE FROM empleados WHERE CodigoEmpleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, codigooficina);
        ps.executeUpdate();
        return null;
    }
}
