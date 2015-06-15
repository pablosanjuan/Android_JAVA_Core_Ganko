package com.example.pablosanjuan.core.vo;

/**
 * Created by jhon on 10/06/15.
 */
public class LecheVO {
    private String Id;
    private String Lote;
    private String Parto;
    private String Total;

    public LecheVO() {
    }

    public LecheVO(String id, String total, String lote, String parto) {
        Id = id;
        Total = total;
        Lote = lote;
        Parto = parto;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    public String getParto() {
        return Parto;
    }

    public void setParto(String parto) {
        Parto = parto;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}
