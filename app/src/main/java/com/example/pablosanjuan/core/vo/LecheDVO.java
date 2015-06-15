package com.example.pablosanjuan.core.vo;

/**
 * Created by jhon on 4/06/15.
 */
public class LecheDVO {
    private String Id;
    private String ProduDiaria;
    private String PrecioL;
    private String Fecha;
    private String Hora;

    public LecheDVO() {
    }

    public LecheDVO(String hora, String id, String produDiaria, String precioL, String fecha) {
        Hora = hora;
        Id = id;
        ProduDiaria = produDiaria;
        PrecioL = precioL;
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProduDiaria() {
        return ProduDiaria;
    }

    public void setProduDiaria(String produDiaria) {
        ProduDiaria = produDiaria;
    }

    public String getPrecioL() {
        return PrecioL;
    }

    public void setPrecioL(String precioL) {
        PrecioL = precioL;
    }
}
