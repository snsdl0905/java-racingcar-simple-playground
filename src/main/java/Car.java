import java.util.Random;

public class Car {
    private String name;
    private int location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }

    public void move(){
        int randomNumber = getRandomNumber();
        if(randomNumber > 3) {
            this.location += randomNumber;
        }
    }

    public int getRandomNumber(){
        Random random = new Random();
        return(random.nextInt(10));
    }

    public int getLocation(){
        return this.location;
    }

}
