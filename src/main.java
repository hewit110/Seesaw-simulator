import java.util.concurrent.Semaphore;
/**
 * Multithreaded seesaw simulator program using semaphores
 * Simulates two people on a seesaw: person "fred" and person "wilma"
 * Prints out the height(measured in feet) of the two people simultaneously every one second
 * Height is calculated by preset "velocity" values
 * Once someone reaches a height of one foot or lower, they travel upward with the velocity of the opposite person
 *
 *	@author: Kevin Hewitt
 *  @date: 3/26/2017
 *  @version: 1.0
 *
 */
public class main {
    public static void main(String args[]) throws InterruptedException
    {
    //class instantiations
        Semaphore sem = new Semaphore(1);
        person fred = new person("Fred",1,1, true);
        person wilma = new person("Wilma",1.5,7, false);
        Seesaw seesaw = new Seesaw();

    //run the simulation 10 times with one second intervals
        //one thread performs the calculations for one person
    //Semaphores prevent variable of methods from respective classes from overwriting eachother
        for (int i = 0; i < 10; ++i) {
            Thread.sleep(1000);
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    try {
                        sem.acquire();
                        System.out.println("Fred is at a height of " + seesaw.simulate(fred, wilma));
                        sem.release();
                    }
                    catch(final InterruptedException ie) {
                        System.out.println("Something went wrong when attempting to acquire Semaphore permit");
                    }
                }
            };

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    try {
                        sem.acquire();
                        System.out.println("Wilma is at a height of " + seesaw.simulate(wilma, fred));
                        sem.release();
                    }
                    catch(final InterruptedException ie) {
                        System.out.println("Something went wrong when attempting to acquire Semaphore permit");
                    }
                }
            };

            t1.start();
            t2.start();
        }
    }
}
