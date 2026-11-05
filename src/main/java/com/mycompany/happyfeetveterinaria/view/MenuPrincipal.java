package com.mycompany.happyfeetveterinaria.view;

import java.util.Scanner;

import com.mycompany.happyfeetveterinaria.model.entities.Dueno;
import com.mycompany.happyfeetveterinaria.service.DuenoService;

import com.mycompany.happyfeetveterinaria.model.entities.Mascota;
import com.mycompany.happyfeetveterinaria.service.MascotaService;

public class MenuPrincipal {

    private final Scanner scanner;
    private final DuenoService duenoService;

    public MenuPrincipal() {

        scanner = new Scanner(System.in);
        duenoService = new DuenoService();
    }

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("\n===== HAPPY FEET =====");
            System.out.println("1. Gestionar Dueños");
            System.out.println("2. Gestionar Mascotas");
            System.out.println("3. Gestionar Veterinarios");
            System.out.println("4. Gestionar Citas");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 ->
                    menuDuenos();

                case 2 ->
                    menuMascotas();

                case 3 ->
                    System.out.println("Módulo Veterinarios");

                case 4 ->
                    System.out.println("Módulo Citas");

                case 0 ->
                    System.out.println("Hasta luego");

                default ->
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void menuDuenos() {

        int opcion;

        do {

            System.out.println("\n===== GESTIÓN DE DUEÑOS =====");

            System.out.println("1. Registrar Dueño");
            System.out.println("2. Listar Dueños");
            System.out.println("3. Buscar Dueño");
            System.out.println("0. Regresar");

            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 ->
                    registrarDueno();

                case 2 ->
                    listarDuenos();

                case 3 ->
                    buscarDueno();

                case 0 ->
                    System.out.println("Regresando...");

                default ->
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void registrarDueno() {

        Dueno dueno = new Dueno();

        System.out.print("Nombre: ");
        dueno.setNombreCompleto(scanner.nextLine());

        System.out.print("Documento: ");
        dueno.setDocumentoIdentidad(scanner.nextLine());

        System.out.print("Dirección: ");
        dueno.setDireccion(scanner.nextLine());

        System.out.print("Teléfono: ");
        dueno.setTelefono(scanner.nextLine());

        System.out.print("Email: ");
        dueno.setEmail(scanner.nextLine());

        System.out.print("Contacto de emergencia: ");
        dueno.setContactoEmergencia(scanner.nextLine());

        boolean guardado = duenoService.guardar(dueno);

        if (guardado) {

            System.out.println("✅ Dueño registrado correctamente");

        } else {

            System.out.println("❌ No se pudo registrar el dueño");
        }
    }
    
    private void listarDuenos() {

    System.out.println("\n===== LISTA DE DUEÑOS =====");

    var duenos = duenoService.listarTodos();

    if (duenos.isEmpty()) {

        System.out.println("No hay dueños registrados.");
        return;
    }

    for (Dueno dueno : duenos) {

        System.out.println("---------------------");
        System.out.println("ID: " + dueno.getId());
        System.out.println("Nombre: " + dueno.getNombreCompleto());
        System.out.println("Documento: " + dueno.getDocumentoIdentidad());
        System.out.println("Teléfono: " + dueno.getTelefono());
        System.out.println("Email: " + dueno.getEmail());
    }
}
    
    private void buscarDueno() {

    System.out.print("Ingrese el ID del dueño: ");

    int id = scanner.nextInt();
    scanner.nextLine();

    Dueno dueno = duenoService.buscarPorId(id);

    if (dueno != null) {

        System.out.println("\n===== DUEÑO ENCONTRADO =====");

        System.out.println("ID: " + dueno.getId());
        System.out.println("Nombre: " + dueno.getNombreCompleto());
        System.out.println("Documento: " + dueno.getDocumentoIdentidad());
        System.out.println("Dirección: " + dueno.getDireccion());
        System.out.println("Teléfono: " + dueno.getTelefono());
        System.out.println("Email: " + dueno.getEmail());
        System.out.println("Contacto Emergencia: "
                + dueno.getContactoEmergencia());

    } else {

        System.out.println("❌ No se encontró un dueño con ese ID.");
    }
}
    
    private void menuMascotas() {

    int opcion;

    do {

        System.out.println("\n===== GESTIÓN DE MASCOTAS =====");

        System.out.println("1. Registrar Mascota");
        System.out.println("2. Listar Mascotas");
        System.out.println("3. Buscar Mascota");
        System.out.println("0. Regresar");

        System.out.print("Seleccione una opción: ");

        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {

            case 1 ->
                System.out.println("Registrar Mascota");

            case 2 ->
                System.out.println("Listar Mascotas");

            case 3 ->
                System.out.println("Buscar Mascota");

            case 0 ->
                System.out.println("Regresando...");

            default ->
                System.out.println("Opción inválida");
        }

    } while (opcion != 0);
}
}