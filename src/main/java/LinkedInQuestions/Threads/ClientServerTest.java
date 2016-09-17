package LinkedInQuestions.Threads;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by rmukherj on 8/21/16.
 * A server receives requests from different clients...each client send a Runnable job and time on
 * which this job should be run. Write a java program that would accept these jobs and run each job
 * at the required time. Hint: the solution should have a job priority queue to hold the jobs and it
 * should be multithreaded. One thread should accept the tasks, the other one should run the jobs.
 * Also conditions and signalling will be used
 */
public class ClientServerTest {

    private DelayQueue<Job> queue = new DelayQueue<>();
    private Random rand = new Random(System.nanoTime());

    @Test
    public void testMultipleClientProcessTasks() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    Client client = new Client(queue);
                    client.addTask(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                System.err.println(Thread.currentThread()
                                        .getId() + ": " + e.getMessage());
                            }
                            System.out.println(Thread.currentThread().getId());
                        }
                    }, rand.nextInt(500), TimeUnit.MILLISECONDS);
                }

            });
        }
        exec.submit(new Runnable() {
            @Override
            public void run() {
                Server server = new Server(queue);
                server.processTasks();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
        }
        assertThat(queue.isEmpty(), is(true));
        exec.shutdownNow();
    }


}

class Client {

    private DelayQueue<Job> queue;

    public Client(DelayQueue<Job> queue) {
        this.queue = queue;
    }

    public void addTask(Runnable job, long delay, TimeUnit timeUnit) {
        queue.put(new Job(job, delay, timeUnit));
    }

}

class Server {

    private DelayQueue<Job> queue;

    public Server(DelayQueue<Job> queue) {
        this.queue = queue;
    }

    public void processTasks() {
        while(!Thread.interrupted()) {
            try {
                queue.take().job().run();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}

class Job implements Delayed {

    private Runnable job;
    private TimeUnit timeUnit;
    private long delay;
    private long trigger;

    public Job(Runnable job, long delay, TimeUnit timeUnit) {
        this.job = job;
        this.delay = delay;
        this.timeUnit = timeUnit;
        this.trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delay, timeUnit);
    }

    @Override
    public int compareTo(Delayed o) {
        Job that = (Job)o;
        if (this.trigger - that.trigger < 0) {
            return -1;
        } else if (this.trigger - that.trigger > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public Runnable job() {
        return job;
    }
}