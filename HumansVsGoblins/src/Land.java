import java.util.ArrayList;

public class Land {
   int width = 10;
   int height = 10;
   String symbol = "$";
    ArrayList<String> grid = new ArrayList<>();

   @Override
    public String toString(){

       return "Land has height: " + height + " and width: "+ width +" and is represented by: " + symbol;
}
}