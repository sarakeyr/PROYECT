package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Camisa extends Ropa {

    private String tipoManga;
    private boolean esEstampada;
    private ArrayList<LineaPedido> lineasPedidos;

    public Camisa(String codigoArticulo, String nombre, float precio, String marca, String descripcion, String imagen, String color, boolean activo, Material material, int talla, String tipoCierre, String tipoManga, boolean esEstampada, TipoRopa tipoRopa) {
        super(codigoArticulo, nombre, precio, marca, descripcion, imagen, color, activo, material, talla, tipoCierre, tipoRopa);
        setTipoManga(tipoManga);
        setEsEstampada(esEstampada);
    }

    public String getTipoManga() {
        return tipoManga;
    }

    public void setTipoManga(String tipoManga) {
        if (tipoManga == null || tipoManga.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de manga no puede ser nulo o vacío");
        }
        this.tipoManga = tipoManga;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public boolean isEsEstampada() {
        return esEstampada;
    }

    public void setEsEstampada(boolean esEstampada) {
        this.esEstampada = esEstampada;
    }

    @Override
    public String toString() {
        return "- Camisa -\n" +
                "\tCódigo       : " + getCodigoArticulo() + "\n" +
                "\tNombre       : " + getNombre() + "\n" +
                "\tPrecio       : " + getPrecio() + " €\n" +
                "\tMarca        : " + getMarca() + "\n" +
                "\tDescripción  : " + getDescripcion() + "\n" +
                "\tImagen       : " + getImagen() + "\n" +
                "\tColor       : " + getColor() + "\n" +
                "\tActivo       : " + (isActivo() ? "Sí" : "No") + "\n" +
                "\tMaterial        : " + getMaterial() + "\n" +
                "\tTalla        : " + getTalla() + "\n" +
                "\tTipo Cierre  : " + getTipoCierre() + "\n" +
                "\tColor        : " + getColor() + "\n" +
                "\tTipo Manga   : " + tipoManga + "\n" +
                "\tEstampado    : " + (esEstampada ? "Sí" : "No") + "\n";
    }

    public void mostrarDetalles() {
        String mensaje = getNombre() + " tiene un tipo de manga " + tipoManga + ". ";
        mensaje += esEstampada ? "¡Es estampada!" : "No es estampada.";
        System.out.println(mensaje);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camisa camisa = (Camisa) o;
        return esEstampada == camisa.esEstampada &&
                tipoManga.equals(camisa.tipoManga) &&
                Objects.equals(getCodigoArticulo(), camisa.getCodigoArticulo()) &&
                Objects.equals(getNombre(), camisa.getNombre()) &&
                Objects.equals(getMarca(), camisa.getMarca()) &&
                Objects.equals(getDescripcion(), camisa.getDescripcion()) &&
                Objects.equals(getImagen(), camisa.getImagen()) &&
                Objects.equals(getColor(), camisa.getColor()) &&
                getTalla() == camisa.getTalla() &&
                getTipoCierre().equals(camisa.getTipoCierre()) &&
                getColor().equals(camisa.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoArticulo(), getNombre(), getPrecio(), getMarca(), getDescripcion(), getImagen(), isActivo(), getTalla(), getTipoCierre(), getColor(), tipoManga, esEstampada);
    }
}

