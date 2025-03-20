package com.iescamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUtil {
    private static final Scanner sc = new Scanner(System.in);

    // Métodos auxiliares para lectura de datos
    static String readString(String mensaje) {
        System.out.print(mensaje);
        String input;
        do {
            input = sc.nextLine().trim();
            if (input.isEmpty()) System.out.print("Campo requerido: ");
        } while (input.isEmpty());
        return input;
    }

    static int readInt(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(readString(mensaje));
            } catch (NumberFormatException e) {
                System.out.print("Número inválido: ");
            }
        }
    }

    private static float readFloat(String mensaje) {
        while(true) {
            try {
                return Float.parseFloat(readString(mensaje));
            } catch(NumberFormatException e) {
                System.out.println("¡Valor decimal inválido!");
            }
        }
    }

    private static BigDecimal readBigDecimal(String mensaje) {
        while (true) {
            try {
                return new BigDecimal(readString(mensaje));
            } catch (NumberFormatException e) {
                System.out.print("Valor decimal inválido: ");
            }
        }
    }

    private static LocalDate readFecha(String mensaje) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(sc.nextLine(), formatter);
            } catch(Exception e) {
                System.out.println("¡Formato fecha inválido (dd/MM/yyyy)!");
            }
        }
    }

    private static boolean readBoolean(String mensaje) {
        String input;
        do {
            input = readString(mensaje + " (s/n): ").toLowerCase();
        } while (!input.equals("s") && !input.equals("n"));
        return input.equals("s");
    }

    public static double readDouble(String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }


    // Métodos para crear objetos POJO

    public static Empleado crearEmpleado(Departamento departamento) {
        System.out.println("\n--- Nuevo com.iescamp.Empleado ---");
        String dni = readString("DNI: ");
        return new Empleado(
                dni,
                readString("Nombre: "),
                readString("Apellidos: "),
                readString("Dirección: "),
                readString("Teléfono: "),
                readString("Email: "),
                readFecha("Fecha nacimiento (dd/MM/yyyy): "),
                readString("Contraseña: "),
                readBoolean("Activo"),
                readBoolean("Privilegios"),
                departamento
        );
    }

    public static Pedido crearPedido(Cliente cliente) {
        System.out.println("\n--- Nuevo Pedido ---");
        return new Pedido(
                readInt("Número pedido: "),
                new Date(),
                EstadoPedido.EN_PROCESO,
                readString("Dirección entrega: "),
                cliente
        );
    }

    public static Bolso crearBolso(Material material) {
        System.out.println("Creando un Bolso...");
        String codigo = readString("Código del artículo: ");
        String nombre = readString("Nombre: ");
        double precio = readDouble("Precio: ");
        String marca = readString("Marca: ");
        String descripcion = readString("Descripción: ");
        String imagen = readString("Imagen: ");
        String color = readString("Color: ");
        boolean activo = readBoolean("¿Está activo? ");
        String estilo = readString("Estilo: ");
        boolean esPersonalizado = readBoolean("¿Es personalizado? ");
        String tipoCierre = readString("Tipo de cierre: ");
        int capacidad = readInt("Capacidad (litros): ");

        return new Bolso(codigo, nombre, (float) precio, marca, descripcion, imagen, color, activo, estilo, material, esPersonalizado, tipoCierre, capacidad, TipoAccesorio.BOLSO);
    }

    public static Camisa crearCamisa(Material material) {
        System.out.println("Creando una Camisa...");
        String codigo = readString("Código del artículo: ");
        String nombre = readString("Nombre: ");
        double precio = readDouble("Precio: ");
        String marca = readString("Marca: ");
        String descripcion = readString("Descripción: ");
        boolean activo = readBoolean("¿Está activo? ");
        String imagen = readString("Imagen: ");
        String color = readString("Color: ");
        int talla = readInt("Talla: ");
        String tipoCierre = readString("Tipo de cierre: ");
        String tipoManga = readString("Tipo de manga: ");
        boolean esEstampada = readBoolean("¿Es estampada? ");

        return new Camisa(codigo, nombre, (float) precio, marca, descripcion, imagen, color, activo, material, talla, tipoCierre, tipoManga, esEstampada, TipoRopa.CAMISA);
    }

    public static Cliente crearCliente(MetodoPago metodoPago) {
        System.out.println("Creando un Cliente...");
        String dni = readString("DNI: ");
        String nombre = readString("Nombre: ");
        String apellidos = readString("Apellidos: ");
        String direccion = readString("Dirección: ");
        String telefono = readString("Teléfono: ");
        String email = readString("Correo electrónico: ");
        String fechaNacimiento = readString("Fecha de nacimiento (yyyy-MM-dd): ");
        String pass = readString("Contraseña: ");
        boolean activo = readBoolean("¿Está activo? ");
        String direccionEnvio = readString("Dirección de envío: ");
        float saldoCuenta = (float) readDouble("Saldo de la cuenta: ");
        boolean tarjetaFidelidad = readBoolean("¿Tiene tarjeta de fidelidad? ");
        int numerosPedidosRealizados = readInt("Número de pedidos realizados: ");

        return new Cliente(dni, nombre, apellidos, direccion, telefono, email, LocalDate.parse(fechaNacimiento), pass, activo, direccionEnvio, saldoCuenta, tarjetaFidelidad, numerosPedidosRealizados, metodoPago);
    }

    /*
    public static Cliente crearCliente() {
        System.out.println("\n--- Nuevo Cliente ---");
        return new Cliente(
            readString("DNI: "),
            readString("Nombre: "),
            readString("Apellidos: "),
            readString("Dirección: "),
            readString("Teléfono: "),
            readString("Email: "),
            readFecha("Fecha nacimiento (dd/MM/yyyy): "),
            readString("Contraseña: "),
            readBoolean("Activo"),
            readString("Dirección envío: "),
            readBigDecimal("Saldo cuenta: ").floatValue(),
            readBoolean("Tarjeta fidelidad"),
            readInt("Número pedidos: "),
            new MetodoPago(1, "Tarjeta")
        );
    }
     */

    public static MetodoPago crearMetodoPago() {
        System.out.println("Creando un Método de Pago...");
        int id = readInt("ID: ");
        String descripcion = readString("Descripción: ");
        return new MetodoPago(id, descripcion);
    }

    public static Departamento crearDepartamento() {
        System.out.println("Creando un Departamento...");
        int id = readInt("ID: ");
        String nombre = readString("Nombre: ");
        return new Departamento(id, nombre);
    }

    public static Pantalon crearPantalon(Material material) {
        System.out.println("\n--- NUEVO PANTALÓN ---");
        return new Pantalon(
                readString("Código artículo: "),
                readString("Nombre: "),
                readFloat("Precio: "),
                readString("Marca: "),
                readString("Descripción: "),
                readString("Imagen: "),
                readString("Color: "),
                readBoolean("¿Activo? "),
                material,
                readInt("Talla: "),
                readString("Tipo cierre: "),
                TipoRopa.PANTALON,
                readBoolean("¿Tiene bolsillo? "),
                readString("Tipo Pantalón: ")
        );
    }

    public static Material crearMaterial() {
        System.out.println("Creando un Material...");
        int id = readInt("ID: ");
        String descripcion = readString("Descripción: ");
        return new Material(id, descripcion);
    }

    public static LineaPedido crearLineaPedido(Articulo articulo, Pedido pedido) {
        System.out.println("Creando Línea de Pedido...");
        int cantidad = readInt("Cantidad: ");
        return new LineaPedido(articulo, pedido, cantidad);
    }

    public static Chaqueta crearChaqueta(Material material) {
        System.out.println("\n--- NUEVA CHAQUETA ---");
        return new Chaqueta(
                readString("Código artículo: "),
                readString("Nombre: "),
                readFloat("Precio: "),
                readString("Marca: "),
                readString("Descripción: "),
                readString("Imagen: "),
                readString("Color: "),
                readBoolean("¿Activo? "),
                material,
                readInt("Talla: "),
                readString("Tipo cierre: "),
                TipoRopa.CHAQUETA,
                readBoolean("¿Impermeable? ")
        );
    }


    public static Articulo crearZapato(Material material) {
        System.out.println("\n--- NUEVO ZAPATO ---");
        return new Zapatos(
                readString("Código Artículo: "),
                readString("Nombre: "),
                readFloat("Precio: "),
                readString("Marca: "),
                readString("Descripción: "),
                readString("Imagen: "),
                readString("Color: "),
                readBoolean("¿Activo? "),
                readString("Estilo: "),
                material,
                readBoolean("¿Personalizado? "),
                readInt("Talla: "),
                readString("Tipo Suela: "),
                TipoAccesorio.ZAPATOS
        );
    }

}