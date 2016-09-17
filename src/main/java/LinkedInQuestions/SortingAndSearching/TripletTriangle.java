package LinkedInQuestions.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by rmukherj on 8/18/16.
 */
interface Triangle {

        /**
         * Three segments of lengths A, B, C form a triangle iff
         *
         *      A + B > C
         *      B + C > A
         *      A + C > B
         *
         * e.g.
         *  6, 4, 5 can form a triangle
         * 10, 2, 7 can't
         *
         * Given a list of segments lengths algorithm should find at least one triplet of
         * segments that form a triangle (if any).
         *
         * Method should return an array of either:
         * - 3 elements: segments that form a triangle (i.e. satisfy the condition above)
         * - empty array if there are no such segments
         */

        int[] getTriangleSides(int[] segments);
}

class TriangleImpl implements Triangle{

    private int[] array;
    private int[] tempMergeArr;
    private int length;

    @Override
    public int[] getTriangleSides(int[] segments) {
        mergesort(segments);
        int i, j, k;

        i = 0;
        j = 1;
        k = 2;

        for (k = 2; k < segments.length; k++) {

            if (isTriplet(segments[i++], segments[j++], segments[k])) {

                return segments;
            }
        }

        return segments;
    }

    public boolean isTriplet(int a, int b, int c) {

        boolean first, second, third;

        first = ((a + b) > c);
        second = ((a + c) > b);
        third = ((c + b) > a);

        return (first && second && third);
    }

    private void mergesort(int arr[]){
        this.array = arr;
        this.length = arr.length;
        this.tempMergeArr = new int[length];
        doMergeSort(0,length-1);
    }

    private void doMergeSort(int low, int high){
        if(low<high){
            int middle = low+(high-low)/2;
            doMergeSort(low, middle);
            doMergeSort(middle+1, high);
            mergeParts(low,middle,high);
        }
    }

    private void mergeParts(int low, int middle, int high){
        for(int i=low;i<=high;i++){
            tempMergeArr[i]=array[i];

        }

        int i=low;
        int j= middle+1;
        int k = low;
        while(i<=middle && j<=high){
            if(tempMergeArr[i]<=tempMergeArr[j]){
                array[k] = tempMergeArr[i];
                i++;
            } else {
                array[k]= tempMergeArr[j];
                j++;
            }
            k++;
        }
        while(i<=middle){
            array[k] = tempMergeArr[i];
            k++;
            i++;
        }
    }



    public ArrayList<Vector> getTriangleSides3(int[]segments)
    {
        int[]elements=segments;
        ArrayList<Vector> triplet=new ArrayList<Vector>();
        if(elements.length<3)
        return triplet;
        else
        {
            quickSort(elements, 0, elements.length-1);
            //mergesort(segments);
            for(int i=0;i<elements.length-2;i++)
            {
                if(elements[i]+elements[i+1]>elements[i+2])
                {
                    Vector vector=new Vector(3);
                    vector.add(elements[i]);
                    vector.add(elements[i+1]);
                    vector.add(elements[i+2]);
                    triplet.add(vector);
                }
            }
            return triplet;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

    /*
    Bruteforce way
     */
    static private List<int[]> GetAllCombinationsOfTriplets( int[] arr ) {

        List<int[]> res = new ArrayList<int[]>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {

                    int a = arr[ i ], b = arr[ j ], c = arr[ k ];

                    if ( a + b > c && b + c > a && c + a > b ) {
                        res.add( new int[] { a, b, c } );
                    }

                }
            }
        }
        return res;
    }

    //================different solution==============
    private static void printarri(int str[]) {
        for (int i = 0; i < str.length; i++)
            System.out.print("" + str[i] + " ");
        System.out.println("");
    }

    private static String arrKey(int str[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++)
            sb.append(str[i]);
        return sb.toString();
    }

    //Unique triplets
    private static HashMap memo = new HashMap();
    private static int NO_VALUE = -1;
    public static void findTriplet(int a[], int idx, int k, int r[]) {
        if (memo.containsKey(arrKey(r))) return;

        if (r[2] >= 0) {
            memo.put(arrKey(r), r);
            printarri(r);
            return;
        }

        if (idx > a.length - 1) return;

        if (r[k] == NO_VALUE) {
            r[k] = a[idx];
            findTriplet(a, idx + 1, k + 1, r);
            r[k] = NO_VALUE;
            findTriplet(a, idx + 1, k, r);
        }
    }
    //==============end different solution============

    public static void main(String a[]){

        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        TriangleImpl mms = new TriangleImpl();
        mms.mergesort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println("");

        int[] ab = {2,3,64,5,21,18,20};
        int[] x = mms.getTriangleSides(ab);
        //int[] y = mms.getTriangleSides(ab);
        ArrayList<Vector> y = mms.getTriangleSides3(ab);
//        for(int s: x){
//            System.out.println(s);
//        }

       for(int i=0;i<y.size();i++){
           System.out.println(y.get(i));
       }

       List<int[]> getAllTriplets = GetAllCombinationsOfTriplets(ab);
        for (int[] backup:
              getAllTriplets) {
            for (int i = 0; i < backup.length; i++) {
                System.out.print(backup[i]);
            }
            System.out.println("");

        }
    }
}
