public class HouseThief {
    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] houseVals = {20, 5, 1, 13, 6, 11, 40};
        int res = ht.maxValRecursive(houseVals);
        System.out.println(res);
    }

    public int maxVal(int[] houseVals) {
        int res = 0;
        int numHouses = houseVals.length;
        if (houseVals == null || numHouses == 0) 
            return res;

        int[] maxArr = new int[numHouses];
        maxArr[0] = maxArr[1] = Math.max(houseVals[0], houseVals[1]);

        for (int i=2; i<numHouses; i++) {
            maxArr[i] = Math.max(maxArr[i-1], maxArr[i-2] + houseVals[i]);
            res = maxArr[i];
        }
        return res;
    }

    public int maxValRecursive(int[] houseVals) {
        int res = 0;
        int curIndex = 0;
        res = maxValRecursive(houseVals, curIndex);
        return res;
    }

    private int maxValRecursive(int[] houseVals, int curIndex) {
        if (curIndex > houseVals.length-1) return 0;
        
        int max = Math.max(houseVals[curIndex] + maxValRecursive(houseVals, curIndex+2),
                           maxValRecursive(houseVals, curIndex+1));

        return max;
    }
}