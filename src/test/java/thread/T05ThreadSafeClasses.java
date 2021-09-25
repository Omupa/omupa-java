package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeNamesWithBug {
    // Collections.synchronizedList do not guarantee that the method above with be thread safe
    private final List<String> names = Collections.synchronizedList(new ArrayList<>());

    public void add(String name) {
        names.add(name);
    }

    public void removeFirst() {
        if (names.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}

class ThreadSafeNames {
    // In this class, all method are synchronized, then we don't need the Collections.synchronizedList
    // So a thread-safe class need that all method be synchronized (or the method who call async method), like StringBuffer
    private final List<String> names = new ArrayList<>();

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void removeFirst() {
        if (names.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}

public class T05ThreadSafeClasses {

    public static void main(String[] args) {
        var threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Alice");

        Runnable r = threadSafeNames::removeFirst;
        new Thread(r).start();
        new Thread(r).start();
    }

}
