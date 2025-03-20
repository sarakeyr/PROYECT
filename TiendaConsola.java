package com.iescamp;

import java.util.Scanner;

public class TiendaConsola {
    private Plantilla plantilla = new Plantilla();
    private Clientela clientela = new Clientela();
    private Catalogo catalogo = new Catalogo();
    private Ventas ventas = new Ventas();

    private final Departamento departamentoDefault = new Departamento(1, "Ventas");
    private final MetodoPago metodoPagoDefault = new MetodoPago(1, "Tarjeta Crédito");
    private final Material materialDefault = new Material(1, "Algodón");

    public static void main(String[] args) {
        TiendaConsola tienda = new TiendaConsola();
        tienda.iniciar();
    }

    private void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== TIENDA CONSOLA ===");
            System.out.println("1. Gestión de empleados");
            System.out.println("2. Gestión de clientes");
            System.out.println("3. Gestión de catálogo");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");

            opcion = leerEntero(sc);

            switch(opcion) {
                case 1: gestionEmpleados(); break;
                case 2: gestionClientes(); break;
                case 3: gestionCatalogo(); break;
                case 4: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida");
            }
        } while(opcion != 4);
    }

    private void gestionEmpleados() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar por DNI");
            System.out.println("4. Volver");
            System.out.print("Selección: ");

            opcion = leerEntero(sc);

            switch(opcion) {
                case 1:
                    Empleado nuevo = ConsoleUtil.crearEmpleado(departamentoDefault);
                    plantilla.crear(nuevo);
                    System.out.println("com.iescamp.Empleado creado exitosamente!");
                    break;

                case 2:
                    System.out.println("\n--- LISTADO DE EMPLEADOS ---");
                    for(Empleado e : plantilla.getEmpleados()) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    String dni = ConsoleUtil.readString("Introduzca DNI a buscar: ");
                    Empleado encontrado = plantilla.buscarPorDNI(dni);
                    System.out.println(encontrado != null ? encontrado : "No se encontró el empleado");
                    break;
            }
        } while(opcion != 4);
    }

    private void gestionClientes() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar por DNI");
            System.out.println("4. Volver");
            System.out.print("Selección: ");

            opcion = leerEntero(sc);

            switch(opcion) {
                case 1:
                    Cliente nuevo = ConsoleUtil.crearCliente(ConsoleUtil.crearMetodoPago());
                    clientela.crear(nuevo);
                    System.out.println("Cliente creado exitosamente!");
                    break;

                case 2:
                    System.out.println("\n--- LISTADO DE CLIENTES ---");
                    for(Cliente c : clientela.getClientes()) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    String dni = ConsoleUtil.readString("Introduzca DNI a buscar: ");
                    Cliente encontrado = clientela.buscarPorDNI(dni);
                    System.out.println(encontrado != null ? encontrado : "No se encontró el cliente");
                    break;
            }
        } while(opcion != 4);
    }

    private void gestionCatalogo() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE CATÁLOGO ===");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Buscar por código");
            System.out.println("4. Volver");
            System.out.print("Selección: ");

            opcion = leerEntero(sc);

            switch(opcion) {
                case 1:
                    añadirArticulo();
                    break;

                case 2:
                    System.out.println("\n--- LISTADO DE ARTÍCULOS ---");
                    for(Articulo a : catalogo.getArticulos()) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    int codigo = ConsoleUtil.readInt("Introduzca código a buscar: ");
                    Articulo encontrado = catalogo.buscarPorCodigo(codigo);
                    System.out.println(encontrado != null ? encontrado : "No se encontró el artículo");
                    break;
            }
        } while(opcion != 4);
    }

    private void añadirArticulo() {
        System.out.println("\nSeleccione tipo de artículo:");
        System.out.println("1. Camisa");
        System.out.println("2. Chaqueta");
        System.out.println("3. Pantalón");
        System.out.println("4. Zapato");
        System.out.println("5. Bolso");

        int tipo = ConsoleUtil.readInt("Opción: ");
        Articulo nuevo = null;

        switch(tipo) {
            case 1:
                nuevo = ConsoleUtil.crearCamisa(materialDefault);
                break;
            case 2:
                nuevo = ConsoleUtil.crearChaqueta(materialDefault);
                break;
            case 3:
                nuevo = ConsoleUtil.crearPantalon(materialDefault);
                break;
            case 4:
                nuevo = ConsoleUtil.crearZapato(materialDefault);
                break;
            case 5:
                nuevo = ConsoleUtil.crearBolso(materialDefault);
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        if(nuevo != null) {
            catalogo.crear(nuevo);
            System.out.println("Artículo añadido exitosamente!");
        }
    }

    private int leerEntero(Scanner sc) {
        while(true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.print("Entrada inválida. Introduzca un número: ");
            }
        }
    }
}