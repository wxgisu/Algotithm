import java.util.*;
class MergeSort {
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] arr = new int[]{2, 5, 4, 6};
        int[] res = m.mergeSort(arr);
        for (int i : res) {
            System.out.println(i);
        }

    }

    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        //divide
        List<int[]> arrList = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            arrList.add(new int[]{arr[i]});
        }
        //merge
        while(arrList.size() != 1) {
            System.out.println(arrList);
            arrList = merge(arrList);
        }
        return arrList.get(0);
    }

    private List<int[]> merge(List<int[]> arrList) {
        List<int[]> mergedList = new ArrayList<>();
        int len = arrList.size();
        int pointer = 1;
        while(pointer <= len) {
            int[] mergedArr;
            if (pointer == len) {
                mergedArr = arrList.get(pointer - 1);
                continue;
            }
            int[] leftArr = arrList.get(pointer - 1);
            int[] rightArr = arrList.get(pointer);
            mergedArr = mergeRoutine(leftArr, rightArr);
            mergedList.add(mergedArr);
            pointer += 2;
        }
        return mergedList;
    }

    private int[] mergeRoutine(int[] left, int[] right) {
        int[] mergedArr = new int[left.length + right.length];
        int l = 0; //left pointer
        int r = 0; //right pointer
        int m = 0; //merged array pointer
        while(l < left.length && r < right.length) {
            mergedArr[m++] = (left[l] <= right[r]) ? left[l++] : right[r++];
        }
        while(l < left.length) {
            mergedArr[m++] = left[l++];
        }
        while(r < right.length) {
            mergedArr[m++] = right[r++];
        }
        return mergedArr;
    }
}