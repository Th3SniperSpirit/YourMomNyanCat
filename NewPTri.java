   import java.util.Scanner;

   class NewPTri
   {
      public static void main (String[] args)
      {
         Scanner hamster = new Scanner(System.in);
         System.out.println("Enter the number of lines you would like your pyramaid to be.");
         int size = hamster.nextInt();
         for (int a = size * 2; a > 0; a -= 2)
         {
            for (int s = a - 1; s >= 0; s -= 2)
            {
               System.out.print(" ");
            }
            for (int g = a; g <= size * 2; g++)
            {
               System.out.print("*");
            }
            System.out.println("");
         }
      }
   }