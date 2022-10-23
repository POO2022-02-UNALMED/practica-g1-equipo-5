package uiMain;

import java.util.Scanner;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaAhorro;

public class UIMenu {
    public static void main(String [] args){

        Cliente cliente= new Cliente("Jaimico",20192121);
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("Bienvenido a BancoUnal\n Elija una opción:");
            System.out.println(
                    """
                            1. Solicitar Prestamo
                            2. Realizar Pagos
                            3. Bolsillos
                            4. Transferencias
                            5. Movimientos
                            6. Salir""");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Puedes solicitar un prestamo entre 500.000 y 7'000.000 a 24 cuotas\n Ingresa el valor a solicitar");
                    int valor=sc.nextInt();
                    System.out.println("Elige el tipo de prestamo (universitario,hobbie,libre)");
                    String tipoPrestamo =sc.next();
                    ((CuentaAhorro)cliente.cuenta).solicitarPrestamo(valor,tipoPrestamo);
                    System.out.println(((CuentaAhorro) cliente.cuenta).getPrestamo().toString());
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("selecciona una de las opciones disponibles");
                    int opcionBolsillos=sc.nextInt();
                    switch (opcionBolsillos) {
                        case (1) -> {

                            System.out.println("menciona el valor de tu ahorro");
                            int valorAhorro = sc.nextInt();
                            System.out.println("menciona tu categoria");
                            int categoria = sc.nextInt();
                            cliente.generarAhorro(valorAhorro, categoria);


                        }
                        case (2) -> {

                            System.out.println("1. Carga completa");
                            System.out.println("2. Carga parcial");
                            int opcion1=sc.nextInt();
                            switch (opcion1) {
                                case (1) -> {
                                    System.out.println("selecciona tu bolsillo");
                                    for (Bolsillo i:cliente.getCuenta().getMisBolsillos()) {
                                        System.out.println(i.toString());
                                    }
                                    int op1 = sc.nextInt();
                                    cliente.cargarAhorro(op1);
                                }
                                case (2) -> {
                                    System.out.println("a cargar de tu bolsillo");
                                    int valorCarga = sc.nextInt();
                                    System.out.println("selecciona tu bolsillo");
                                    for (Bolsillo i:cliente.getCuenta().getMisBolsillos()) {
                                        System.out.println(i.toString());
                                    }
                                    int bolsilloNum = sc.nextInt();
                                    cliente.cargarAhorro(valorCarga, bolsilloNum);
                                }
                                default -> {}
                            }


                        }

                        case (3) -> {
                            System.out.println("descargar de tu bolsillo");
                            int valordescarga = sc.nextInt();
                            System.out.println("selecciona tu bolsillo");
                            for (Bolsillo i:cliente.getCuenta().getMisBolsillos()) {
                                System.out.println(i.toString());
                            }
                            int bolsilloNum = sc.nextInt();
                            cliente.descargarAhorro(valordescarga, bolsilloNum);
                        }
                    }
                    break;
                case 4:

                    break;
                case 5:
                    break;
                default:
                    System.out.println("Por favor ingrese una opción valida");
            }

        }while(opcion != 6);

    }






}
