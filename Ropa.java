package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Ropa extends Articulo {

    private TipoRopa tipoRopa;
    private Material material;
    private ArrayList<LineaPedido> lineasPedidos;
    private String talla;
    private String tipoCierre;

    public Ropa(String codigoArticulo, String nombre, float precio, String marca, String descripcion, String imagen, String color, boolean activo,  Material material, String talla, String tipoCierre, TipoRopa tipoRopa) {
        super(codigoArticulo, nombre, precio, marca, descripcion, imagen, color, activo, material);
        setMaterial(material);
        setTipoRopa(tipoRopa);
        setTalla(talla);
        setTipoCierre(tipoCierre);
        setColor(color);
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        if (talla == null) throw new IllegalArgumentException("La talla debe ser válida.");
        this.talla = talla;
    }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) {
        if (material == null) {
            throw new IllegalArgumentException("El material no puede ser nulo.");
        }
        this.material = material;
    }

    public TipoRopa getTipoRopa() { return tipoRopa; }
    public void setTipoRopa(TipoRopa tipoRopa) {
        if (tipoRopa == null) {
            throw new IllegalArgumentException("El tipo de ropa no puede ser nulo.");
        }
        this.tipoRopa = tipoRopa;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        if (tipoCierre == null || tipoCierre.trim().isEmpty()) throw new IllegalArgumentException("El tipo de cierre no puede estar vacío.");
        this.tipoCierre = tipoCierre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ropa ropa = (Ropa) o;
        return talla.equals(ropa.talla) && Objects.equals(tipoCierre, ropa.tipoCierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), talla, tipoCierre, tipoRopa);
    }

    @Override
    public String toString() {
        return "Ropa:\n" +
                "- Tipo : " + tipoRopa + "\n" +
                "- Talla: " + talla + "\n" +
                "- Color: " + getColor() + "\n" +
                "- Tipo de cierre: " + tipoCierre;
    }
}