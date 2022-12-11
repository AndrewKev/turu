package knapsack;


import java.util.Arrays;
import java.util.Comparator;

// Greedy approach
public class FractionalKnapSack {
     public static void main(String[] args)
    {
        double profits[] = {40.2,50.3,100.1,95.6,30.4};
        double weights[] = {2.2,3.2,2.1,5.0,3.9};
        double maxWeight = 10;    
        // Function calling and printing output
        System.out.println("Profit: "+knapsack(profits, weights, maxWeight, 0));
    }
    
    // Method returns maximum of a and b
    public static double max(double a, double b)
    {
        return a>b?a:b;
    }

    // Knapsack method definition
    public static double knapsack(double profits[], double weights[], double maxWeight, int item)
    {
        // Base case
        if(maxWeight==0 || item==profits.length)
        {
            return 0;
        }
        // If maxWeight exceeded then don't include the weight
        if(weights[item]>maxWeight)
        {
            return knapsack(profits, weights, maxWeight, item+1);
        }
        // Find profit by excluding weight and by including weight
        double includeW = knapsack(profits, weights, maxWeight-weights[item], item+1) + profits[item];
        double excludeW = knapsack(profits, weights, maxWeight, item+1);
        // Return maxmium among above results
        return max(includeW, excludeW);
    }
}