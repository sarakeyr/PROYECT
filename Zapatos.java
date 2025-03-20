package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Zapatos extends Accesorio {

    private int tallaZapatos;
    private String tipoSuela;
    private ArrayList<LineaPedido> lineasPedidos;


    public Zapatos(String codigoArticulo, String nombre, float precio, String marca, String descripcion, String imagen, String color, boolean activo, String estilo, Material material, boolean esPersonalizado, int tallaZapatos, String tipoSuela, TipoAccesorio tipoAccesorio) {
        super(codigoArticulo, nombre, precio, marca, descripcion, imagen, color, activo, estilo, material, esPersonalizado, TipoAccesorio.ZAPATOS);
        setTallaZapatos(tallaZapatos);
        setTipoSuela(tipoSuela);
    }

    public int getTallaZapatos() {
        return tallaZapatos;
    }

    public void setTallaZapatos(int tallaZapatos) {
        if (tallaZapatos <= 0) {
            throw new IllegalArgumentException("La talla de los zapatos debe ser un número positivo.");
        }
        this.tallaZapatos = tallaZapatos;
    }

    public String getTipoSuela() {
        return tipoSuela;
    }

    public void setTipoSuela(String tipoSuela) {
        if (tipoSuela == null || tipoSuela.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de suela no puede ser nulo o vacío.");
        }
        this.tipoSuela = tipoSuela;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Zapatos zapatos = (Zapatos) o;
        return tallaZapatos == zapatos.tallaZapatos &&
                tipoSuela.equals(zapatos.tipoSuela);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tallaZapatos, tipoSuela);
    }

    @Override
    public String toString() {
        return "- Zapatos -\n" +
                "\tCódigo       : " + getCodigoArticulo() + "\n" +
                "\tNombre       : " + getNombre() + "\n" +
                "\tPrecio       : " + getPrecio() + " €\n" +
                "\tMarca        : " + getMarca() + "\n" +
                "\tDescripción  : " + getDescripcion() + "\n" +
                "\tImagen       : " + getImagen() + "\n" +
                "\tColor       : " + getColor() + "\n" +
                "\tActivo       : " + (isActivo() ? "Sí" : "No") + "\n" +
                "\tEstilo       : " + getEstilo() + "\n" +
                "\tPersonalizado : " + (isEsPersonalizado() ? "Sí" : "No") + "\n" +
                "\tTalla        : " + tallaZapatos + "\n" +
                "\tTipo Suela   : " + tipoSuela + "\n";
    }

    public void mostrarDetalles() {
        System.out.println(getNombre() + " tiene una talla de " + tallaZapatos + " y una suela de tipo " + tipoSuela + ".");
    }
}
