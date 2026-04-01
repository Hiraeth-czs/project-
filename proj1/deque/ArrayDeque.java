package deque;

import java.util.Comparator;

public class ArrayDeque<E> {
    private int size;
    public int first;
    public int last;
    public E[] array;
    public int capacity;
    public ArrayDeque(){
        array = (E[]) new Object[8];
        size = 0;
        first = 3;
        last=4;
    }
    private boolean isfull(){
        return size==capacity;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private void resize(){
        if (isfull()){
            E[] news = (E[]) new Object[4*size];
            System.arraycopy(array,0,news,size+1,size);
            array = news;
            first = size;
            last = 2*size;
            capacity = 4*size;
        }
        if (4*size<capacity){
            E[] news = (E[]) new Object[4*size];
            int index = first%capacity;
            for(int i= 1;i<=size;i++){
                news[i] = array[index+1];
                index = (index+1)%capacity;
            }
            array = news;
            first = 0;
            last = size+1;
            capacity = 4*size;
        }
    }
    public int size(){
        return size;
    }
    private E get(int index){
        int i = (first+index+1)%capacity;
        return array[i];
    }
    public void addFirst(E item){
        resize();
        array[first] = item;
        first = (first-1)%capacity;
    }
    private void addLast(E item){
        resize();
        array[last] = item;
        last = (last+1)%capacity;
    }
    private E removeFirst(E item){
        E x =array[(first+1)%capacity];
        first = (first+1)%capacity;
        size--;
        resize();
        return x;
    }
    private E removeLast(E item){
        E x =array[(last-1)%capacity];
        first = (last-1)%capacity;
        size--;
        resize();
        return x;
    }
    public void printDeque() {
        int index = (first+1)%capacity;
        while (index != last) {
            System.out.print(array[index]);
            System.out.print(" ");
            index = (index + 1) % capacity;
        }
        System.out.println();
    }
}
