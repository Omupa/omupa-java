package thread;

public class T06DeadLock {

    public static void main(String[] args) {
        final Object object1 = new Object();
        final Object object2 = new Object();

        Runnable r1 = () -> {
            synchronized (object1) {
                System.out.println(getThreadName() + ": Lock");
                System.out.println(getThreadName() + ": Waiting lock Thread-1");
                synchronized (object2) {
                    System.out.println(getThreadName() + ": Lock Thread-1");
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (object2) {
                System.out.println(getThreadName() + ": Lock");
                System.out.println(getThreadName() + ": Waiting lock Thread-0");
                synchronized (object1) {
                    System.out.println(getThreadName() + ": Lock Thread-0");
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();

    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    // To fix this Deadlock, we can change the order of sync objects (1 and 2) for the same order in both runnable

}

