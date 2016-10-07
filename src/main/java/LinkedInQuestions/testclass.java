package LinkedInQuestions;

/**
 * Created by rmukherj on 9/21/16.
 */
public class testclass {

    public static void main(String[] args) {
        Honda honda = new Honda();
        honda.setColor("RED");
        honda.setMaxSpeed(18);
        honda.carInfo();
        honda.HondaStartDemo();

        //Base = new Derived
        Car car = new Honda();
        car.setColor("Blue");
        car.setMaxSpeed(75);
        car.carInfo();


    }
}

class Car{
    private String color;
    private int maxSpeed;
    public void carInfo(){
        System.out.println("Car color="+color+ " Max Speed= "+maxSpeed);

    }

    public void setColor(String color){
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

}

class Engine{
    public void start(){
        System.out.println("Engine Started");

    }

    public void stop(){
        System.out.println("Engine Stopped");
    }
}

class Honda extends Car{
    // Honda extends car and thus inherits all methods from car,
    // excepts final and static
    // Honda can also define all its specific functionality.

    public void HondaStartDemo(){
        Engine hondaEngine = new Engine();
        hondaEngine.start();
    }

    public void HondaStopDemo(){
        Engine hondaEngine = new Engine();
        hondaEngine.stop();
    }
}
