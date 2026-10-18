package JavaCodingExamplePkg;
/**
 * 
 * 
 * Volatile works by inserting memory barriers that prevent caching 
 * and instruction reordering. This ensures that all 
 * threads always see the latest value from main memory.
 * 
 * Under the hood, volatile relies on CPU cache coherence protocols 
 * like MESI along with JVM memory barriers to maintain visibility across cores.
 * @author Yoga
 *
 */
public class VolatileTest {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

            flag = true;
            System.out.println("Writer updated flag to true");
        });

        Thread reader = new Thread(() -> {
            while (!flag) {
            //  System.out.println("Waiting..");
            }
            System.out.println("Reader saw flag = true");
        });

        reader.start();
        writer.start();
    }
}