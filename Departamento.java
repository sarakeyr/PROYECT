package com.iescamp;

import java.util.ArrayList;
import java.util.Objects;

public class Departamento {
    private int id;
    private String nombre;
    private ArrayList<com.iescamp.Empleado> empleados;

    public Departamento(int id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public ArrayList<com.iescamp.Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<com.iescamp.Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return id == that.id && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Departamento: " + id + "\n" + "Nombre: " + nombre;
    }
}