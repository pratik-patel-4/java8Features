package com.techinfinities.pnpcodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEachExample {

    public static void main(String[] args) {

        //creating simple Collection
        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            myList.add(i);
        }

        //traversing using Iterator
        Iterator<Integer> it = myList.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value ::: " + i);
        }

        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {
                System.out.println("For Each Anonymous class ::: " + integer);
            }
        });

        // traversing with consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);

    }

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println("Consumer Impl Value ::: " + integer);
    }
}