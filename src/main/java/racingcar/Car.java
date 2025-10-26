package racingcar;

public class Car {
    String name;
    int number;
    int result;

    public Car(String name) {
        this.name = name;
        this.result = 0;
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.result++;
    }

    public int getNumber() {
        return number;
    }

    public int resultNumber() {
        return result;
    }
}