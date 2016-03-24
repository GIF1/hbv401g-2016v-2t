
import java.io.*;
import java.util.*;
public class printtest {

public static void printReceipt() {
		// Figure out how to print information to pdf documents. 

	       try {
		    String text = "Afhverju heita tveir hópameðlimir Gunnar? Er allur frumleiki horfinn úr heiminum? \nNei mér er bara spurn.";
		    BufferedWriter out = new BufferedWriter(new FileWriter("MyTrip.txt"));
		    out.write(text);
		    out.close();
		}
		catch (IOException e)
		{
		    System.out.println("Exception ");       
		}

		return ;
	}

	public static void main(String[] args){

	printReceipt();
	}
}
