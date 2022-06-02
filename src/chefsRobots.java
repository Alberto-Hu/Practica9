import java.util.Scanner;

public class chefsRobots{
    public static void main(String[] args) {
        int num,c=1,ingrediente=1,i,k;
        int[] robot = new int[25];
        int[] accion = new int[25];
        boolean f=true,bat,comidaCompletada=true;
        boolean[] exito = new boolean[25];

        Robot [] robotArray = new Robot [5];//array de objetos de robot
        robotArray[0] = new Chef("Cheff robot",100);
        robotArray[1] = new Mini("Mini robot 1",100);
        robotArray[2] = new Mini("Mini robot 2",100);
        robotArray[3] = new Mini("Mini robot 3",100);
        robotArray[4] = new Mini("Mini robot 4",100);
        Scanner sc= new Scanner(System.in);

        System.out.println();
        bat=((Chef) robotArray[0] ).batteryFull();//check battery con el uso de interface
        ((Chef) robotArray[0] ).checkBattery(bat);
        bat=((Mini) robotArray[1] ).batteryFull();
        ((Mini) robotArray[1] ).checkBattery(bat);
        bat=((Mini) robotArray[2] ).batteryFull();
        ((Mini) robotArray[2] ).checkBattery(bat);
        bat=((Mini) robotArray[3] ).batteryFull();
        ((Mini) robotArray[3] ).checkBattery(bat);
        bat=((Mini) robotArray[4] ).batteryFull();
        ((Mini) robotArray[4] ).checkBattery(bat);

        System.out.print("""

                    Elige: desayuno / comida / cena
                    1.Desayuno
                    2.Comida
                    3.Cena
                    """);
        k = sc.nextInt();

        do{
            if(k==1) {
                System.out.print("Elegiste desayuno\n");
                if(k==2)
                    System.out.print("Elegiste comida\n");
                if(k==3)
                    System.out.print("Elegiste cena\n");
            }

            System.out.print(
                    "\nAccion: "+ c +
                    "\nElija el robot que desea usar:"+
                    "\n1.Robot Cheff"+
                    "\n2.Mini Robot 1 (2 Cuchillos)"+
                    "\n3.Mini Robot 2 (Manos Calientes)"+
                    "\n4.Mini Robot 3 (Manos Calientes)"+
                    "\n5.Mini Robot 4 (Manos Calientes)"+
                    "\n\nIngresa numero: ");
            robot[c-1] = sc.nextInt();

            System.out.print("\nElija un accion para realizar con el robot:"+
                    "\n1.Preparar ingredinete: "+ ingrediente +
                    "\n2.Cocinar ingredientes:" +
                    "\n3.Servir"+
                    "\n\nIngresa numero: ");
            accion[c-1] = sc.nextInt();
            num=accion[c-1];

            switch(num){
                case 1: if(robot[c-1]==1){ exito[c-1]=robotArray[robot[c-1]-1].preparar(ingrediente,robot[c-1]);//accion de preparar ingrediente, si se cumple regresa true
                    ingrediente++;//contador de ingrediente
                }
                else{
                    if(robot[c-1]==2 || robot[c-1]==3){ exito[c-1]=robotArray[robot[c-1]-1].preparar(ingrediente,robot[c-1]);//accion de preparar ingrediente, si se cumple regresa true
                        if(exito[c - 1]) ingrediente++;//contador de ingrediente
                    }
                    else {System.out.println("Robot no existente"); c--;}
                }
                    break;
                case 2:if(robot[c-1]==1) exito[c-1]=robotArray[robot[c-1]-1].cocinar(robot[c-1]);
                else{
                    if(robot[c-1]==2 || robot[c-1]==3) exito[c-1]=robotArray[robot[c-1]-1].cocinar(robot[c-1]);
                    else{ System.out.println("Robot no existente"); c--; }
                }
                    break;
                case 3:	if(robot[c-1]==1){ exito[c-1]=robotArray[robot[c-1]-1].servir(robot[c-1]);//accion de servir, si se cumple regresa true
                    f=false;//bandera de salida a falsa
                }
                else{
                    if(robot[c-1]==2 || robot[c-1]==3){ exito[c-1]=robotArray[robot[c-1]-1].servir(robot[c-1]);//accion de servir, si se cumple regresa true
                        f=false;//bandera de salida a falsa
                    }
                    else {System.out.println("Robot no existente"); c--;}
                }
                    break;
                default: System.out.println("\n--Ingresa una de las opciones--\n");
                    c--;
            }
            c++;
        }while(f); //mientras que la bandera de salida sea verdadera

        System.out.println("");
        for(i=0;i<c-1;i++) {Acciones.ordenAcciones(robot[i],accion[i],exito[i],i);//muestra acciones realizadas en orden, y si se realizaron con exito
            if(i>0){
                comidaCompletada=exito[i];//si no pudo realizar su tarea, iguala la variable a false
                if(comidaCompletada){
                    if(accion[i]<accion[i-1]) comidaCompletada=false; //si no pudo realizar las tareas en el procedimiento correcto, iguala la variable a false
                }
            }
        }

        if(comidaCompletada) System.out.println("\n ¡Hurra! El platillo estaba delicioso.");
        else System.out.println("\n No se pudo preparar la comida" +
                "\nSe debe (1)preparar ingredientes -> (2) cocinar -> (3) servir)");

    }
}


