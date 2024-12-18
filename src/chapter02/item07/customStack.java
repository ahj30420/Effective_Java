package chapter02.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class customStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITAIL_CAPACITY = 16;

    public customStack() {
        elements = new Object[DEFAULT_INITAIL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 메모리 누수 발생
    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }
     */

    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }

}
