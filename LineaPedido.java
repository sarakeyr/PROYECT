package com.iescamp;

import java.util.Objects;

public class LineaPedido {
    private Articulo articulo;
    private Pedido pedido;

    public LineaPedido(Articulo articulo, Pedido pedido) {
        setArticulo(articulo);
        setPedido(pedido);
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        if (articulo == null) {
            throw new IllegalArgumentException("El artículo no puede ser nulo.");
        }
        this.articulo = articulo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        this.pedido = pedido;
    }

    // Método para mostrar los detalles de la línea de pedido
    public void mostrarDetalles() {
        System.out.println("Artículo: " + articulo.getNombre() + " - ID Pedido: " + getPedido().getNumeroPedido());
    }

    // Método para mostrar los detalles en un formato similar a los otros objetos
    @Override
    public String toString() {
        return "- Línea de Pedido -\n" +
                "\tArtículo    : " + articulo.getNombre() + "\n" +
                "\tID Pedido   : " + getPedido().getNumeroPedido() + "\n";
    }

    // Métodos equals y hashCode para comparar objetos LineaPedido
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaPedido that = (LineaPedido) o;
        return Objects.equals(articulo, that.articulo) &&
                Objects.equals(pedido, that.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articulo, pedido);
    }
}

