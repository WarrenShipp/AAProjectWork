package dataGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataGenerator
{
	static ArrayList<String> data = new ArrayList<String>();
	Random rand;
	
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		//System.out.println("Enter number of words: ");
		int words = 10;
	//	System.out.println("Enter file name: ");
		String fileName = "test.in";
		Random ran = new Random();
		
		try
		{
			PrintWriter writer = new PrintWriter(new FileOutputStream(fileName), true);
			for(int i = 0; i < words; i++ )
			{
				int number = ran.nextInt(20)+1;
				System.out.println(number);
				int num = ran.nextInt(2)+1;
				switch(num)
				{
				case 1:
					data.add("a");
					break;
				case 2:
					data.add("ro");
					break;
				}
				switch(number)
				{
				case 1:
					data.add(" cat");
					break;
				case 2:
					data.add(" dog");
					break;
				case 3:
					data.add(" fish");
					break;
				case 4:
					data.add(" horse");
					break;
				case 5:
					data.add(" goat");
					break;
				case 6:
					data.add(" goose");
					break;
				case 7:
					data.add(" chicken");
					break;
				case 8:
					data.add(" lamb");
					break;
				case 9:
					data.add(" cow");
					break;
				case 10:
					data.add(" elephant");
					break;
				case 11:
					data.add(" camel");
					break;
				case 12:
					data.add(" donkey");
					break;
				case 13:
					data.add(" monkey");
					break;
				case 14:
					data.add(" rhino");
					break;
				case 15:
					data.add(" tiger");
					break;
				case 16:
					data.add(" lion");
					break;
				case 17:
					data.add(" giraffe");
					break;
				case 18:
					data.add(" hippo");
					break;
				case 19:
					data.add(" zebra");
					break;
				case 20:
					data.add(" rooster");
					break;
				}
			}
			for(int i = 0; i < data.size(); i++)
			{
				writer.print(data.get(i));
				System.out.println(data.get(i));
			}
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("Invalid file");
		}
	}

}
