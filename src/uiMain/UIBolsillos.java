package uiMain;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.usuario.Cliente;

public class UIBolsillos extends UIMenu{

    public static void bolsillo(Cliente cliente){
        System.out.println("Selecciona una de las opciones disponibles para bolsillos");
        System.out.println(
                """
                        1. Generar Bolsillo
                        2. Cargar Bolsillo
                        3. Descargar Bolsillo""");
        int opcionBolsillos=sc.nextInt();

        traercuentas();
        System.out.println("Selecciona la cuenta para generar el ahorro");
        int cuenta = sc.nextInt();
        switch (opcionBolsillos) {
            case (1) -> {
                System.out.println("Cuánto deseas ahorrar en este bolsillo");
                int valorAhorro = sc.nextInt();
                System.out.println("Ingresa el número correspondiente al tipo de bolsillo que quieres generar");
                System.out.println(
                        """
                                0. VIAJES          1. EDUCACION     2. SALUD
                                3  ALIMENTACION    4  TRANSPORTE    5  HOGAR
                                6  IMPREVISTOS     7  OTROS
                                """);
                int categoria = sc.nextInt();
                cliente.generarAhorro(valorAhorro, categoria,cuenta);
            }
            case (2) -> {
                System.out.println("Selecciona el bolsillo al cual deseas ingresar un monto");
                traerBolsillos(cuenta);
                int op1 = sc.nextInt();
                System.out.println("1. Carga completa");
                System.out.println("2. Carga parcial");
                int opcion1=sc.nextInt();
                switch (opcion1) {
                    case (1) -> {
                        System.out.println(cliente.cargarAhorro(cuenta,op1));
                    }
                    case (2) -> {
                        System.out.println("a cargar de tu bolsillo");
                        int valorCarga = sc.nextInt();
                        System.out.println(cliente.cargarAhorro(valorCarga,cuenta,op1));
                    }
                    default -> {}
                }

            }

            case (3) -> {
                System.out.println("selecciona tu bolsillo");
                traerBolsillos(cuenta);
                int op1 = sc.nextInt();
                System.out.println("1. Descarga completa");
                System.out.println("2. Descarga parcial");
                int op2 = sc.nextInt();
                switch (op2) {
                    case (1) -> {
                        cliente.descargarAhorro(op1,cuenta);
                    }
                    case (2) -> {
                        System.out.println("Valor a descargar de tu bolsillo");
                        int valorDescarga = sc.nextInt();
                        cliente.cargarAhorro(valorDescarga,cuenta,op1);
                    }
                    default -> {}
                }

            }
        }
    }

}
