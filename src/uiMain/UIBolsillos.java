package uiMain;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.transacciones.Prestamo;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaAhorro;

import java.util.ArrayList;

public class UIBolsillos extends UIMenu{

    public static void bolsillo(Cliente cliente){
        System.out.println("Selecciona una de las opciones disponibles para bolsillos");
        System.out.println(
                """
                        1. Generar Bolsillo
                        2. Cargar Bolsillo
                        3. Descargar Bolsillo""");
        int opcionBolsillos=sc.nextInt();
        if( opcionBolsillos < 1 || opcionBolsillos >3){
            System.out.println("Opción no valida");
            return;
        }

        traercuentas();
        System.out.println("Selecciona la cuenta para generar el ahorro");
        int cuenta = sc.nextInt();
        if(cuenta < Cliente.listaCuentas.size()) {
            switch (opcionBolsillos) {
                case (1) -> {
                    System.out.println("Cuánto deseas ahorrar en este bolsillo");
                    int valorAhorro = sc.nextInt();
                    System.out.println("Ingresa el número correspondiente al tipo de bolsillo que quieres generar");
                    System.out.println(
                            """
                                    0. VIAJES          1. EDUCACION     2. SALUD
                                    3  ALIMENTACION    4  TRANSPORTE    5  HOGAR
                                    6  IMPREVISTOS     7  OTROS """);
                    int categoria = sc.nextInt();
                    if(categoria < Bolsillo.Categoria.values().length) {
                        cliente.generarAhorro(valorAhorro, categoria, cuenta);
                        ArrayList<Bolsillo> bolsillos = (cliente.listaCuentas.get(cuenta).misBolsillos);
                        System.out.println((bolsillos.get(bolsillos.size() - 1)).mensajeBolsillo());
                    }

                }
                case (2) -> {
                    System.out.println("Selecciona el bolsillo al cual deseas ingresar un monto");
                    traerBolsillos(cuenta);
                    int op1 = sc.nextInt();
                    if(op1 > Cliente.buscarCuenta(op1).misBolsillos.size() || Cliente.buscarCuenta(op1).misBolsillos.size()==0){
                        System.out.println("El bolsillo no existe");
                        return;
                    }
                    System.out.println("1. Carga completa");
                    System.out.println("2. Carga parcial");
                    int opcion1 = sc.nextInt();
                    if( op1 < 1 || op1 >2){
                        System.out.println("Opción no valida");
                        return;
                    }
                    if(op1 < cliente.getCuenta().misBolsillos.size() || !cliente.getCuenta().misBolsillos.isEmpty()) {
                        switch (opcion1) {
                            case (1) -> {
                                System.out.println(cliente.cargarAhorro(cuenta, op1));
                            }
                            case (2) -> {
                                System.out.println(" Valor a cargar de tu bolsillo");
                                int valorCarga = sc.nextInt();
                                System.out.println(cliente.cargarAhorro(valorCarga, cuenta, op1));
                            }
                            default -> {
                                System.out.println("Opción no valida");
                            }
                        }
                    }

                }

                case (3) -> {
                    System.out.println("selecciona tu bolsillo");
                    traerBolsillos(cuenta);
                    int op1 = sc.nextInt();
                    if(op1 > Cliente.buscarCuenta(op1).misBolsillos.size() || Cliente.buscarCuenta(op1).misBolsillos.size()==0){
                        System.out.println("El bolsillo no existe");
                        return;
                    }
                    System.out.println("1. Descarga completa");
                    System.out.println("2. Descarga parcial");
                    int op2 = sc.nextInt();
                    if( op2 < 1 || op2 >2){
                        System.out.println("Opción no valida");
                        return;
                    }

                    switch (op2) {
                        case (1) -> {
                            System.out.println(cliente.descargarAhorro(cuenta, op1));
                        }
                        case (2) -> {
                            System.out.println("Valor a descargar de tu bolsillo");
                            int valorDescarga = sc.nextInt();
                            System.out.println(cliente.descargarAhorro(valorDescarga, cuenta, op1));
                        }
                        default -> {
                            System.out.println("Opción no valida");
                        }
                    }
                }
            }
        }
    }

}
