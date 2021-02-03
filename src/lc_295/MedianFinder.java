package lc_295;

import java.util.PriorityQueue;

/**
 * @author: Miguel
 * @date: 2021/2/3 8:47 下午
 * @description:
 */
public class MedianFinder {
    int count;
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if((count & 1) != 0) maxheap.add(minheap.poll());
    }

    public double findMedian() {
        if((count & 1) != 0) return (double) maxheap.peek();
        else return (double) (maxheap.peek() + minheap.peek()) / 2;
    }
}
