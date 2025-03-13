package DesignPatterns.Behavioural.DIY.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

interface IIterator{
    boolean hasNext();
    String next();
    
}

class ListIterator implements IIterator{
    private List<String> items;
    private int index;
    
    public ListIterator(List<String> items){
        this.items = items;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return (index < items.size());
    }

    @Override
    public String next() {
        if(hasNext()){
            return items.get(index++);
        }else{
            throw new NoSuchElementException("List is empty.");
        }
    }
    
}

class Checklist{
    private List<String> items;

    public Checklist() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item){
        items.add(item);
    }
    public void removeItem(String item){
        items.remove(item);
    }
    public ListIterator getIterator(){
        return new ListIterator(items);
    }
}

public class Iterator {
    public static void main(String[] args) {

        Checklist checklist = new Checklist();

        checklist.addItem("Prepare breakfast");
        checklist.addItem("Wash the dishes.");
        checklist.addItem("Do laundry.");

        ListIterator iterator = checklist.getIterator();

        System.out.println("Chores for the day: ");
        while(iterator.hasNext()){
            String item = iterator.next();
            System.out.println("+  " + item);
        }
        
    }
}