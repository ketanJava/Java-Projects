import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("       Battleship Multiplayer      ");
        System.out.println("===================================");
        System.out.println();
        System.out.println("Enter Player 1 name:");


        Scanner s = new Scanner(System.in);
        String pl1 = s.nextLine();
        System.out.println("Enter Player 2 name:");
        //s Scanner s = new Scanner(System.in);
        String pl2 = s.nextLine();
        Board b1 = new Board();
        b1.populate();
        Board b2 = new Board();
        b2.populate();
        Carrier c = new Carrier();
        BattleShip bt =  new BattleShip();
        b1.print();

        System.out.println(pl1 +", please enter the x coordinate for your carrier ships");
        int x = s.nextInt();
        System.out.println(pl1 +", please enter the y coordinate for your carrier ships");
        int y = s.nextInt();
        System.out.println("Place horizontally or vertically (h or v)?");
        String in = s.next();
        b1.update(x,y, c.getSym(), c.getSize(), in);
        b1.print();


     do{
         System.out.println(pl1 +", please enter the x coordinate for your battle ships");
        x = s.nextInt();
        System.out.println(pl1 +", please enter the y coordinate for your battles ships");
        y = s.nextInt();
        System.out.println("Place horizontally or vertically (h or v)?");
        in = s.next();
        b1.update(x,y, bt.getSym(), bt.getSize(), in);}while (b1.re == true);
        b1.print();

        System.out.println("===============================");
        b2.print();
      System.out.println(pl2 +", please enter the x coordinate for your carrier ships");
         x = s.nextInt();
        System.out.println(pl2 +", please enter the y coordinate for your carrier ships");
         y = s.nextInt();
        System.out.println("Place horizontally or vertically (h or v)?");
        in = s.next();
        b2.update(x,y, c.getSym(), c.getSize(), in);

        b2.print();

        do{   System.out.println(pl2 +", please enter the x coordinate for your battle ships");
        x = s.nextInt();
        System.out.println(pl2 +", please enter the y coordinate for your battles ships");
        y = s.nextInt();
        System.out.println("Place horizontally or vertically (h or v)?");
        in = s.next();
        b2.update(x,y, bt.getSym(), bt.getSize(), in);}while (b2.re == true);
        b2.print();

        b1.populate2();
        b2.populate2();
      do {System.out.println("===============================");
          b2.print2();
          System.out.println(pl1 + ", enter the coordinates for battle:");
          System.out.println("x:");
          x = s.nextInt();
          System.out.println("y:");
          y = s.nextInt();
          b2.shoot(x, y);
          b2.print2();

          System.out.println("===============================");
          b1.print2();
          System.out.println(pl2 + ", enter the coordinates for battle:");
          System.out.println("x:");
          x = s.nextInt();
          System.out.println("y:");
          y = s.nextInt();
          b1.shoot(x, y);
          b1.print2();

          if(b1.ctr == 9){
              System.out.println(pl2 + " has won.");
              break;
          }
          if(b2.ctr == 9){
              System.out.println(pl1 + " has won.");
              break;
          }
      }while (b1.ctr < 9&& b2.ctr <9);



    }
}
