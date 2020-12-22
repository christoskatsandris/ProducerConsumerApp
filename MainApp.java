import java.lang.String;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainApp {
    static Producer producer;
    static Consumer consumer1, consumer2;
    public static void main (String [] args) {
        Scanner in = new Scanner (System.in);

        // Declare story characters
        System.out.println("Hello world!");
        System.out.println("Enter producer\'s name: ");
        producer = new Producer (in.nextLine());
        System.out.println("Enter 1st consumer\'s name: ");
        consumer1 = new Consumer (in.nextLine());
        System.out.println("Enter 2nd consumer\'s name: ");
        consumer2 = new Consumer (in.nextLine());
        in.close();

        // Prepare consumer2 for concurrency

        Runnable consumer2Runnable = new Runnable () {
            @Override
            public void run () {
                consumer2.enterStore(producer.ProducersStore);
                consumer2.setPriority(Thread.MAX_PRIORITY);
                consumer2.start();
            }
        };

        // Story begins here

        System.out.println("\n--------------- " + producer.ProducersStore.getBrandName() + " ---------------\n\n");

        producer.setPriority(Thread.NORM_PRIORITY);
        producer.start();

        consumer1.enterStore(producer.ProducersStore);
        consumer1.setPriority(Thread.MAX_PRIORITY);
        consumer1.start();

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        executor.schedule (consumer2Runnable, 500, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }
}