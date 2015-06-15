package com.example.pablosanjuan.core.vo;

/**
 * Created by jhon on 9/06/15.
 */
public class CebaVO {
    private String Id;
    private String Fecha;
    private String Edad;
    private String Peso;

    public CebaVO() {
    }

    public CebaVO(String id, String fecha, String edad, String peso) {
        Id = id;
        Fecha = fecha;
        Edad = edad;
        Peso = peso;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }
}
