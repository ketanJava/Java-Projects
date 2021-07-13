

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        System.out.println("Do you wish to encrypt or decrypt a message?");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println("Enter your message:");
        String msg = s.nextLine();
        System.out.println("Enter the key number:(1-52)");
        String key = s.nextLine();
        ArrayList<String> al = new ArrayList<>();
        for(String i : msg.split("")){
            al.add(i);
        }
        ArrayList<String> al2 = new ArrayList<>();
        ArrayList<String> al3 = new ArrayList<>();
        al2.add("A");
        al2.add("a");
        al2.add("B");
        al2.add("b");
        al2.add("C");
        al2.add("c");
        al2.add("D");
        al2.add("d");
        al2.add("E");
        al2.add("e");
        al2.add("F");
        al2.add("f");
        al2.add("G");
        al2.add("g");
        al2.add("H");
        al2.add("h");
        al2.add("I");
        al2.add("i");
        al2.add("J");
        al2.add("j");
        al2.add("K");
        al2.add("k");
        al2.add("L");
        al2.add("l");
        al2.add("M");
        al2.add("m");
        al2.add("N");
        al2.add("n");
        al2.add("O");
        al2.add("o");
        al2.add("P");
        al2.add("p");
        al2.add("Q");
        al2.add("q");
        al2.add("R");
        al2.add("r");
        al2.add("S");
        al2.add("s");
        al2.add("T");
        al2.add("t");
        al2.add("U");
        al2.add("u");
        al2.add("V");
        al2.add("v");
        al2.add("W");
        al2.add("w");
        al2.add("X");
        al2.add("x");
        al2.add("Y");
        al2.add("y");
        al2.add("Z");
        al2.add("z");
        if(str.equals("encrypt")){
            for (int i = 0; i < al.size(); i++) {
                if(al.get(i).equals(" ")){
                    al3.add(i, " ");
                }
                else{
                    int x;
                    if(al2.indexOf(al.get(i)) + Integer.valueOf(key) >= 52){
                        x = Integer.valueOf(key) - (51-al2.indexOf(al.get(i)));
                    }
                    else{
                        x = al2.indexOf(al.get(i)) + Integer.valueOf(key);
                    }
                    al3.add(al2.get(x));

                }
            }
            String strng = "";
            for(String st: al3) {
                strng = strng+st;
            }
            Charset utf8 = StandardCharsets.UTF_8;
            Files.createFile(Paths.get("myfile.txt"));
            Files.write(Paths.get("myfile.txt"), strng.getBytes(utf8));
            System.out.println("Your translated text is:");
            String sr = String.valueOf(Files.readAllLines(Paths.get("myfile.txt")));
            System.out.println(sr);

            //al3.clear();
            ArrayList<String> arl = new ArrayList<>();
            for(String u: al3){
                arl.add(u);
            }
            al3.clear();
            for (int i = 0; i < al.size(); i++) {
                if(arl.get(i).equals(" ")){
                    al3.add(i, " ");
                }
                else{
                    int x;
                    if(al2.indexOf(arl.get(i)) - Integer.valueOf(key) < 0){
                        x = 51 - (Integer.valueOf(key) -al2.indexOf(arl.get(i)));
                    }
                    else{
                        x = al2.indexOf(arl.get(i)) - Integer.valueOf(key);
                    }
                    al3.add(al2.get(x));

                }
            }
            String strng2 = "";

            for(String st: al3) {
                strng2 = strng2+st;
            }
            System.out.println("Decrypted output:");
            System.out.println(strng2);
        }
        else if(str.equals("decrypt")){
            for (int i = 0; i < al.size(); i++) {
                if(al.get(i).equals(" ")){
                    al3.add(i, " ");
                }
                else{
                    int x;
                    if(al2.indexOf(al.get(i)) - Integer.valueOf(key) < 0){
                        x = 51 - (Integer.valueOf(key) -al2.indexOf(al.get(i)));
                    }
                    else{
                        x = al2.indexOf(al.get(i)) - Integer.valueOf(key);
                    }
                    al3.add(al2.get(x));

                }
            }
            String strng = "";
            for(String st: al3) {
                strng = strng+st;
            }
            Charset utf8 = StandardCharsets.UTF_8;
            Files.createFile(Paths.get("myfile2.txt"));
            Files.write(Paths.get("myfile2.txt"), strng.getBytes(utf8));
            System.out.println("Your translated text is:");
            System.out.println(Files.readAllLines(Paths.get("myfile2.txt")));

        }
    }
}

