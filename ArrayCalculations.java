

public class ArrayCalculations
{
	public static void main(String[] args)
	{
		int[] array = new int[20];
		for(int i = 0; i < 20; i++)
		{
			array[i] = (int)(Math.random() * 499 + 1);
			System.out.print(array[i] + ", ");
		}
		int sum = 0;
		for(int x = 0; x < array.length; x++)
		{
			sum += array[x];
		}
		System.out.println("\n" + "The sum of the array is: " + sum);
		System.out.println("The average of the array is: " + sum / array.length);
		int min = array[0];
	 	for (int x = 0; x < array.length; x++)
		{
			if (array[x] < min) 
			{
				min = array[x];
			}
		}
		System.out.println("The minimum value is: " + min);
		int max = array[0];
	 	for (int x = 0; x < array.length; x++)
		{
			if (array[x] > max) 
			{
				max = array[x];
			}
		}
		System.out.println("The maximum value is: " + max);
	}
}