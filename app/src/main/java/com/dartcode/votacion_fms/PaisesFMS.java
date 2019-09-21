package com.dartcode.votacion_fms;

public class PaisesFMS {

    private String pais, descripcion;
    private int foto;

    public PaisesFMS() {
    }

    public PaisesFMS(String pais, String descripcion, int foto) {
        this.pais = pais;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
