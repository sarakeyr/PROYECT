package com.iescamp;

import java.util.Date;
import java.util.ArrayList;


public class Pedido {
    private int numeroPedido;
    private Date fechaPedido;
    private EstadoPedido estado;
    private String direccEntrega;
    private ArrayList<LineaPedido> lineasPedido;
    private Cliente cliente;
    private MetodoPago metodoPago;

    public Pedido(int numeroPedido, Date fechaPedido, EstadoPedido estado, String direccEntrega, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        setEstado(estado);  // Usa el setter con validación
        this.direccEntrega = direccEntrega;
        this.cliente = cliente;
        this.lineasPedido = new ArrayList<>();
    }

    // Métodos getter y setter
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    // Setter con validación para el estado
    public void setEstado(EstadoPedido estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
        this.estado = estado;  // Asignar el estado solo si no es nulo
    }

    public String getDireccEntrega() {
        return direccEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void agregarLineaPedido(LineaPedido linea) {
        this.lineasPedido.add(linea);
    }

    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    // Método para mostrar detalles del pedido
    public void mostrarPedido() {
        System.out.println("Número de pedido: " + getNumeroPedido());
        System.out.println("Fecha de pedido: " + getFechaPedido());
        System.out.println("Estado: " + getEstado().getDescripcion());  // Mostrar la descripción del estado
        System.out.println("Dirección de entrega: " + getDireccEntrega());
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellidos());

        // Mostrar las líneas de pedido asociadas
        System.out.println("Detalles de las líneas de pedido:");
        for (LineaPedido linea : lineasPedido) {
            linea.mostrarDetalles();
        }
    }
}
