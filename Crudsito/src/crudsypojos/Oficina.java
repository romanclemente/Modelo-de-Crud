package clementejurado_román_crudsypojos;

import java.util.ArrayList;

public class Oficina {

    private String codigooficina;
    private String ciudad;
    private String pais;
    private String region;//admite nulos
    private String codigopostal;
    private String telefono;
    private String lineadedireccion1;
    private String lineadedireccion2;//admite nulos

    public Oficina() {
    }

    public Oficina(String codigooficina, String ciudad, String pais, String region, String codigopostal, String telefono, String lineadedireccion1, String lineadedireccion2) {
        this.codigooficina = codigooficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigopostal = codigopostal;
        this.telefono = telefono;
        this.lineadedireccion1 = lineadedireccion1;
        this.lineadedireccion2 = lineadedireccion2;
    }

    public String getCodigooficina() {
        return codigooficina;
    }

    public void setCodigooficina(String codigooficina) {
        this.codigooficina = codigooficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLineadedireccion1() {
        return lineadedireccion1;
    }

    public void setLineadedireccion1(String lineadedireccion1) {
        this.lineadedireccion1 = lineadedireccion1;
    }

    public String getLineadedireccion2() {
        return lineadedireccion2;
    }

    public void setLineadedireccion2(String lineadedireccion2) {
        this.lineadedireccion2 = lineadedireccion2;
    }

    @Override
    public String toString() {
        return "|\t" + this.codigooficina + "   |" + this.ciudad + "   |" + this.pais + "   |" + this.region + "   |" + this.codigopostal + "   |" + this.lineadedireccion1 + "   |" + this.lineadedireccion2 + "   |";

    }

}
