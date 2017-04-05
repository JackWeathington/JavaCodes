/*
 * Cubes a given value
 * 
 * written by Jack Weathington sep 2016
 */
public class TableCube extends TableFunction{

	public String getDescription()
	{
		return "The cube of x";
	}
	
	public double getValue(double x)
	{
		return x*x*x;
	}
	
	public String getName()
	{
		return "x^3";
	}
}
