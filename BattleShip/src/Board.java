public class Board {
  /*  public Board(){
        x =0;
        y = 0;
    }
public Board(int x, int y){
    this.x = x;
    this.y = y;
}
public int getX(){
        return x;
}
public void setX(int x){
        this.x = x;
}
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.x = y;
    }
    */
    boolean re = false;
    int ctr = 0;
  String [][] ar = new String[9][9];
    String [][] ar2 = new String[9][9];
    public String[][] populate(){
        // System.out.println(" 1 2 3 4 5 6 7 8 9 ");
        //  System.out.println();
        for (int i = 0; i < 9; i++) {
            //System.out.print(i);
           // ar[1][i] = String.valueOf(i);
            for (int j = 0; j < 9; j++) {
                //  if(i == y && j == x) {
                //    System.out.println(sym);
                //}
                //System.out.print(" ~ ");
                ar[i][j] = "~";
            }
            // System.out.println();

        }
        return ar;
    }
    public String[][] populate2(){
        // System.out.println(" 1 2 3 4 5 6 7 8 9 ");
        //  System.out.println();
        for (int i = 0; i < 9; i++) {
            //System.out.print(i);
            // ar[1][i] = String.valueOf(i);
            for (int j = 0; j < 9; j++) {
                //  if(i == y && j == x) {
                //    System.out.println(sym);
                //}
                //System.out.print(" ~ ");
                ar2[i][j] = "~";
            }
            // System.out.println();

        }
        return ar2;
    }

    public String[][] update(int x, int y, String sym, int size, String pos){
        if(pos.equals("v")) {
            for (int i = 0; i < size; i++) {
                if((x)*(y) > ar.length){
                    System.out.println("That position is invalid.");
                    re = true;
                    break;
                }
               if (ar[x -1][(y-1) + i].equals("c")) {
                    System.out.println("Carrier Ship is already standing there");
re = true;
                    break;
                }
                //try {
                    ar[(x-1) +i][y-1] = sym;
               re = false;
                //}catch(IndexOutOfBoundsException e){
                  //  System.out.println("That would go out of the range of ocean.");
                //}
            }
        }
        else if(pos.equals("h")){

            for (int i = 0; i < size; i++) {
                if((x)*(y) > ar.length){
                    System.out.println("That position is invalid.");
                    re = true;
                    break;
                }
                if (ar[x -1][(y-1) + i].equals("c")) {
                    System.out.println("Carrier Ship is already standing there");
                    re = true;
                    break;
                }
                ar[x-1][(y-1)+i] = sym;
                re =false;
            }
        }
return ar;
    }
    public void print(){
        System.out.println(" 1 2 3 4 5 6 7 8 9 ");
        for (int i = 0; i < 9; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < 9; j++) {
                System.out.print( ar[i][j] + " ");
            }
            System.out.println();
        }
    }
    public String[][] shoot(int x, int y){
      /*  for (int i = 0; i < 9; i++) {
            //System.out.print(i);
            ar2[1][i] = String.valueOf(i);
            for (int j = 0; j < 9; j++) {
                //  if(i == y && j == x) {
                //    System.out.println(sym);
                //}
                //System.out.print(" ~ ");
                ar2[i][j] = "~";
            }*/
            // System.out.println();

        //}
        if(ar[x -1][y -1 ].equals("c") || ar[x-1][y-1].equals("b")){
            ar2[x-1][y-1] = "x";
            System.out.println("You got it!");
            ctr++;
        }
        else{
            ar2[x -1][y -1] = "m";
            System.out.println("You missed!");
        }

        return ar2;
    }
public void print2(){
    System.out.println(" 1 2 3 4 5 6 7 8 9 ");
    for (int i = 0; i < 9; i++) {
        System.out.print(i+1 + " ");
        for (int j = 0; j < 9; j++) {
            System.out.print(ar2[i][j]+ " ");
        }
        System.out.println();
    }
}



}
