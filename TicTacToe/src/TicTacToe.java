import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String []args){
        ArrayList<String> aList = new ArrayList<>(9);
        for (int x = 0; x<9; x++) {
          aList.add(x, null);
        }
        String c = "";
        int i;
        int rand;
        String str = "";
        String strn = "";
        int ctr = 1;
       do {
           System.out.println("Welcome to Tic-Tac-Toe!\n" +
                   "Do you want to be X or O?");
           Scanner in = new Scanner(System.in);
           String u = "";
           try{u = in.next(); }catch (Exception e){
            System.out.println("Invalid input.");
            return;
        }
           if (u.equals("X")) {
               c = "O";
           } else if(u.equals("O")){
               c = "X";
           }

           System.out.println("The computer will go first.\n");
           do {
               do {
                   rand = (int) (Math.random() * 9 +1);
               } while ((aList.get(rand - 1)) != null);
               aList.set((rand - 1), c);
               String l1 = aList.get(0);
               if(aList.get(0) == null)   {
                   l1 = "";
               }
               String l2 = aList.get(1);
               if(aList.get(1) == null)   {
                   l2 = "";
               }
               String l3 = aList.get(2);
               if(aList.get(2) == null)   {
                   l3 = "";
               }
               String l4 = aList.get(3);
               if(aList.get(3) == null)   {
                   l4 = "";
               }
               String l5 = aList.get(4);
               if(aList.get(4) == null)   {
                   l5 = "";
               }
               String l6 = aList.get(5);
               if(aList.get(5) == null)   {
                   l6 = "";
               }
               String l7 = aList.get(6);
               if(aList.get(6) == null)   {
                   l7 = "";
               }
               String l8 = aList.get(7);
               if(aList.get(7) == null)   {
                   l8 = "";
               }
               String l9 = aList.get(8);
               if(aList.get(8) == null)   {
                   l9 = "";
               }
               System.out.println(l7 + "  |    " + l8 + "    |  " + l9 + "\n" +
                       "--------------\n" +
                       l4 + "    |    " + l5 + "    |    " + l6 + "\n" +
                       "--------------\n" +
                       l1 + "    |    " + l2 + "    |    " + l3);

               System.out.println("What is your next move? (1-9)");
               do {
                   Scanner inp = new Scanner(System.in);
                 try{  i = inp.nextInt();
               }catch (Exception e){
                   System.out.println("Invalid input.");
                   return;
               }

                   if ((aList.get(i - 1)) != null) {
                       System.out.println("That place is already filled.\nGo again!");
                       continue;
                   } else {
                       aList.set((i - 1), u);
                       break;
                   }
               } while (true);
               if ((aList.get(0) == c && aList.get(1) ==c && aList.get(2) == c) ||
                       (aList.get(3) == c && aList.get(4) == c && aList.get(5) == c) ||
                       (aList.get(6) == c && aList.get(7) == c && aList.get(8) == c) ||
                       (aList.get(0) == c && aList.get(3) == c && aList.get(6) == c) ||
                       (aList.get(1) == c && aList.get(4) == c && aList.get(7) == c) ||
                       (aList.get(2) == c && aList.get(5) == c && aList.get(8) == c) ||
                       (aList.get(2) == c && aList.get(4) == c && aList.get(6) == c) ||
                       (aList.get(0) == c && aList.get(4) == c && aList.get(8) == c)
               ){
                   System.out.println("The computer has beaten you! You lose.\n" +
                           "Do you want to play again? (y or n)");
                   Scanner sc = new Scanner(System.in);
                  try{ str = sc.next();
               }catch (Exception e){
                   System.out.println("Invalid input.");
                   return;
               }
                   aList.clear();
                   for (int x = 0; x<9; x++) {
                       aList.add(x, null);
                   }
                   break;
               }
                else if ((aList.get(0) == u && aList.get(1) == u && aList.get(2) == u) ||
                       (aList.get(3) == u && aList.get(4) == u && aList.get(5) == u) ||
                       (aList.get(6) == u && aList.get(7) == u && aList.get(8) == u) ||
                       (aList.get(0) == u && aList.get(3) == u && aList.get(6) == u) ||
                       (aList.get(1) == u && aList.get(4) == u && aList.get(7) == u) ||
                       (aList.get(2) == u && aList.get(5) == u && aList.get(8) == u) ||
                       (aList.get(2) == u && aList.get(4) == u && aList.get(6) == u) ||
                       (aList.get(0) == u && aList.get(4) == u && aList.get(8) == u)
               ) {
                   System.out.println("You won.\n" +
                           "Do you want to play again? (y or n)");
                   Scanner scn = new Scanner(System.in);
                 try{  strn = scn.next();
               }catch (Exception e){
                   System.out.println("Invalid input.");
                   return;
               }
                   aList.clear();
                   for (int x = 0; x<9; x++) {
                       aList.add(x, null);
                   }
                   break;
               }

ctr++;
           } while (true);

ctr = 1;
       }while(str.equals("y") || strn.equals("y"));

    }

}
