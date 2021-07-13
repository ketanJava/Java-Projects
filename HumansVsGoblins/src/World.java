import java.util.ArrayList;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        System.out.println("Welcome To Humans Vs. Goblins!");
        System.out.println();
String hum = "";
String gob = "";
boolean combat = false;

        Humans h = new Humans();
        Goblins g = new Goblins();
        Land l = new Land();


        //ArrayList<String> grid = new ArrayList<>();
            for (int j = 0; j < l.height; j++) {
                    for (int k = 0; k < l.width; k++) {
                            l.grid.add(l.symbol + " ");
                    }


            }
        System.out.println("Human's name:");
        Scanner name = new Scanner(System.in);
        try {
            h.name = name.nextLine();
        }catch (Exception e){
            System.out.println("Invalid Input!");
        }
        System.out.println("Goblin's name:");
        try{g.name = name.nextLine();
    }catch (Exception e){
        System.out.println("Invalid Input!");
    }
        System.out.println();
            int hx = 0;
            int hy =0;
            int gx =9;
            int gy =9;

//grid.add(hx*hy, h.symbol);
//grid.add(gx*gy , g.symbol);
        System.out.println(l);
        for (int i = 0; i < l.height; i++) {
            System.out.println();
            for (int j = 0; j < l.width; j++) {
                if(i == hy && j == hx){
                    System.out.print(h.symbol);
                }
                else if(i == gy && j== gx){
                    System.out.print(g.symbol);
                }
                else {
                    System.out.print(l.grid.get(i));
                }

            }
        }
   do {
       System.out.println();
       System.out.println();
       System.out.println(h.name + "'s move:");
       Scanner inp = new Scanner(System.in);
       try{hum = inp.next();
       }catch (Exception e){
           System.out.println("Invalid Input!");
       }
       if (hum.equals("n")) {
           hy -= 1;
       } else if (hum.equals("s")) {
           hy += 1;
       } else if (hum.equals("w")) {
           hx -= 1;
       } else if (hum.equals("e")) {
           hx += 1;
       }
     //  System.out.println();
       for (int i = 0; i < l.height; i++) {
           for (int j = 0; j < l.width; j++) {
               if (i == hy && j == hx) {
                   System.out.print(h.symbol);
               } else if (i == gy && j == gx) {
                   System.out.print(g.symbol);
               } else {
                   System.out.print(l.grid.get(i));
               }
           }
           System.out.println();
       }
       System.out.println();
       System.out.println();
       System.out.println(g.name + "'s move:");
       Scanner s = new Scanner(System.in);
       try{gob = s.next();
   }catch (Exception e){
            System.out.println("Invalid Input!");
        }
       if (gob.equals("n")) {
           gy -= 1;
       } else if (gob.equals("s")) {
           gy += 1;
       } else if (gob.equals("w")) {
           gx -= 1;
       } else if (gob.equals("e")) {
           gx += 1;
       }
     //  System.out.println();
       for (int i = 0; i < l.height; i++) {
           for (int j = 0; j < l.width; j++) {
               if (i == hy && j == hx) {
                   System.out.print(h.symbol);
               } else if (i == gy && j == gx) {
                   System.out.print(g.symbol);
               } else {
                   System.out.print(l.grid.get(i));
               }
           }
           System.out.println();
       }


       if (hx == gx && hy == gy) {
           combat = true;
           break;
       }
   }while (combat == false);
   if(combat == true){
       System.out.println();
       System.out.println();
       System.out.println("Combat Has Started!");
       System.out.println();
     do {
         h.strength = (int) (Math.random() * 101);
         g.strength = (int) (Math.random() * 101);
     }while(h.strength == g.strength);
       System.out.println(h);
       System.out.println(g);
       if(h.strength >= g.strength){
           System.out.println("Hence, "+ h.name + " wins!");
       }
       else{
           System.out.println("Hence, "+ g.name + " wins!");
       }
   }


    }
}