package clementejurado_román_crudsypojos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class ClementeJurado_Román_CrudsYPojos {

    public static Oficinas estalecerConexionOficina() {
        Oficinas bbdd = null;
        try {
            bbdd = new Oficinas();
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
        System.out.println("Conexión Satisfactoria");
        return bbdd;
    }

    public static Oficina crearOficina(String codigooficina, String ciudad, String pais, String region, String codigopostal, String telefono, String lineadedireccion1, String lineadedireccion2) {
        Oficinas bbdd = estalecerConexionOficina();
        Oficina of = new Oficina(codigooficina, ciudad, pais, region, codigopostal, telefono, lineadedireccion1, lineadedireccion2);
        System.out.println("Se realizara la introduccion de la nueva oficina" + codigooficina + " a la base de datos");
        try {

            System.out.println("Realizando insert para " + of);
            bbdd.Create(of);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());

        }
        return of;
    }

    public static void actualizarOficina(String codigooficina, String ciudad, String pais, String region, String codigopostal, String telefono, String lineadedireccion1, String lineadedireccion2) {
        Oficinas bbdd = estalecerConexionOficina();
        try {
            bbdd.update(codigooficina, ciudad, pais, region, codigopostal, telefono, lineadedireccion1, lineadedireccion2);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static void eliminarOficina(String codigooficina) {
        Oficinas bbdd = estalecerConexionOficina();
        try {
            bbdd.delete(codigooficina);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("Eliminado con exito");
    }

    public static void selectOficina(String condiciones) {
        Oficinas bbdd = estalecerConexionOficina();
        try {
            ArrayList<Oficina> resultado;

            resultado = bbdd.list(condiciones);
            System.out.println("");
            System.out.println("Tabla Oficina");
            System.out.println("");
            System.out.println("| Codigo Oficina  | Ciudad\t\t      |  Region \t          |  Codigo Postal  | Telefono             | Linea de direccion 1           | Linea de direccion 2");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (Oficina of : resultado) {
                System.out.printf("| %-15s | %-25s | %-25s | %-15s | %-20s | %-30s | %-15s \n", of.getCodigooficina(), of.getCiudad(), of.getRegion(), of.getCodigopostal(), of.getTelefono(), of.getLineadedireccion1(), of.getLineadedireccion2());
            }
            System.out.println("");
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
    }

    public static void ofis() {
        Oficinas bbdd = estalecerConexionOficina();
        try {
            ArrayList<String> resultado;

            resultado = bbdd.ofis();
            System.out.println("| Codigo Oficina  |");
            System.out.println("-------------------");

            for (String of : resultado) {
                System.out.printf("| %-15s | \n", of);
            }
            System.out.println("");
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
    }

    public static Empleados estalecerConexionEmpleado() {
        Empleados bbdd = null;
        try {
            bbdd = new Empleados();
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
        System.out.println("Conexión Satisfactoria");
        return bbdd;
    }

    public static Empleado crearEmpleado(int codigo, String nombre, String apellido1, String apellido2, int extension, String correo, String coficina, String cjefe, String puesto) {
        Empleados bbdd = estalecerConexionEmpleado();
        Empleado emp = new Empleado(codigo, nombre, apellido1, apellido2, extension, cjefe, coficina, cjefe, puesto);
        System.out.println("Se realizara la introduccion del nuevo empleado " + nombre + " a la base de datos");
        try {

            System.out.println("Realizando insert para " + emp);
            bbdd.Create(emp);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());

        }
        return emp;
    }

    public static void joinsito(String condiciones) {
        Empleados bbdd = estalecerConexionEmpleado();
        Empleado emp = null;
        Oficina ofc = null;
        try {
            ArrayList<Empleado> resultado;
            resultado = bbdd.joinisito(condiciones);
            System.out.println("Tabla union");
            System.out.println("| Codigo Empleado | Nombre          |  1º Apellido    |  2º Apellido    | Extensión            | Email                          | Codigo Oficina  | Codigo Jefe     | Puesto\t\t             | Codigo Oficina  | Ciudad\t\t           |  Region \t               | Codigo Postal   | Telefono             | Linea de direccion 1           | Linea de direccion 2");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Empleado of : resultado) {
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-20s | %-30s | %-15s | %-15s | %-30s | %-15s | %-25s | %-25s | %-15s | %-20s | %-30s | %-15s \n", of.getCodigoempleado(), of.getNombre(), of.getApellido1(), of.getApellido2(), of.getExtension(), of.getEmail(), of.getCodigooficina(), of.getCodigojefe(), of.getPuesto(), of.getCodigooficina(), of.getOficina().getCiudad(), of.getOficina().getRegion(), of.getOficina().getCodigopostal(), of.getOficina().getTelefono(), of.getOficina().getLineadedireccion1(), of.getOficina().getLineadedireccion2());
            }
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
    }

    public static void actualizarEmpleado(String condiciones, Integer codigoempleado) {
        Empleados bbdd = estalecerConexionEmpleado();
        try {
            bbdd.update(condiciones, codigoempleado);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static void eliminarEmpleado(int codigoempleado) {
        Empleados bbdd = estalecerConexionEmpleado();
        try {
            bbdd.delete(codigoempleado);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("Eliminado con exito");
    }

    public static void selectEmpleado(String condiciones) {
        Empleados bbdd = estalecerConexionEmpleado();
        try {
            ArrayList<Empleado> rest;
            rest = bbdd.Read(condiciones);
            System.out.println("");
            System.out.println("Tabla Empleado");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________");
            System.out.println("| C.Emp | Nombre          |  1º Apellido    |  2º Apellido    | Exten | Email                          | C.Ofi.     | C.Jefe | Puesto                         |");
            System.out.println("+-------+-----------------+-----------------+-----------------+-------+--------------------------------+------------+--------+--------------------------------+");
            for (Empleado em : rest) {
                System.out.printf("| %5s | %-15s | %-15s | %-15s | %5s | %-30s | %-10s | %6s | %-30s |\n", em.getCodigoempleado(), em.getNombre(), em.getApellido1(), em.getApellido2(), em.getExtension(), em.getEmail(), em.getCodigooficina(), em.getCodigojefe(), em.getPuesto());
            }
            System.out.println("+-------+-----------------+-----------------+-----------------+-------+--------------------------------+------------+--------+--------------------------------+");
            System.out.println("");
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Empleados bbdd = null;
        Oficinas bbd = null;
        Integer cempleado = -1;
        String tabla;
        Integer contador = 0;
        Integer contadorac = 0;
        String nombre;
        String apellido1;
        String apellido2;
        Integer extension = -1;
        String correo;
        String coficina;
        String cjefe;
        String puesto;
        String sino = "no";
        String tablita = "x";
        String operacion;
        System.out.println("Bienvenido al administrador de la base de datos de Jardineria");

        while (true) {
            String condiciones = "";
            while (true) {
                selectEmpleado(condiciones);
                // selectOficina(condiciones);
                System.out.println(" ________________________________");
                System.out.println("|¿Que operacion desea realizar?  |");
                System.out.println("+--------------------------------+");
                System.out.println("|C)rear                          |");
                System.out.println("|M)odificar                      |");
                System.out.println("|E)liminar                       |");
                System.out.println("|R)ealizar hacer un join         |");
                System.out.println("|F)iltrar informacion            |");
                System.out.println("+--------------------------------+");
                System.out.println("");
                System.out.println("_________________________________");
                System.out.println("|Escriba aqui                    |");
                System.out.println("+--------------------------------+");
                operacion = sc.nextLine();

                if (operacion.equalsIgnoreCase("c") || operacion.equalsIgnoreCase("m") || operacion.equalsIgnoreCase("e") || operacion.equalsIgnoreCase("r") || operacion.equalsIgnoreCase("f")) {
                    break;
                } else {
                    System.out.println("Error en opcion");
                }
            }
            if (operacion.equalsIgnoreCase("e")) {
                while (true) {
                    System.out.println("Inserte Codigo de Empleado");
                    try {
                        String _1;
                        _1 = sc.nextLine();
                        cempleado = Integer.parseInt(_1);
                        if (cempleado >= 0) {
                            while (true) {
                                System.out.println("¿Esta seguro de eliminar al empleado con codigo " + cempleado + "?");
                                System.out.println("S)i \t N)o");
                                String seguro;
                                String seguro2;
                                seguro = sc.nextLine();
                                if (seguro.equalsIgnoreCase("s")) {

                                    System.out.println("El objeto puede tener dependencias,¿Esta realmente seguro de eliminar a este usuario?, una vez hecho esto no podra deshacerse");
                                    System.out.println("S)i \t N)o");
                                    seguro2 = sc.nextLine();
                                    if (seguro2.equalsIgnoreCase("s")) {
                                        eliminarEmpleado(cempleado);
                                        break;
                                    } else if (seguro2.equalsIgnoreCase("n")) {
                                        break;
                                    } else {
                                        System.out.println("Error de tecla");
                                    }

                                } else if (seguro.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    System.out.println("Error de tecla");
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error en la introduccion de datos vuelva a intentar");
                    }
                }
            }

            if (operacion.equalsIgnoreCase("r") || operacion.equalsIgnoreCase("f") || operacion.equalsIgnoreCase("m")) {
                while (true) {
                    if (operacion.equalsIgnoreCase("r")) {
                        System.out.println("¿Desea usar filtros para hacer su seleccion?");
                        System.out.println("S)i \t N)o");
                        sino = sc.nextLine();
                        if (sino.equalsIgnoreCase("n")) {
                            joinsito(condiciones);
                            break;
                        }
                    }

                    if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                        condiciones = "where ";
                    }

                    if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f") || operacion.equalsIgnoreCase("m") || operacion.equalsIgnoreCase("c")) {
                        while (true) {
                            System.out.println("Inserte Codigo de Empleado");
                            if (!operacion.equalsIgnoreCase("m")) {
                                System.out.println("En caso de no querer pulse Enter");
                            }
                            if (operacion.equalsIgnoreCase("m")) {
                                System.out.printf("(Este dato es obligatorio)");
                            }
                            try {
                                String _1;
                                _1 = sc.nextLine();
                                if (_1.equalsIgnoreCase("") && !operacion.equalsIgnoreCase("m")) {
                                    break;
                                }
                                cempleado = Integer.parseInt(_1);

                                if (cempleado >= 0) {
                                    condiciones += "empleados.CodigoEmpleado = " + cempleado;
                                    if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                        contador++;
                                    }
                                    contadorac++;
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error en la introduccion de datos vuelva a intentar");
                            }
                        }
                        System.out.println("Inserte Nombre de Empleado(En caso de no querer pulse Enter)");
                        nombre = sc.nextLine();
                        if (!nombre.equalsIgnoreCase("")) {
                            if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                contador++;
                                if (contador > 0) {
                                    condiciones += " and ";
                                    contador = 0;
                                }
                            }
                            if (operacion.equalsIgnoreCase("m")) {
                                contadorac++;
                                if (contadorac > 0) {
                                    condiciones += " , ";
                                    contadorac = 0;
                                }
                            }
                            condiciones += "empleados.Nombre = \"" + nombre + "\"";
                        }
                        System.out.println("Inserte Apellido 1 de Empleado(En caso de no querer pulse Enter)");
                        apellido1 = sc.nextLine();
                        if (!apellido1.equalsIgnoreCase("")) {
                            if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                contador++;
                                if (contador > 0) {
                                    condiciones += " and ";
                                    contador = 0;
                                }
                            }
                            if (operacion.equalsIgnoreCase("m")) {
                                contadorac++;
                                if (contadorac > 0) {
                                    condiciones += " , ";
                                    contadorac = 0;
                                }
                            }
                            condiciones += "empleados.apellido1 = \"" + apellido1 + "\"";
                        }
                        System.out.println("Inserte Apellido 2 de Empleado (En caso de no querer pulse Enter)");
                        apellido2 = sc.nextLine();
                        if (!apellido2.equalsIgnoreCase("")) {
                            if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                contador++;
                                if (contador > 0) {
                                    condiciones += " and ";
                                    contador = 0;
                                }
                            }
                            if (operacion.equalsIgnoreCase("m")) {
                                contadorac++;
                                if (contadorac > 0) {
                                    condiciones += " , ";
                                    contadorac = 0;
                                }
                            }
                            condiciones += "empleados.apellido2 = \"" + apellido2 + "\"";
                        }

                        while (true) {

                            System.out.println("Inserte Extension de Empleado(En caso de no querer pulse Enter)");
                            try {
                                String _1;
                                _1 = sc.nextLine();
                                if (_1.equalsIgnoreCase("")) {
                                    break;
                                }
                                extension = Integer.parseInt(_1);

                                if (extension != -1 && _1.length() == 4) {
                                    if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                        contador++;
                                        if (contador > 0) {
                                            condiciones += " and ";
                                            contador = 0;
                                        }
                                    }
                                    if (operacion.equalsIgnoreCase("m")) {
                                        contadorac++;
                                        if (contadorac > 0) {
                                            condiciones += " , ";
                                            contadorac = 0;
                                        }
                                    }
                                    condiciones += "empleados.Extension = " + extension;
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error en la introduccion de datos vuelva a intentar");
                            }
                        }
                        while (true) {
                            System.out.println("Inserte Correo de Empleado(En caso de no querer pulse Enter)");
                            int corre = 0;
                            int dot = 0;
                            correo = sc.nextLine();
                            if (correo.equalsIgnoreCase("")) {
                                break;
                            }
                            String[] corr = correo.split("");
                            for (int i = 0; i < corr.length; i++) {

                                if (corr[i].equalsIgnoreCase("@")) {
                                    corre++;
                                }
                                if (corr[i].equalsIgnoreCase(".")) {
                                    dot++;
                                }
                            }
                            if (corre == 1 && dot == 1) {
                                if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                    contador++;
                                    if (contador > 0) {
                                        condiciones += " and ";
                                        contador = 0;
                                    }
                                }
                                if (operacion.equalsIgnoreCase("m")) {
                                    contadorac++;
                                    if (contadorac > 0) {
                                        condiciones += " , ";
                                        contadorac = 0;
                                    }
                                }
                                condiciones += "empleados.email = \"" + correo + "\"";
                                break;
                            } else {
                                System.out.println("El correo introducido no es valido");
                            }
                        }
                        while (true) {
                            System.out.println("Inserte Codigo de Oficina(En caso de no querer pulse Enter)");
                            System.out.println("Las oficinas disponibles son:");
                            ofis();
                            System.out.println("Inserte oficina");
                            coficina = sc.nextLine();
                            if (coficina.equalsIgnoreCase("")) {
                                break;
                            }
                            String[] corr = coficina.split("-");
                            if (corr[0].length() == 3 && corr[1].length() == 2) {
                                if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                    contador++;
                                    if (contador > 0) {
                                        condiciones += " and ";
                                        contador = 0;
                                    }
                                }
                                if (operacion.equalsIgnoreCase("m")) {
                                    contadorac++;
                                    if (contadorac > 0) {
                                        condiciones += " , ";
                                        contadorac = 0;
                                    }
                                }
                                condiciones += "empleados.CodigoOficina = \"" + coficina + "\"";
                                break;
                            }
                        }
                        while (true) {
                            System.out.println("Inserte Codigo de Jefe(En caso de no querer pulse Enter)");
                            cjefe = sc.nextLine();
                            if (cjefe.equalsIgnoreCase("")) {
                                break;
                            } else {
                                if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                    contador++;
                                    if (contador > 0) {
                                        condiciones += " and ";
                                        contador = 0;
                                    }
                                }
                                if (operacion.equalsIgnoreCase("m")) {
                                    contadorac++;
                                    if (contadorac > 0) {
                                        condiciones += " , ";
                                        contadorac = 0;
                                    }
                                }
                                condiciones += "empleados.CodigoJefe = " + cjefe;
                                break;
                            }
                        }
                        while (true) {
                            System.out.println("Inserte Puesto de empleado(En caso de no querer pulse Enter)");
                            puesto = sc.nextLine();
                            if (puesto.equalsIgnoreCase("")) {
                                break;
                            } else {
                                if (sino.equalsIgnoreCase("s") || operacion.equalsIgnoreCase("f")) {
                                    contador++;
                                    if (contador > 0) {
                                        condiciones += " and ";
                                        contador = 0;
                                    }
                                }
                                if (operacion.equalsIgnoreCase("m")) {
                                    contadorac++;
                                    if (contadorac > 0) {
                                        condiciones += " , ";
                                        contadorac = 0;
                                    }
                                }
                                condiciones += "empleados.Puesto = \"" + puesto + "\"";
                                break;
                            }
                        }
                        break;
                    }
                }
//                if (operacion.equalsIgnoreCase("c")) {
//                    crearEmpleado(campos,valores); y aqui solamente habria que hacer pasar al programa por los campos y atributos y valores de los demas para que se resolviera
//                    
//                }
//import java.time.LocalDate;
//import java.time.Period;
//import java.time.format.DateTimeFormatter;
//      static Integer mostrarEdad(LocalDate fecha) {
//        LocalDate ahora = LocalDate.now();
//        Period periodo = Period.between(fecha, ahora); 
//        return periodo.getYears();      
//    }
//    LocalDate fechanacimiento =  LocalDate.parse("1967-01-26", DateTimeFormatter.ofPattern("yyyy-MM-dd"));  
//        System.out.println("Edad: "+ mostrarEdad(fechanacimiento));
//    } Lo anterior trabaja con fechas en localdate y con un Parse.valueOF(); puedes cambiar la fecha a sqldate
//                java.sql.Date.valueOf( localDate );
                //sqlDate.toLocalDate();
                if (operacion.equalsIgnoreCase("m")) {
                    actualizarEmpleado(condiciones, cempleado);

                }
                if (tablita.equalsIgnoreCase("e")) {
                    selectEmpleado(condiciones);

                }
                if (tablita.equalsIgnoreCase("f")) {
                    selectOficina(condiciones);

                }
                if (operacion.equalsIgnoreCase("r")) {
                    joinsito(condiciones);

                }
            }

        }

    }
}

//}
//            } else {
//
//                System.out.println("Elija, a continuacion, la base de datos disponible");
//                tabla = sc.nextLine();
//                if (tabla.equals("empleado")) {
//                    estalecerConexionEmpleado();
//
//                    System.out.println("Para la operacion es necesario que añada unos parametros");
//                    System.out.println("Inserte Codigo de Empleado");
//                    cempleado = sc.nextInt();
//                    System.out.println("Inserte Nombre de Empleado");
//                    nombre = sc.nextLine();
//                    nombre = sc.nextLine();
//                    System.out.println("Inserte Apellido 1 de Empleado");
//                    apellido1 = sc.nextLine();
//                    System.out.println("Inserte Apellido 2 de Empleado");
//                    apellido2 = sc.nextLine();
//                    System.out.println("Inserte Extension de Empleado");
//                    extension = sc.nextInt();
//                    System.out.println("Inserte Correo de Empleado");
//                    correo = sc.nextLine();
//                    correo = sc.nextLine();
//                    System.out.println("Inserte Codigo de Oficina");
//                    coficina = sc.nextLine();
//                    System.out.println("Inserte Codigo de Jefe");
//                    cjefe = sc.nextLine();
//                    System.out.println("Inserte Puesto de empleado");
//                    puesto = sc.nextLine();
//                    if (operacion == 1) {
//
//                        crearEmpleado(cempleado, nombre, apellido1, apellido2, extension, correo, coficina, cjefe, puesto);
//                    }
//
//                    if (operacion == 2) {
//                        eliminarEmpleado(cempleado);
//                    }
//
//                    if (operacion == 3) {
//                        actualizarEmpleado(cempleado, nombre, apellido1, apellido2, extension, correo, coficina, cjefe, puesto);
//                    }
//                    if (operacion == 4) {
//                        selectEmpleado();
//                    }
//
//                }
//
//                if (tabla.equals("oficina")) {
//                    String codigooficina;
//                    String ciudad;
//                    String pais;
//                    String region;
//                    String codigopostal;
//                    String telefono;
//                    String lineadedireccion1;
//                    String lineadedireccion2;
//
//                    System.out.println("Para la operacion es necesario que añada unos parametros");
//                    System.out.println("Inserte Codigo de Oficina");
//                    codigooficina = sc.nextLine();
//                    System.out.println("Inserte Ciudad de Oficina");
//                    ciudad = sc.nextLine();
//                    ciudad = sc.nextLine();
//                    System.out.println("Inserte Pais de oficina");
//                    pais = sc.nextLine();
//                    System.out.println("Inserte Regio de oficina");
//                    region = sc.nextLine();
//                    System.out.println("Inserte Codigo postal");
//                    codigopostal = sc.nextLine();
//                    System.out.println("Inserte Telefono oficina");
//                    telefono = sc.nextLine();
//                    telefono = sc.nextLine();
//                    System.out.println("Inserte Linea de direccion 1");
//                    lineadedireccion1 = sc.nextLine();
//                    System.out.println("Inserte Linea de direccion2");
//                    lineadedireccion2 = sc.nextLine();
//                    if (operacion == 1) {
//
//                        crearOficina(codigooficina, ciudad, pais, region, codigopostal, telefono, lineadedireccion1, lineadedireccion2);
//                    }
//
//                    if (operacion == 2) {
//                        eliminarOficina(codigooficina);
//
//                    }
//
//                    if (operacion == 3) {
//                        actualizarOficina(codigooficina, ciudad, pais, region, codigopostal, telefono, lineadedireccion1, lineadedireccion2);
//                    }
//                    if (operacion == 4) {
//                        selectOficina();
//                    }
