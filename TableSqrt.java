/*
 * Square root function class for TableMaker
 * 
 * 
 */
public class TableSqrt extends TableFunction
{
	public String getDescription()
	{
		return "The square root of x";
	}
	
	public double getValue(double x)
	{
		return Math.sqrt(x);
	}
	
	public String getName()
	{
		return "sqrt(x)";
	}

}
