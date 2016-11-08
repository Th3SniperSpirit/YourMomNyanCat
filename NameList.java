   import java.util.Scanner;

   public class NameList
   {
      public static void main(String[] args)
      {
         String[] names = new String[10];
         names[0] = "Hermione";
         names[1] = "Harry";
         names[2] = "Ron";
         names[3] = "Dumbledore";
         names[4] = "";
         names[5] = "";
         names[6] = "";
         names[7] = "";
         names[8] = "";
         names[9] = "Snape";
      
      
         System.out.println(names[9]); //part a.
      
         for(int i = 9; i >= 0; i--) //part b.
         {
            if (names[i].length() > 0)
            {
               System.out.println(names[i]);
            }
         }
      
      
         String[] names2 = new String[10]; //part e.
         names2[0] = names[0];
         names2[1] = names[1];
         names2[2] = names[2];
         names2[3] = names[3];
         names2[9] = names[9];
      
         Scanner scan = new Scanner(System.in);//part e.
      
         System.out.println("Enter 5 names: ");
      
         for(int i = 4; i < 9; i++)
         {
         
            names2[i] = scan.nextLine();
         
         }
      
         System.out.println("Random name generator: " + names2[(int)(Math.random() * 9 + 1)]); //part f.
         int count = 1;
         for(int i = 0; i < 10; i++) //part g.
         {
            System.out.println(count + ")" + names2[i]);
            count++;
         }
			String[] names3 = new String[5]; //part h. 
			System.out.println("Enter 5 new names.");
			names3[0] = scan.nextLine();
			names3[1] = scan.nextLine();
			names3[2] = scan.nextLine();
			names3[3] = scan.nextLine();
			names3[4] = scan.nextLine();
			double avlength = 0;
         for (int x = 0; x < names3.length; x++)
         {
         	avlength += names3[x].length();
         }
      System.out.println("The average length of the names you entered is: " + (avlength / names3.length));
      
      }
   }