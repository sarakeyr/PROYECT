package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Bolso extends Accesorio {

    private String tipoCierre;
    private int capacidad;
    private ArrayList<LineaPedido> lineasPedidos;

    public Bolso(String codigoArticulo, String nombre, float precio, String marca, String descripcion, String imagen, String color, boolean activo, String estilo, Material material, boolean esPersonalizado, String tipoCierre, int capacidad, TipoAccesorio tipoAccesorio) {
        super(codigoArticulo, nombre, precio, marca, descripcion, imagen, color, activo, estilo, material, esPersonalizado, TipoAccesorio.BOLSO);
        setTipoCierre(tipoCierre); // Validación en el setter
        setCapacidad(capacidad); // Validación en el setter
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        if (tipoCierre == null || tipoCierre.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de cierre no puede ser nulo o vacío.");
        }
        this.tipoCierre = tipoCierre;
    }

    public ArrayList<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineaPedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser un número positivo.");
        }
        this.capacidad = capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bolso bolso = (Bolso) o;
        return capacidad == bolso.capacidad &&
                tipoCierre.equals(bolso.tipoCierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCierre, capacidad);
    }

    @Override
    public String toString() {
        return "- Bolso -\n" +
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
                "\tTipo Cierre  : " + tipoCierre + "\n" +
                "\tCapacidad    : " + capacidad + " litros\n";
    }

    public void mostrarDetalles() {
        System.out.println(getNombre() + " tiene un cierre tipo " + tipoCierre + " y una capacidad de " + capacidad + " litros.");
    }
}