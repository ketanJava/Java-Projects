
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainClass {
    public static void main(String [] args){
        int ctr = 0;
        int ctr2 = 0;
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> lst = new ArrayList<>();
        lst.add("_");
        lst.add("_");
        lst.add("_");
        System.out.println("H A N G M A N");
        System.out.println("+---+");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("  ===");
      do {
          System.out.print("Missed Letters: ");
          for (String str : arr){
              System.out.print(str);
          };
          System.out.println("\n");
          for (String strng : lst) {
              System.out.print(strng);
          }
          System.out.println("\n");
          System.out.println("Guess a letter!");
          Scanner in = new Scanner(System.in);
          String s = "";
         try{ s = in.next();

         }catch (Exception e){
             System.out.println("Invalid input.");
             return;
         }
          if(lst.contains(s) || arr.contains(s)){
              System.out.println("You have already guessed that letter. Choose again.");
          }

          else if (s.equals("c")) {
              lst.set(0, s);
              ctr2++;
          } else if (s.equals("a")) {
              lst.set(1, s);
              ctr2++;
          } else if (s.equals("t")) {
              lst.set(2, s);
              ctr2++;
          } else {
              arr.add(s);
              ctr++;
          }
          if(ctr2 == 3){
              System.out.println("Yes! The secret word is \"cat\"! You have won!\n" +
                      "Do you want to play again? (y or n)");
              Scanner sc = new Scanner(System.in);
              String st = "";
              try{ st = sc.next();
          }catch (Exception e){
              System.out.println("Invalid input.");
              return;
          }
              if(st.equals("y")){
                  lst.clear();
                  lst.add("_");
                  lst.add("_");
                  lst.add("_");
                  arr.clear();
                  ctr =0;
                  ctr2 = 0;
              }
              else{
                  break;
              }
          }
          if(ctr == 0){
              System.out.println("+---+");
              System.out.println("   |");
              System.out.println("   |");
              System.out.println("   |");
              System.out.println("  ===");
          }
          else if(ctr == 1 ){
              System.out.println("+---+");
              System.out.println("O   |");
              System.out.println("    |");
              System.out.println("    |");
              System.out.println("  ===");
          }
          else if(ctr == 2){
              System.out.println("+---+");
              System.out.println("O   |");
              System.out.println("|   |");
              System.out.println("    |");
              System.out.println("  ===");
          }
          else if(ctr == 3){
              System.out.println("+---+");
              System.out.println("O   |");
              System.out.println("|   |");
              System.out.println("|   |");
              System.out.println("  ===");
          }
          else if(ctr > 3){
              System.out.println("Sorry, you`ve reached your maximum number of incorrect guesses. GAME OVER!" +"\n" +
                      "Do you want to play again? (y or n)");
              Scanner scn = new Scanner(System.in);
              String stng = "";
              try{ stng = scn.next();
              }catch (Exception e){
                  System.out.println("Invalid input.");
                  return;
              }
              if(stng.equals("y")){
                  lst.clear();
                  lst.add("_");
                  lst.add("_");
                  lst.add("_");
                  arr.clear();
                  ctr = 0;
                  ctr2 = 0;
              }
              else{
                  break;
              }
          }
      }while(ctr2 < 3);

    }
}
