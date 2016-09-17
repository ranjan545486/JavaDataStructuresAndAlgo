package LinkedInQuestions.Graphs;

import java.util.List;

/**
 * Created by rmukherj on 8/23/16.
 */
interface NestedInteger {
    // Returns true if this NestedInteger holds a single integer, rather than a nested list
    public boolean isInteger();

    // Returns the single integer that this NestedInteger holds, if it holds a single integer
// Returns null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Returns the nested list that this NestedInteger holds, if it holds a nested list
// Returns null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}





    public class NestedListIntegers implements NestedInteger{
        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }



        private static int GetSum(NestedInteger item, int weight) {
            if (item.isInteger()) {
                return (int) item.getInteger() * weight;
            } else {
                int sum = 0;
                List<NestedInteger> list = item.getList();
                for (NestedInteger subItem : list) {
                    if (subItem.isInteger())
                        sum += GetSum(subItem, weight);
                    else
                        sum += GetSum(subItem, weight + 1);
                }

                return sum;
            }
        }



    }

//    import java.util.ArrayList;
//            import java.util.List;
//            import java.util.ListIterator;
//
//public class FindSumByListFlattening {
//    @SuppressWarnings("unchecked")
//    public static int findSumByDepth(ArrayList<Object> inputList) {
//        int sum = 0;
//        int currentElementDepth = 1;
//        ListIterator<Object> listIterator = inputList.listIterator();
//        int currentPosition = 0;
//        int resetPoint = 0;
//        ArrayList<Object> tempList;
//        while (listIterator.hasNext()) {
//            Object i = listIterator.next();
//            if (!(i instanceof List)) {
//                if (resetPoint % 2 == 0)
//                    currentElementDepth = 1;
//                else
//                    resetPoint++;
//                sum += (currentElementDepth * (int) i);
//                currentPosition++;
//
//            } else {
//                tempList = (ArrayList<Object>) i;
//                listIterator.remove();
//                currentElementDepth++;
//                resetPoint++;
//                for (Object obj : tempList) {
//                    listIterator.add(obj);
//                }
//            }
//            listIterator = inputList.listIterator(currentPosition);
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        ArrayList<Object> inputList = new ArrayList<Object>();
//        ArrayList<Object> List1 = new ArrayList<Object>();
//        inputList.add(1);
//        List1.add(4);
//        ArrayList<Object> List2 = new ArrayList<Object>();
//        List2.add(6);
//        List1.add(List2);
//        inputList.add(List1);
//        // inputList.add(4);
//        for (Object obj : inputList) {
//            System.out.print(obj + " ");
//        }
//        System.out.println("Sum: " + findSumByDepth(inputList));
//    }
//
//}
