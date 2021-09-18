package thread;

class RunnableThreadExample implements Runnable {

    private final char c;

    public RunnableThreadExample(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + c);

        for (int i = 0; i < 100; i++) {
            System.out.print(c);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class T02RunnableThread {

    public static void main(String[] args) {
        final Thread a = new Thread(new RunnableThreadExample('A'));
        final Thread b = new Thread(new RunnableThreadExample('B'));
        final Thread c = new Thread(new RunnableThreadExample('C'), "Thread-C");
        final Thread d = new Thread(new RunnableThreadExample('D'));

        // It's not guarantee the priority
        a.setPriority(Thread.MAX_PRIORITY);
        a.start();

        b.start();
        c.start();
        d.start();

        // We can not start this Thread again, only once
        // d.start();

        // Unordered compared with above Thread objects
        System.out.println("\nRunning on main thread: " + Thread.currentThread().getName());
    }

}
