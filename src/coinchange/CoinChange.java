/**
 *
 * @author Brent Parish
 * CoinChange uses dynamic programming to solve i,j coin change problem
 * 
 * For Denom[0] = 10 Denom[1] = 6 and Denom[2] = 12
 * the following array C[i][j] should be created:
 * i | j
 *   | 0 1 2 3 4 5 6 7 8 9 10 11 12
 * --------------------------------
 * 0 | 0 1 2 3 4 5 1 2 3 4 1  2   2
 * 1 | 0 1 2 3 4 5 1 2 3 4 5  6   2
 * 2 | 0 1 2 3 4 5 6 7 8 9 10 11 12
 */

package coinchange;


public class CoinChange 
{

    private static Integer[][] C;
    private static Integer A;
    private static Integer[] denom;
    private static Integer last;
    
    public static void main(String[] args) 
    {
        //Setup Variables
        C = new Integer[3][13];
        denom = new Integer[3];
        A = 13;
        denom[0] = 10;
        denom[1] = 6;
        denom[2] = 12;
        last = 2;
        
        dynamic_coin_change();
        
    }
    
    //Find the smallest amount of coins for an amount j when the available 
    //denominations are i.    
    private static void dynamic_coin_change()
    {
        Integer n = last;
        
        for (int j = 0; j < A; j++)
        {
            C[n][j] = j;
        }
        
        printC();
        
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = 0; j < A; j ++)
            {
                if (denom[i] > j || C[i+1][j] < (1 + C[i][j - denom[i]]))
                {
                    C[i][j] = C[i + 1][j];
                }
                else
                {
                    C[i][j] = 1 + C[i][j - denom[i]];
                }
            }
            
            printC();
        }
        
    }
    
    //Print Out Array C
    private static void printC()
    {
        Integer n = last;
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("\nArray C:");
        System.out.println("i | j");
        System.out.println("--------------------------");
        for (int i = 0; i <= n; i ++)
        {
            System.out.print(i+" | ");
            for (int j = 0; j < A; j ++)
            {
                System.out.print(C[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    
}
