package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Material {
    private int id;
    private String descripcion;
    private ArrayList<Articulo> articulos;

    public Material(int id, String descripcion) {
        this.setId(id);
        this.setDescripcion(descripcion);
        this.articulos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo.");
        }
        this.id = id;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "- Material -\n" +
                "\tID          : " + id + "\n" +
                "\tDescripción : " + descripcion + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return id == material.id && Objects.equals(descripcion, material.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }
}

