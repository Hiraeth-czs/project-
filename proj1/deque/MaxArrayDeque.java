package deque;

import java.util.Comparator;
import java.util.Iterator;

import static jdk.internal.lang.stable.StableUtil.array;


public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> defaultcom;
    public MaxArrayDeque(Comparator<T> c){
        super();
        this.defaultcom = c;
    }
    public T max(){
        return max(defaultcom);
    }
    public T max(Comparator<T> c){
        if(isEmpty()){
            return null;
        }
        int index = (first+1)%capacity;
        T maxm =(T) array(index);
        for(int i=0;i<this.size();i++){
            int index2 = (index+1)%capacity;
            if(c.compare(array[index],array[index2])<0){
                maxm = (T) array(index2);
            }
        }
        return maxm;
    }
}