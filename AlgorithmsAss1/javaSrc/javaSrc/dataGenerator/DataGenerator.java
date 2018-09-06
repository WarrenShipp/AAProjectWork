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
		int words = 50000;
	//	System.out.println("Enter file name: ");
		String fileName = "addremsea50000-40.in";
		Random ran = new Random();
		int count = 0;
		int addedWords = 0;
		int searchWords = 0;
		try
		{
			PrintWriter writer = new PrintWriter(new FileOutputStream(fileName), true);
			while(addedWords < words)
			{
				int number = ran.nextInt(40)+1;
				
				int num = ran.nextInt(3)+1;

				if(searchWords == 0)
				{
					num = 3;
				}
				switch(num)
				{
				case 1:
					data.add("a");
					addedWords++;
					searchWords = 0;
					break;
				case 2:
					data.add("ro");
					searchWords = 0;
					//addedWords++;
					break;
				case 3:
					data.add("s");
					searchWords = 1;
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
				case 21:
					data.add(" catx");
					break;
				case 22:
					data.add(" dogx");
					break;
				case 23:
					data.add(" fishx");
					break;
				case 24:
					data.add(" horsex");
					break;
				case 25:
					data.add(" goatx");
					break;
				case 26:
					data.add(" goosex");
					break;
				case 27:
					data.add(" chickenx");
					break;
				case 28:
					data.add(" lambx");
					break;
				case 29:
					data.add(" cowx");
					break;
				case 30:
					data.add(" elephantx");
					break;
				case 31:
					data.add(" camelx");
					break;
				case 32:
					data.add(" donkeyx");
					break;
				case 33:
					data.add(" monkeyx");
					break;
				case 34:
					data.add(" rhinox");
					break;
				case 35:
					data.add(" tiger");
					break;
				case 36:
					data.add(" lionx");
					break;
				case 37:
					data.add(" giraffex");
					break;
				case 38:
					data.add(" hippox");
					break;
				case 39:
					data.add(" zebrax");
					break;
				case 40:
					data.add(" roosterx");
					break;
				}
			}
			for(int i = 0; i < data.size(); i++)
			{
				
				if(count == 0)
				{
					writer.print(data.get(i));
					count++;
				}
				else
				{
					writer.println(data.get(i));
					count = 0;
				}
				//System.out.println(data.get(i));
			}
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("Invalid file");
		}
	}

}
