//package java;

import java.util.Scanner;

public class MainClass {
   //public static int rand;
    //public static Scanner i = new Scanner(System.in);

    public static int getRandNum(int num){
        return num;
    }

    public static int getInputNum(int num){
        return num;
    }

    public static void main(String [] args) {
        String c = " ";
         int rand = (int)(Math.random() * 21);
         getRandNum(rand);
        int ctr = 1;
        String name = "";
        System.out.println("Hello! What is your name?");
        Scanner in = new Scanner(System.in);
        try {
            name = in.nextLine();
        }catch (Exception e){
            System.out.println("Invalid input.");
            return;
        }
        System.out.println();
        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.\n" +
                "Take a guess.");


           // for (int n = 1; n <= 6; n++) {
        do {    Scanner i = new Scanner(System.in);
            int guess = 0;
              try{  guess = i.nextInt();
              }catch (Exception e){
                  System.out.println("Invalid input.");
                  return;
              }
              getInputNum(guess);
                if (guess > rand) {
                    System.out.println("Your guess is too high.\n" +
                            "Take a guess.");
                } else if (guess < rand) {
                    System.out.println("Your guess is too low.\n" +
                            "Take a guess.");
                } else if (guess == rand) {
                    System.out.println("Good job, " + name + "! You guessed my number in " + ctr + " guesses!\n" +
                            "Would you like to play again? (y or n)");
                    Scanner input = new Scanner(System.in);
                   try{ c = input.next();
                   }catch (Exception e){
                       System.out.println("Invalid input.");
                       return;
                   }
                    if (c.equals("y")) {
                        ctr = 0;
                        System.out.println("Take a guess!");
                    }
                    else{
                        break;
                    }
                }

            ctr++;
            if(ctr > 6) {
                System.out.println("Better luck next time!");
                System.out.println("Would you like to play again? (y or n)");
                Scanner input = new Scanner(System.in);
                String str = "";
                try{ str = input.next();
                }catch (Exception e){
                    System.out.println("Invalid input.");
                    return;
                }
                if (str.equals("y")) {
                    ctr = 1;
                    System.out.println("Take a guess!");
                }
                else{
                    break;
                }

            }
           // }
        }while(ctr <= 6);


    }

}
