/** 
 * Partial sums approximation for generic series.
 * @author Thomas Nguyen
 * @version 1.0
 */

/*
 * Limitations: It is obvious that the Gregory-Leigniz is not a great method of approximating
 * pi as it converges too slowly. In the future, I will explore better high-performance series.
 */
public class SeriousSeries 
{
	// We will look at the geometric series x^n from n = 0 to N
	// where N is the last term of the partial sum
	
	// Assuming the series is centered about 0
	
	// NOTE: The closed form for the geometric series x^n is 1 / (1 - x)
	// Meaning the series can be modified to represent arctan(x).
	// Namely, the integral of 1 / ( 1 + x^2 ) = arctan(x) 
	// = (-1)^n * x ^ (2n + 1) / (2n + 1)
	
	// In this way, it possible to approximate pi by way of 
	// 4 * arctan(1) = 4 * pi/4 = pi
	public static void main(String[] args)
	{
		// Comparing the approximation by examing the value of pi where the upper bound
		// varies by powers of 10
		
		for (int upperBound = 10; upperBound <= Math.pow(10, 7); upperBound *= 10)
		{
			double piValue = piApproximation(upperBound);
			System.out.println("Using the partial sums approximation of the Gregory-Leibniz series for pi with " 
					+ upperBound + " terms: " + piValue);
		}
	}
		
		/**
		 * Calculate an approximation of pi based on a given upper bound.
		 * @param upperBound the last term of the partial sum
		 * @return the approximation for pi
		 */
		public static double piApproximation(int upperBound)
		{
		final double four = 4.0;
		int x = 1;
		int lowerBound = 0;
		
		double sum = 0;
		
		// Adding the partial sums from lowerBound to upperBound
		for (int n = lowerBound; n <= upperBound; n++)
		{
			sum += (double)Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / (2 * n + 1);
		}
		
		// The series approximates pi/4 so multiplying by 4 results i pi
		return four * sum;
	}
}
