import java.util.HashMap;

public class RodCutting{
    public static void main(String args[]){
        int[] _prices = new int[15];
        _prices[2] = 5;
        _prices[8] = 15;
        _prices[3] = 9;
        _prices[12] = 40;
        if(CutRod(48, _prices) == 160) System.out.println("T1 Passed");
        if(CutRod(58, _prices) == 188) System.out.println("T2 Passed");
        if(CutRod(33, _prices) == 107) System.out.println("T3 Passed");
        if(CutRod(153, _prices) == 587) System.out.println("T3 Passed");

        System.out.println("Finished 3 tests");

    }

    public static HashMap<Integer,Integer> cuts = new HashMap<Integer,Integer>();

    public static int CutRod(int TotLen, int[] prices){
        int outProfit = 0;
        if(cuts.containsKey(TotLen)) return cuts.get(TotLen);
        for (int i = 0; i < prices.length; i++) {
            int TotProfit = 0;
            if(prices[i] != 0 && TotLen-i >= 0){
                TotProfit += prices[i] + CutRod(TotLen-i, prices);
            }
            outProfit = Math.max(outProfit, TotProfit);
            cuts.put(TotLen,outProfit);
        }
        return outProfit;
    }
}