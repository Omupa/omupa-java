package thread;

class ExtendThreadExemple extends Thread {
    private final char c;

    public ExtendThreadExemple(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + c);
    }
}

public class T01ExtendThread {

    public static void main(String[] args) {
        ExtendThreadExemple extendThreadExempleA = new ExtendThreadExemple('A');
        ExtendThreadExemple extendThreadExempleB = new ExtendThreadExemple('B');
        ExtendThreadExemple extendThreadExempleC = new ExtendThreadExemple('C');
        ExtendThreadExemple extendThreadExempleD = new ExtendThreadExemple('D');

        // Execute in parallel, unordered
        extendThreadExempleA.setDaemon(true);
        extendThreadExempleA.start();
        extendThreadExempleB.start();
        extendThreadExempleC.start();
        extendThreadExempleD.start();

        // Execute in main thread, sequentially
        extendThreadExempleA.run();
        extendThreadExempleB.run();
        extendThreadExempleC.run();
        extendThreadExempleD.run();
    }

}
