/*
 * General function class for TableMaker
 * 
 * 
 */
public abstract class TableFunction
{
	public String getDescription()
	{
		// If there's no description, just display
		// the name.
		return "Function named "+getName();
	}
	
	public abstract double getValue(double x);
	
	public abstract String getName();

}