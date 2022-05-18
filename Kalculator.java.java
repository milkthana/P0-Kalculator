//Name:Thanatorn Prangsrithong
//ID:6188036
//Section:2
import java.util.ArrayList;

public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here 
	private ArrayList<Double> kalc= new ArrayList<>();
	private double sum;
	private double avg;
	private double std;
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	public Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		sum =0;
		avg =0;
		std =0;
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		kalc.add(number);
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(kalc.isEmpty())	
		{
			//do nothing
		}
		else 
		{
			kalc.remove(0);
		}
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(kalc.isEmpty())
		{
			//do nothing
		}
		else 
		{
			kalc.remove(kalc.size()-1);
		}
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		for(int i=0; i<kalc.size(); i++)
		{
			sum +=kalc.get(i);
		}
		if(kalc.size()==0)
		{
			return 0;
		}
			return this.sum;
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(this.kalc.size()==0) 
		{		
			return 0;
		}
		this.avg = this.sum/this.kalc.size();	
		return this.avg;
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		double top=0;
		double divisor = kalc.size()-1;
		double x=0;
		for(int i=0; i<this.kalc.size(); i++)
		{
			x=this.kalc.get(i)-this.avg;
			top += Math.pow(x,2);
		}
		
		double inner = top/divisor;
		std = Math.sqrt(inner);

		if(divisor==0 || kalc.isEmpty()) 
		{
			return 0;
		}
		return this.std;
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
			if(kalc.isEmpty()) 
			{
				return 0;
			}
			double max = this.kalc.get(0);
			for(int i=1; i<this.kalc.size(); i++)
			{
				if(max<=this.kalc.get(i))
				{
					max=this.kalc.get(i);
				}
			}
			return max;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
	 	if(kalc.isEmpty()) 
	 	{
			return 0;
	 	}
		double min = this.kalc.get(0);
		for(int i=1; i<this.kalc.size(); i++)
		{
			if(min>=this.kalc.get(i))
			{
				min=this.kalc.get(i);
			}
		}
   		return min;
   		//**************************************
	}
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		ArrayList<Double> tmpMax = new ArrayList<Double>();
		double[] maxk= new double[k] ;
		double max = tmpMax.get(0);
		int count = 0;
		int a = 0;
		for(int i=0;i<kalc.size();i++) 
		{
			tmpMax.add(kalc.get(i));
		}
	 	if(tmpMax.isEmpty()) 
	 	{
			return null;
	 	}
		for(int j=0;j<k;j++)
		{
			for(int i=tmpMax.size()-1; i>0;i--)
			{
			   if(max<tmpMax.get(i) )
			   {
					max = tmpMax.get(i);
					maxk[count] = max;
					a=i;
				}
			 }
			 if(maxk[j]==tmpMax.get(a)) 
			 {
				 tmpMax.remove(a);
				 if(tmpMax.isEmpty()) 
				 {
					return null;
				 }
				 max= tmpMax.get(0);
			 }
			count++;
		}
		return maxk;
	}
		//**************************************

	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		ArrayList<Double> tmpMin = new ArrayList<Double>();
		double[] mink = new double[k];
		double min= tmpMin.get(0);
		int count =0;
		int mx=0;
		
		for(int i=0;i<kalc.size();i++) 
		{
			tmpMin.add(kalc.get(i));
		}
		if(tmpMin.isEmpty()) 
		{
			return null;
		}
		for(int j=0;j<k;j++){
			for(int i=tmpMin.size()-1; i>=0;i--)
			{
			   if(min>=tmpMin.get(i) )
			   {
					min = tmpMin.get(i);
					mink[count] = min;
					mx=i;
				}
			 }
			 if(mink[j]==tmpMin.get(mx)) 
			 {
				 tmpMin.remove(mx);
				if(tmpMin.isEmpty()) 
				{
					return null;
				}
				 min= tmpMin.get(0);

			 }
			count++;
			}
		return mink;
	}
		//**************************************
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		System.out.println("DATA"+"["+kalc.size()+"]"+":"+this.kalc);
		//**************************************
	}
}
