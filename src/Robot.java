interface Battery{//interface para revisar la bateria
    public boolean batteryFull();
    public void checkBattery(boolean bat);
}

abstract class Robot{//clase padre abstacta
    String name;
    int battery;

    public Robot(String name, int battery){
        this.name = name;
        this.battery = battery;
    }

    public abstract boolean preparar(int ingrediente,int r);

    public abstract boolean cocinar(int r);

    public abstract boolean servir(int r);
}

class Chef extends Robot implements Battery{//clase para robot cheff

    public Chef(String name, int battery){
        super(name,battery);
    }

    public boolean preparar(int ingrediente,int r){
        System.out.println("Se preparao con exito el ingrediente: "+ ingrediente);
        return true;
    }

    public boolean cocinar(int r){
        System.out.println("Se cocino con exito.");
        return true;
    }

    public boolean servir(int r){
        System.out.println("Se sirvio con exito la comida.");
        return true;
    }

    public boolean batteryFull(){
        if(battery>0) return true;
        else return false;
    }

    public void checkBattery(boolean bat){
        if(bat) System.out.println(name +" tiene bateria con "+ battery + "% de carga, esta listo para usarse.");
        else System.out.println(name +" tiene bateria con carga suficiente para usarse");
    }
}

class Mini extends Robot implements Battery{//clase para los mini robots

    public Mini(String name, int battery){
        super(name,battery);
    }

    public boolean preparar(int ingrediente,int r){//si el robot 2 realizo la tarea, regresa true
        if(r==2){
            System.out.println("Se prepraro con exito el ingrediente: "+ ingrediente + ".");
            return true;
        }
        else{
            System.out.println("Robot "+ r +" no es  capaz de preparar el ingrediente.");
            return false;
        }
    }

    public boolean cocinar(int r){//si el robot 3 realizo la tarea, regres true
        if(r==3){
            System.out.println("Se cocino con exito.");
            return true;
        }
        else{
            System.out.println("Robot "+ r +" no es capaz de cocinar.");
            return false;
        }
    }

    public boolean servir(int r){//robot mini ni puede servir, regresa false
        System.out.println("Robot " + r +" no capaz de servir la comida.");
        return false;
    }

    public boolean batteryFull(){
        if(battery>0) return true;
        else return false;
    }

    public void checkBattery(boolean bat){
        if(bat) System.out.println(name +" tiene bateria con "+ battery + "% de carga, esta listo para usarse.");
        else System.out.println(name +" no tiene bateria con carga sufiente para usarse.");
    }
}

class Acciones{//clase 	que muestra la accione realizada

    public static void ordenAcciones(int robot, int accion, boolean exito,int i){
        String name="", tarea="";
        i++;

        switch (robot) {//dependiendo del numero que este en el vector, genera un nombre en la variable
            case 1 -> name = "Cheff";
            case 2 -> name = "Mini 2";
            case 3 -> name = "Mini 3";
        }

        switch (accion) {//dependiendo del numero del vector, genera una tarea char en la variable
            case 1 -> tarea = ": Preparar ingrediente.";
            case 2 -> tarea = ": Cocinar.";
            case 3 -> tarea = ": Servir la comida.";
        }
        System.out.println("\nAccion: "+ i +
                "\nRobot "+ name + " " + tarea);

        if(exito) System.out.println("La tarea se realizo con exito.");
        else System.out.println("--Tarea no se pudo realizar--");

    }
}