package com.iescamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Usuario {
    private String direccionEnvio;
    private float saldoCuenta;
    private boolean tarjetaFidelidad;
    private int numerosPedidosRealizados;
    private MetodoPago metodoPago;
    private ArrayList<Pedido> pedidos;

    public Cliente(String dni, String nombre, String apellidos, String direccion, String telefono, String correoElectronico, LocalDate fechaNacimiento, String pass, boolean activo, String direccionEnvio, float saldoCuenta, boolean tarjetaFidelidad, int numerosPedidosRealizados, MetodoPago metodoPago) {
        super(dni, nombre, apellidos, direccion, telefono, correoElectronico, fechaNacimiento, pass, activo);
        this.setDireccionEnvio(direccionEnvio);
        this.setSaldoCuenta(saldoCuenta);
        this.setTarjetaFidelidad(tarjetaFidelidad);
        this.setNumerosPedidosRealizados(numerosPedidosRealizados);
        this.setMetodoPago(metodoPago);
        this.pedidos = new ArrayList<>();
    }

    public String getDireccionEnvio() { return direccionEnvio; }
    public void setDireccionEnvio(String direccionEnvio) {
        if (direccionEnvio == null || direccionEnvio.isEmpty()) {
            throw new IllegalArgumentException("La dirección de envío no puede estar vacía");
        }
        this.direccionEnvio = direccionEnvio;
    }

    public float getSaldoCuenta() { return saldoCuenta; }
    public void setSaldoCuenta(float saldoCuenta) {
        if (saldoCuenta < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        this.saldoCuenta = saldoCuenta;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        if (pedidos == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        this.pedidos = pedidos;
    }

    public boolean isTarjetaFidelidad() { return tarjetaFidelidad; }
    public void setTarjetaFidelidad(boolean tarjetaFidelidad) {
        this.tarjetaFidelidad = tarjetaFidelidad;
    }

    public int getNumerosPedidosRealizados() { return numerosPedidosRealizados; }
    public void setNumerosPedidosRealizados(int numerosPedidosRealizados) {
        if (numerosPedidosRealizados < 0) {
            throw new IllegalArgumentException("El número de pedidos no puede ser negativo");
        }
        this.numerosPedidosRealizados = numerosPedidosRealizados;
    }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) {
        if (metodoPago == null) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo");
        }
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "- Cliente -\n" +
                "\tDirección de Envío : " + direccionEnvio + "\n" +
                "\tSaldo en Cuenta    : " + saldoCuenta + "\n" +
                "\tTarjeta Fidelidad  : " + (tarjetaFidelidad ? "Sí" : "No") + "\n" +
                "\tPedidos Realizados : " + numerosPedidosRealizados + "\n" +
                "\tMétodo de Pago     : " + metodoPago + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || !super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Float.compare(cliente.saldoCuenta, saldoCuenta) == 0 &&
                tarjetaFidelidad == cliente.tarjetaFidelidad &&
                numerosPedidosRealizados == cliente.numerosPedidosRealizados &&
                Objects.equals(direccionEnvio, cliente.direccionEnvio) &&
                Objects.equals(metodoPago, cliente.metodoPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), direccionEnvio, saldoCuenta, tarjetaFidelidad, numerosPedidosRealizados, metodoPago);
    }
}

