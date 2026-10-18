package JavaCodingExamplePkg;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//fine-grained locking:
public class ReEntrantLock {
	 private int value1;
	    private int value2;
	    private final Lock lock1 = new ReentrantLock();
	    private final Lock lock2 = new ReentrantLock();

	    public void performComplexOperation() {
	        lock1.lock();
	        try {
	            // Perform part 1 of the operation
	            value1++;
	        } finally {
	            lock1.unlock();
	        }

	        lock2.lock();
	        try {
	            // Perform part 2 of the operation
	            value2++;
	        } finally {
	            lock2.unlock();
	        }
	    }
}
