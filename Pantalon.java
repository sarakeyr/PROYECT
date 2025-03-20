package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Pantalon extends Ropa {

    private boolean tieneBolsillo;
    private String tipoPantalon;
    private ArrayList<LineaPedido> lineasPedidos;


    public Pantalon(String codigoArticulo, String nombre, float precio, String marca, String descripcion, String imagen, String color, boolean activo, Material material, int talla, String tipoCierre, TipoRopa tipoRopa, boolean tieneBolsillo, String tipoPantalon) {
        super(codigoArticulo, nombre, precio, marca, descripcion, imagen, color, activo, material, talla, tipoCierre, tipoRopa);
        setTipoPantalon(tipoPantalon);
        setTieneBolsillo(tieneBolsillo);
    }

    public boolean isTieneBolsillo() {
        return tieneBolsillo;
    }

    public void setTieneBolsillo(boolean tieneBolsillo) {
        this.tieneBolsillo = tieneBolsillo;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        if (tipoPantalon == null || tipoPantalon.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de pantalón no puede ser nulo o vacío");
        }
        this.tipoPantalon = tipoPantalon;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    @Override
    public String toString() {
        return "- Pantalón -\n" +
                "\tCódigo       : " + getCodigoArticulo() + "\n" +
                "\tNombre       : " + getNombre() + "\n" +
                "\tPrecio       : " + getPrecio() + " €\n" +
                "\tMarca        : " + getMarca() + "\n" +
                "\tDescripción  : " + getDescripcion() + "\n" +
                "\tImagen       : " + getImagen() + "\n" +
                "\tColor        : " + getColor() + "\n" +
                "\tActivo       : " + (isActivo() ? "Sí" : "No") + "\n" +
                "\tTalla        : " + getTalla() + "\n" +
                "\tTipo Cierre  : " + getTipoCierre() + "\n" +
                "\tColor        : " + getColor() + "\n" +
                "\tTipo Pantalón: " + tipoPantalon + "\n" +
                "\tBolsillos    : " + (tieneBolsillo ? "Sí" : "No") + "\n";
    }

    public void mostrarDetalles() {
        String mensaje = "Pantalón: " + getNombre() + ", Tipo: " + tipoPantalon + ". ";
        mensaje += tieneBolsillo ? "¡Tiene bolsillos!" : "No tiene bolsillos.";
        System.out.println(mensaje);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pantalon pantalon = (Pantalon) o;
        return tieneBolsillo == pantalon.tieneBolsillo &&
                tipoPantalon.equals(pantalon.tipoPantalon) &&
                Objects.equals(getCodigoArticulo(), pantalon.getCodigoArticulo()) &&
                Objects.equals(getNombre(), pantalon.getNombre()) &&
                Objects.equals(getMarca(), pantalon.getMarca()) &&
                Objects.equals(getDescripcion(), pantalon.getDescripcion()) &&
                Objects.equals(getImagen(), pantalon.getImagen()) &&
                Objects.equals(getColor(), pantalon.getColor()) &&
                getTalla() == pantalon.getTalla() &&
                getTipoCierre().equals(pantalon.getTipoCierre()) &&
                getColor().equals(pantalon.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoArticulo(), getNombre(), getPrecio(), getMarca(), getDescripcion(), getImagen(), getColor(), isActivo(), getTalla(), getTipoCierre(), getColor(), tipoPantalon, tieneBolsillo);
    }
}
