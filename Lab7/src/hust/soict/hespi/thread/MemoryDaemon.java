package hust.soict.hespi.thread;

import java.lang.Runtime;

public class MemoryDaemon implements Runnable {

    private long memoryUsed = 0;

    public MemoryDaemon() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        Runtime rt = Runtime.getRuntime();
        long used;

        while (true) {
            used = rt.totalMemory() - rt.freeMemory();
            if (used != memoryUsed) {
                System.out.println("Memory Used = " + used);
                memoryUsed = used;
            }
        }
    }

}
