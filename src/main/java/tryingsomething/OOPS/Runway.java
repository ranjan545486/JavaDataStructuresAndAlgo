package tryingsomething.OOPS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by rmukherj on 10/6/16.
 */

class Aircraft{
    public void land() throws InterruptedException {
        Thread.sleep(2000);
    }
}

    public class Runway implements Runnable {

    private final BlockingQueue<Aircraft> requests;

    public Runway(){
        requests = new LinkedBlockingQueue<>();
    }

    public void requestLanding(Aircraft a){
        try{
            requests.put(a);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void dispatchrequest(){
        Aircraft a;
        try{
            a = requests.take();
            a.land();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

        @Override
        public void run() {
            while(true){
                dispatchrequest();
            }
        }
    }
