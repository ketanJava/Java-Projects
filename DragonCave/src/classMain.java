import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class classMain {
    public static void main(String [] args){
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)");
        System.out.println();
        Scanner input = new Scanner(System.in);
        int i=0;
        try{  i = input.nextInt();
        }catch (Exception e){
            System.out.println("Invalid input.");
            return;
        }
        System.out.println();
        System.out.println(i);
        System.out.println();
        System.out.println("You approach the cave...\n" +
                "It is dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "Gobbles you down in one bite!");
    }
}
