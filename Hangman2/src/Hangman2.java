

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman2 {
    public static void main(String[] args) throws IOException {
        System.out.println("H A N G M A N");
        int score = 4;

        System.out.println("Enter your name:");
        Scanner s = new Scanner(System.in);
        String name = "";
        try {
            name = s.next();
        }catch (Exception e){
            System.out.println("Invalid input!");
        }
        int ctr = 0;
        int ctr2 = 0;
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> lst = new ArrayList<>();
        lst.add("_");
        lst.add("_");
        lst.add("_");
        System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(0));
        System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(1));
        System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(2));
        System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(3));
        System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(4));
        do {

           // System.out.println("Score: " + score);

            System.out.print("Missed Letters: ");
            System.out.println(Arrays.toString(arr.stream().map(x -> x).toArray()));
            System.out.println();
            System.out.println(Arrays.toString(lst.stream().map(x -> x).toArray()));
            System.out.println("Guess a letter!");
            String in = "";
        try{in = s.next();
        }catch (Exception e){
            System.out.println("Invalid input!");
        }
            if (lst.contains(in) || arr.contains(in)) {
                System.out.println("You have already guessed that letter. Choose again.");
                continue;
            } else if (in.equals("c")) {
                lst.set(0, in);
                ctr++;
            } else if (in.equals("a")) {
                lst.set(1, in);
                ctr++;
            } else if (in.equals("t")) {
                lst.set(2, in);
                ctr++;
            } else {
                arr.add(in);
                ctr2++;
                score--;
            }

            if (ctr == 3) {
                Files.write(Paths.get("src/NameAndScore.txt"), ("Name: " + name + "\nScore: " + score).getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println(Files.readAllLines(Paths.get("src/NameAndScore.txt")));
                List<Integer> l1 = new ArrayList<>();
              //  l1 = Files.readAllLines(Paths.get("src/NameAndScore.txt"));
/*Stream stm = l1.stream();
final int scr= score;
Object [] l2 = stm.filter(x-> Integer.valueOf((String) x) > scr).toArray();
if(l2.length == 0){
    System.out.println("High score!");
}*/
                final int scr= score;
                Scanner reader = new Scanner("NameAndScore");
                while(reader.hasNextInt()){
                    l1.add(reader.nextInt());
                }
                Stream<Integer> strm = l1.stream();
                List<Integer> il1 = strm.filter(x -> Integer.valueOf( x) > scr).collect( Collectors.toList());
                if(il1.isEmpty()){
                    System.out.println("High score!");
                }

                System.out.println("Yes! The secret word is \"cat\"! You have won!\n" +
                        "Do you want to play again? (y or n)");
                Scanner sc = new Scanner(System.in);
                String st = "";
try{st = sc.next();
            }catch (Exception e){
                System.out.println("Invalid input!");
            }
                if (st.equals("y")) {
                    lst.clear();
                    lst.add("_");
                    lst.add("_");
                    lst.add("_");
                    arr.clear();
                    ctr = 0;
                    ctr2 = 0;
                    score = 3;
                } else {
                    break;
                }
            }

                if (ctr2 == 0) {
                   // List<String> l1 = new ArrayList<>();
                    //l1 = Files.readAllLines(Paths.get("hangman.txt"));
                    //Stream s1 = l1.stream();
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(0));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(1));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(2));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(3));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(4));
                } else if (ctr2 == 1) {
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(6));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(7));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(8));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(9));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(10));
                } else if (ctr2 == 2) {
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(12));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(13));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(14));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(15));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(16));
                } else if (ctr2 == 3) {
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(18));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(19));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(20));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(21));
                    System.out.println(Files.readAllLines(Paths.get("src/hangman.txt")).get(22));
                } else if (ctr2 > 3) {
                    Files.write(Paths.get("src/NameAndScore.txt"), ("Name: " + name + "\nScore: " + score).getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println(Files.readAllLines(Paths.get("src/NameAndScore.txt")) + "\n");
                    List<Integer> l1 = new ArrayList<>();
                    /*l1 = Files.readAllLines(Paths.get("src/NameAndScore.txt"));
                    Stream stm = l1.stream();
                    final int scr= score;
                    Object [] l2 = stm.filter(x-> Integer.valueOf((String) x) > scr).toArray();*/
                    final int scr= score;
                    Scanner reader = new Scanner("NameAndScore");
                    while(reader.hasNextInt()){
                        l1.add(reader.nextInt());
                    }
                    Stream<Integer> strm = l1.stream();
                    List<Integer> il1 = strm.filter(x -> Integer.valueOf( x) > scr).collect( Collectors.toList());
                    if(il1.isEmpty()){
                        System.out.println("High score!");
                    }

                    System.out.println("Sorry, you`ve reached your maximum number of incorrect guesses. GAME OVER!" + "\n" +
                            "Do you want to play again? (y or n)");
                    Scanner scn = new Scanner(System.in);
                    String stng = "";
try{stng = scn.next();
                }catch (Exception e){
                System.out.println("Invalid input!");
            }
                    if (stng.equals("y")) {
                        lst.clear();
                        lst.add("_");
                        lst.add("_");
                        lst.add("_");
                        arr.clear();
                        ctr = 0;
                        ctr2 = 0;
                        score = 3;
                    } else {
                        break;
                    }
                }

        }
            while (ctr < 3) ;





        /*int ctr = 0;
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
            String s = in.next();
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
                String st = sc.next();
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
                String stng = scn.next();
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

    */
        }

    }

