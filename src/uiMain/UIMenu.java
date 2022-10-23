package uiMain;

import java.util.Scanner;
import baseDatos.Serializador;
import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;

public class UIMenu {
    public static Cliente cliente= new Cliente("Jaimico",20192121,0);
    public static void main(String [] args){


        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("Bienvenido a PiggyBank\n Elija una opción:");
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
                    System.out.println("Ingresa el ID de la cuenta que deseas aplicar el prestamo");
                    traercuentas();
                    opcion = sc.nextInt();
                    System.out.println("Puedes solicitar un prestamo entre 500.000 y 7'000.000 a 24 cuotas\n Ingresa el valor a solicitar");
                    int valor=sc.nextInt();
                    System.out.println("Elige el tipo de prestamo (universitario,hobbie,libre)");
                    String tipoPrestamo =sc.next();
                    cliente.solicitarPrestamo(valor,tipoPrestamo,opcion);
                    System.out.println(((CuentaAhorro)cliente.listaCuentas.get(opcion)).getPrestamo());
                    break;
                case 2:

                    break;
                case 3:
                    traercuentas();
                    System.out.println("selecciona una de las opciones disponibles");
                    int opcionBolsillos=sc.nextInt();
                    opcion = sc.nextInt();
                    switch (opcionBolsillos) {
                        case (1) -> {
                            System.out.println("menciona el valor de tu ahorro");
                            int valorAhorro = sc.nextInt();
                            System.out.println("menciona tu categoria");
                            int categoria = sc.nextInt();
                            cliente.generarAhorro(valorAhorro, categoria,opcion);


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
                    traerBolsillos(opcion);
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Vuelva pronto");
                    Serializador.serializar(cliente);
                    System.exit(0);
                default:
                    System.out.println("Por favor ingrese una opción valida");
            }

        }while(opcion != 7);

    }

    public static void traercuentas(){
        for (Cuenta i: cliente.listaCuentas) {
            System.out.println(i.toString());
        }
    }

    public static void traerBolsillos(int id){
        for (Bolsillo i: Cliente.listaCuentas.get(id).misBolsillos) {
            System.out.println(i.toString());
        }
    }






}
