package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name; // 이름은 변경되지 않으므로 final
    private int position;      // result 대신 position 같은 명확한 이름 사용

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // Car가 스스로 움직일지 결정
    public void tryMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    // 캡슐화를 위해 getter 제공
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}