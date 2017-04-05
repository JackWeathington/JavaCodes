import java.util.Scanner;

/*
 * Main driver class for COSC1020 Lab, Sep 8, 2016
 *
 * Create a table of numeric function values with
 * a choice of functions to display
 *
 * modified by Jack Weathington sep 2016
 */
public class TableMaker
{
	
	static Scanner kb = new Scanner(System.in);
	
	////////////Enter new functions here://////////////
	static TableFunction[] functionList = {
		new TableSqrt(),
		new TableSquare(),
		new TableCube(),
	};
	///////////////////////////////////////////////////
	static final int MAX_COLS = 5;
	static TableFunction[] tableList = new TableFunction[MAX_COLS];
	static int fcol; // number of function columns in table
	
	static double startVal;
	static double endVal;
	static double incrementAmount; //variables for controlling which numbers get run by the program
	
	public static void main(String[] args)
	{
		chooseNumbers();
		getColumnChoices();
		// Somewhere in here (before displayTable()) we
		// should ask the user for the x-values start,
		// end and increment.
		displayTable();
	}

	static void chooseNumbers(){
		System.out.println("What would you like the starting value to be?");
		startVal= Double.parseDouble(kb.next());
		System.out.println("What would you like to increment by?");
		incrementAmount= Double.parseDouble(kb.next());
		System.out.println("At what value would you like to end?");
		endVal= Double.parseDouble(kb.next());
	}
	
	static void getColumnChoices()
	{
		boolean notDone = true;
		fcol = 1;
		do
		{
			// show list
			System.out.println("Function choices:");
			for (int i = 0; i < functionList.length; i++)
			{
				System.out.println(""+i+": "+functionList[i].getDescription());
			}
			System.out.print("\nWhich function do you want for column "+fcol+"? ");
			int choice = kb.nextInt();
			tableList[fcol-1]= functionList[choice];
			fcol++;
			if (fcol > MAX_COLS)
			{
				notDone = false;
			}
			else
			{
				System.out.print("Do you want another column (yes/no)? ");
				String resp = kb.next();
				if (resp.toLowerCase().startsWith("n"))
				{
					notDone = false;
				}
			}

		} while (notDone);
		fcol--; //adjust to correct count
	}

	static void displayTable()
	{
		System.out.print("      x    |");
		for (int c = 0; c < fcol; c++)
		{
			System.out.format("%10s |", tableList[c].getName());
		}
		System.out.println();
		for (int c = 0; c <= fcol; c++)
		{
			System.out.print("------------");
		}
		System.out.println();
		for (double x = startVal; x <= endVal; x += incrementAmount)
		{
			System.out.format("%10.4g |", x);
			for (int c = 0; c < fcol; c++)
			{
				System.out.format("%10.4g |", tableList[c].getValue(x));
			}
			System.out.println();
		}
	}

}