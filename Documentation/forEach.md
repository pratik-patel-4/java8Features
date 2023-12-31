
Whenever we need to traverse through a Collection, we need to create an iterator whose whole purpose is to iterator over, and then we have business logic in a loop for each of the elements in the Collection. We might get  ConcurrentModificationException if the iterator is not used properly.

Java 8 has introduced forEach method in java.lang.iterable.interface so that while writing code we focus on business logic. The forEach method takes java.util.function.Consumer object as an argument, so it helps in having our business logic at a separate location that we can reuse. Let's see forEach usage with a simple example.


```
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
```

The number of lines might increase but forEach method helps in having the logic for iteration and business logic at separate place resulting in higher separation of concern and cleaner code
