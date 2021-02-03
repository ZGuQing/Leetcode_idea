package lc_295;

import java.util.PriorityQueue;

/**
 * @author: Miguel
 * @date: 2021/2/3 8:47 下午
 * @description:
 */
public class MedianFinder {
    int count;
    int maxsize, minsize;
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0; maxsize = 0; minsize = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }
    public void addNum(int num) {
        count += 1;
        if(maxheap.isEmpty() || num <= maxheap.peek()) {
            maxheap.add(num);
            maxsize ++;
        } else {
            minheap.add(num);
            minsize ++;
        }
        if(maxsize > minsize + 1) { //大根堆数量比小根堆数量多2个
            minheap.add(maxheap.poll());
            maxsize --; minsize ++;
        } else if(minsize > maxsize) { //小根堆数量比大根堆多一个
            maxheap.add(minheap.poll());
            maxsize ++; minsize --;
        }
    }

    public double findMedian() {
        if((count & 1) != 0) return (double) maxheap.peek();
        else return (double) (maxheap.peek() + minheap.peek()) / 2;
    }
}
