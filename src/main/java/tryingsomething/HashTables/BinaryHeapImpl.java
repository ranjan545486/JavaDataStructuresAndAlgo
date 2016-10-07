package tryingsomething.HashTables;
import java.util.NoSuchElementException;

/**
 * Created by rmukherj on 10/6/16.
 */
class BinaryHeap
{
    private static final int d = 2;
    private int heapSize;
    private int[] heap;

    public BinaryHeap(int capacity)
    {
        heapSize = 0;
        heap = new int[capacity + 1];
    }

    public boolean isEmpty( )
    {
        return heapSize == 0;
    }

    public boolean isFull( )
    {
        return heapSize == heap.length;
    }

    public void makeEmpty( )
    {
        heapSize = 0;
    }

    private int parent(int i)
    {
        return (i - 1)/d;
    }

    private int kthChild(int i, int k)
    {
        return d * i + k;
    }

    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("OverFlow : Heap is full");
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow: Heap is empty");
        return heap[0];
    }

    public int deleteMin()
    {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }

    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);
        return keyItem;
    }

    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }
        heap[childInd] = tmp;
    }

    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    private int minChild(int ind)
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize))
        {
            if (heap[pos] < heap[bestChild])
                bestChild = pos;
            pos = kthChild(ind, k++);
        }
        return bestChild;
    }

    public void printHeap()
    {
        System.out.println("Heap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }
}
public class BinaryHeapImpl {
    public static void main(String[] args)
    {
        BinaryHeap bh = new BinaryHeap(6);
        bh.insert(3);
        bh.insert(2);
        bh.insert(1);
        bh.insert(8);
        bh.insert(5);
        System.out.println("Min Element :-"+bh.findMin());
        bh.printHeap();
        bh.deleteMin();
        System.out.println("Min Element :-"+bh.findMin());
        bh.printHeap();
    }
}
