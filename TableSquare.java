/*
 * squares a given value
 * 
 * written by Jack Weathington sep 2016
 */
public class TableSquare extends TableFunction{

	public String getDescription()
	{
		return "The square of x";
	}
	
	public double getValue(double x)
	{
		return x*x;
	}
	
	public String getName()
	{
		return "x^2";
	}
}
