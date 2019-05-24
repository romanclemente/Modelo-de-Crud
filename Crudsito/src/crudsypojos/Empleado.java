package clementejurado_román_crudsypojos;

public class Empleado {

    private Integer codigoempleado;
    private String nombre;
    private String apellido1;
    private String apellido2;//admite nulos
    private Integer extension;
    private String email;
    private String codigooficina;
    private String codigojefe;// admite nulos
    private String puesto;//admite nulos
    private Oficina oficina;

//    private Empleado jefe;
    public Empleado() {
    }

    public Empleado(Integer codigoempleado, String nombre, String apellido1, String apellido2, Integer extension, String email, String codigooficina, String codigojefe, String puesto) {
        this.codigoempleado = codigoempleado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.extension = extension;
        this.email = email;
        this.codigooficina = codigooficina;
        this.codigojefe = codigojefe;
        this.puesto = puesto;
        this.oficina = null;
    }

    public Integer getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigooficina() {
        return codigooficina;
    }

    public void setCodigooficina(String codigooficina) {
        this.codigooficina = codigooficina;
    }

    public String getCodigojefe() {
        return codigojefe;
    }

    public void setCodigojefe(String codigojefe) {
        this.codigojefe = codigojefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public Oficina getOficina() {
        return oficina;
    }

    @Override
    public String toString() {
        return this.codigoempleado + "   | " + this.nombre + "   | " + this.apellido1 + "   | " + this.apellido2 + "    | " + this.codigooficina + "   | " + this.extension + "   | " + this.email + "   | " + this.codigojefe + "   | " + this.puesto + "   |" + this.oficina.toString();
    }
}
