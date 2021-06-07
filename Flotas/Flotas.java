package Flotas;
import java.util.*;

class Flotas {
	public static int[][] tablero = new int[10][10];
    public static String[] barco1 = new String[3];
    public static String[] barco2 = new String[4];
    public static int flotaEnemiga1 = 1;
    public static int flotaEnemiga2 = 1;

    public static void main(String[] args){
    	int total1 = 0;
        int total2 = 0;
        String flota1 = "";
        String flota2 = "";
        
        System.out.println("***Bienvenido al juego de hunde la flota***");

        rellenarTablero();
        colocarFlotaEnemiga();
        for(int i = 0; i < barco1.length; i++) {
        	System.out.println(barco1[i]);
        }
        for(int i = 0; i < barco2.length; i++) {
        	System.out.println(barco2[i]);
        }
        mostrarTablero();

        do{
            adivina();
            
            total1 = 0;
            for(int i = 0; i < barco1.length; i++){
            	
                if(barco1[i] == "0"){
                    total1++;
                }
            }

            total2 = 0;
            for(int j = 0; j < barco2.length; j++){
            	
                if(barco2[j].equals("0")){
                    total2++;
                }
            }
                    
                if(total1 == 3){
                    System.out.println("Flota 1 hundida.");
                    Flotas.flotaEnemiga1--;
                    flota1 = "hundida";
                }
                
                if(total2 == 4){
                    System.out.println("Flota 2 hundida.");
                    Flotas.flotaEnemiga2--;
                    flota2 = "hundida";
                }
                
        }while(flota1 != "hundida" || flota2 != "hundida");

        finPartida();
    }


    public static void rellenarTablero(){
        for(int x = 0; x < tablero.length; x++){
            for(int y = 0; y < tablero.length; y++){
                tablero[x][y] = 0;
            }
        }
    }

    
    public static void mostrarTablero(){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    

    public static void colocarFlotaEnemiga(){
        System.out.println("El enemigo está colocando su flota");
        int cont;
        int j;
        
      //Este bucle se encarga de añadir la segunda flota al array de barco1
        for(int i = 0; i < 1; i++){
            int x = (int)(Math.random() * 7);
            int y = (int)(Math.random() * 7);
            
            if((x >= 0 && x < 10) && (y >= 0 && y < 10) && (tablero[x][y] == 0)){
            	j = 0;
            	cont = 1;
            	do {
            		tablero[x][y] = 1;
                        
                    	    String coordX = Integer.toString(x);
                    	    String coordY = Integer.toString(y);

                    	    
                    	    if(j < 3) {
                    	    	Flotas.barco1[j] = coordX+coordY;
                    	    }
                        
                    y = y+1;
            		cont++;
            		j++;
            	}while(cont<=3);
            	
            }
                System.out.println("Barco 1 posicionado");
        }
        
        //Este bucle se encarga de añadir la segunda flota al array de barco2
        for(int i = 0; i < 1; i++){
            int x = (int)(Math.random() * 6);
            int y = (int)(Math.random() * 6);

            if((x >= 0 && x < 10) && (y >= 0 && y < 10) && (tablero[x][y] == 0)){
            	j = 0;
            	cont = 1;
            	do {
            		tablero[x][y] = 1;

                    	    String coordX = Integer.toString(x);
                    	    String coordY = Integer.toString(y);
                    	    
                    	    if( j < 4) {
                    	    	barco2[j] = coordX+coordY;
                    	    }
                    	    
                    y = y+1;
            		cont++;
            		j++;
            	}while(cont<=4);
            }
                System.out.println("Barco 2 posicionado");
        }
    }


    public static void adivina(){
        int x,y;

        System.out.println("¡Ahora es tu turno para adivinar!");
        do{
        	
            Scanner input = new Scanner(System.in);
            System.out.print("Introduce coordenada X: ");
            x = input.nextInt();
            System.out.print("Introduce coordenada Y: ");
            y = input.nextInt();

                if((x >= 0 && x < 10) && (y >= 0 && y < 10)){
                    if(tablero[x][y] == 1){
                
                        String coordX = Integer.toString(x);
                	    String coordY = Integer.toString(y);
                        //String coordTot = coordX+coordY;
                    
                            for(int i = 0; i < barco1.length; i++) {
                    	
                    	        if(barco1[i].equals(coordX+coordY)) {
                                    barco1[i] = "0";
                    	        }
                            }
                    
                            for(int i = 0; i < barco2.length; i++) {
                    	
                    	        if(barco2[i].equals(coordX+coordY)) {
                    		        barco2[i] = "0";
                    	        }
                            }
                        
                        System.out.println("¡IMPACTO!");
                        //tablero[x][y] = 0;
                    }else if(tablero[x][y] == 0){
                        System.out.println("Has fallado.");
                    }
                }else if((x < 0 || x >= 10) || (y < 0 || y >= 10)){
                    System.out.println("No puedes disparar fuera del tablero.");
                }
             
                //probarVictoria();
        }while((x < 0 || x >= 10) || (y < 0 || y >= 10));
    }

    
    public static void finPartida(){
        if(Flotas.flotaEnemiga1 == 0 && Flotas.flotaEnemiga2 == 0){
            System.out.println("¡Enhorabuena, has ganado!");
        }
    }
}
