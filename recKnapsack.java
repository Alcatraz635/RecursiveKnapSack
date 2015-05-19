/*
 * Tyler Schumacher
 */
class recKnapsack 
{
    static int value[] = {5, 15, 20, 32};
    static int weight[] = {7, 10, 4, 7};
    final static int M = 20;
    static int[][] F = new int[2][M+1];
    static int[][] I = new int[M+1][M+1];
    public static void main(String[] args) throws Exception 
    {
        for(int i = 0; i < M+1; i++)
        {
            int x = 0;
            F[0][i] = i;
            x = F[1][i] = recKnapSack(value.length-1, i);
            knapSackItems(x, value, i);
        }
        System.out.println("Maximum value Table (recursive)");
        for (int[] rows : F) 
        {
            for (int col : rows) 
            {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        System.out.println("Number of Each Item for Optimal Solution Table (recursive)");
        System.out.println("           M=0   M=1   M=2   M=3  M=4  M=5  M=6 M=7 M=8  M=9  M=10 M=11 M=12 M=13 M=14 M=15 M=16 M=17 M=18 M=19 M=20");
        int count = 0;
        
        for (int[] rows : I) 
        {
            System.out.print("Object " + (count+1));
            for (int col : rows) 
            {
                System.out.format("%5d", col);
            }
            System.out.println();
            count++;
            if(count == 4)
            {
                break;
            }
        }
        for(int i = 17; i <= 20; i++)
        {
            System.out.println("k = " + (i));
            for(int m = 0; m <= 4; m++)
            {
                System.out.println("Object " + m + " = " + I[m][i]);
            }
        }
    }
    private static int recKnapSack(int x, int y) 
    {
        if (x < 0) 
        {
            return 0;
        }
        if (weight[x] > y) 
        {
            return recKnapSack(x-1, y);
        } else 
        {
            return Math.max(recKnapSack(x-1, y), recKnapSack(x-1, y - weight[x]) + value[x]);
        }
    }
    static void knapSackItems(int i, int val[], int M)
    {
            for(int y = 3; y >= 0; y--)
            {
              int count = 0;
              while(i >= val[y])
              {
                 i = i - val[y];
                 count++;
              }
              I[y][M] = count;
            }
        }
    }
