package deque;

public class LinkedListDeque <T>{
    public class node<T>{
        public T item;
        public node<T> next;
        public node<T> previous;
        public node(node<T> p,T i,node<T> n){
            previous = p;
            item = i;
            next = n;
        }
    }

    public int size;
    public node<T> sentinal;
    public LinkedListDeque(){
        sentinal = new node(null,null,null);
        sentinal.next = sentinal;
        sentinal.previous = sentinal;
        size = 0;
    }
    public void addFirst(T item){
        node<T> news = new node(sentinal,item,sentinal.next);
        sentinal.next.previous = news;
        sentinal.next = news;
        size+=1;

    }
    public void addLast(T item){
        node<T> news = new node(sentinal.previous,item,sentinal);
        sentinal.previous.next=news;
        sentinal.previous = news;
        size+=1;
    }
    public T get(int index){
        if(index>size){
            return null;
        }
        node<T> p =sentinal.next;
        for(int i=1;i<=index;i++){
            p = p.next;
        }
        return p.item;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public T getRecursive(int index){
        if( index>size || index<=0 ){
            return null;
        }
        node<T> p = sentinal.next;
        return help(index,p);
    }
    public T help(int index,node<T> ptr){
        if(index==1){
            return ptr.item;
        }
        return help(index-1,ptr.next);
    }
    public void removeFirst(){
        if(isEmpty()){
            return;
        }
        sentinal.next.next.previous = sentinal;
        sentinal.next = sentinal.next.next;
        size = size-1;
    }
    public void removeLast(){
        if(isEmpty()){
            return;
        }
        sentinal.previous.previous.next=sentinal;
        sentinal.previous=sentinal.previous.previous;
        size=size-1;
    }
    public void print(){
        if(size==0){
            return;
        }
        node<T> p =sentinal.next;
        while(p.next!=sentinal){
            System.out.print(p.item);
            System.out.print(" ");
            p=p.next;
        }
    }
}
