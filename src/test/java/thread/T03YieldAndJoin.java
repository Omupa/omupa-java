package thread;

class RunnableThreadExample2 implements Runnable {

    private final char c;

    public RunnableThreadExample2(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("\n" + Thread.currentThread().getName() + " " + c);

        for (int i = 0; i < 500; i++) {
            System.out.print(c);

            // Disposable to give way the processor to another Thread
            Thread.yield();
        }
    }
}

public class T03YieldAndJoin {

    public static void main(String[] args) throws InterruptedException {
        final Thread a = new Thread(new RunnableThreadExample2('A'), "Thread-A");
        final Thread b = new Thread(new RunnableThreadExample2('B'), "Thread-B");

        a.start();
        // It is saying: Hey thread main, wait (get blocked) Thread-A execute to continue your process, and then, start Thread-B
        a.join();

        b.start();

        System.out.println("\nRunning on main thread: " + Thread.currentThread().getName());
    }

}
