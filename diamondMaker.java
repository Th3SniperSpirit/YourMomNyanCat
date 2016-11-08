   import java.util.Scanner;
   public class diamondMaker
   {
      public static void main (String[] args)
      {
         Scanner hamster = new Scanner(System.in);
         System.out.println("Enter the number of lines you would like your diamond to be. (Should be an even number)");
         int size = hamster.nextInt();
         for (int a = size; a > 0; a -= 2)
         {
            for (int s = a - 1; s >= 0; s -= 2)
            {
               System.out.print(" ");
            }
            for (int g = a; g <= size; g++)
            {
               System.out.print("*");
            }
            System.out.println("");
         }
         for (int q = 0; q < size - 1; q += 2)
         {
            for (int w = 0; w < size + 1; w += 2)
            {
               System.out.print(" ");
            }
            for (int e = q + 4; e <= size; e++)
            {
               System.out.print("*");
            }
            System.out.println("");
         }
      }
   
   }