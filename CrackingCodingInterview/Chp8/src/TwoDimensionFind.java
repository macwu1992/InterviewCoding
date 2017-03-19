public class TwoDimensionFind {
    public boolean Find(int target, int [][] array) {
        int n = array.length-1;
        int m = array[0].length-1;

        if (array == null || n <= 0 || m <= 0){
            return false;
        }

        if (target < array[0][0] || target > array[n][m]) {
            return false;
        }

        for (int i = 0; i <=n; i++){
            if (oneDimensionFind(target, array[i])){
                return true;
            }
        }

        return false;

    }

    public boolean oneDimensionFind(int target, int [] array) {
        int begin = 0;
        int end = array.length-1;
        int mid = (begin + end)/2;

        while (begin <= end){
            mid = (begin + end)/2;
            if (target > array[mid]){
                begin = mid+1;
            } else if(target < array[mid]){
                end = mid-1;
            }else if(target == array[mid]){
                return true;
            }
        }

        return false;
    }
}