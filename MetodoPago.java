package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class MetodoPago {
    private int id;
    private String descripcion;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;

    public MetodoPago(int id, String descripcion) {
        setId(id);
        setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("El ID debe ser un número positivo.");
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) throw new IllegalArgumentException("La descripción no puede estar vacía.");
        this.descripcion = descripcion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetodoPago that = (MetodoPago) o;
        return id == that.id && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    @Override
    public String toString() {
        return "Metodo de Pago:\n" +
                "- ID: " + id + "\n" +
                "- Descripción: " + descripcion;
    }
}