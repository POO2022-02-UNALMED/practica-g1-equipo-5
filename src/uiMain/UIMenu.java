package uiMain;

import java.util.Scanner;
import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;

public class UIMenu {
    public static Cliente cliente= new Cliente("Jaimico",20192121,0);
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){


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
                    UIPrestamo.prestamo(cliente);
                    break;
                case 2:
                    UIPago.Pagar(cliente);
                    break;
                case 3:
                    UIBolsillos.bolsillo(cliente);
                    break;
                case 4:
                /*
                	System.out.println("Ingrese el numero de cuenta Destino");
                	int numeroCuenta= sc.nextInt();
                	System.out.println("Ingrese valor a transferir");
                	int valor1= sc.nextInt();
                	for (int i = 0; i < cuentaExterna.size; i++) {
                		if (cuentaExterna.get(i).getNumero()== numeroCuenta ) {
                		Cuenta cuentaDestino= cuentaExterna.get(i);      		
                		}
                		}
                	
                	cliente.hacerTransferencia(cuentaDestino,valor1);*/

                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Por favor ingrese una opción valida");
            }

        }while(opcion != 6);

    }
    public static void traercuentas(){
        for (Cuenta i: cliente.listaCuentas) {
            System.out.println(i.toString());
        }
    }
    public static void traerBolsillos(int idCuenta){

        Cuenta cuentas = Cliente.buscarCuenta(idCuenta);

        for (Bolsillo bolsillo: cuentas.misBolsillos) {
            System.out.println(bolsillo.toString());
        }
    }


}
