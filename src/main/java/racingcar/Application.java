package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            String[] carNames = getValidCarNames();
            int tryCount = getValidTryCount();
            Car[] cars = createCars(carNames);

            System.out.println("\n실행 결과");
            runRace(cars, tryCount);

            printWinners(cars);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[] getValidCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] parts = input.split(",");

        validateCarNames(parts);

        return parts;
    }

    private static void validateCarNames(String[] carNames) throws IllegalArgumentException {
        for (String name : carNames) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException("[오류] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
    }

    private static int getValidTryCount() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberStr = Console.readLine();
        return parseAndValidateTryCount(numberStr);
    }

    private static int parseAndValidateTryCount(String numberStr) throws IllegalArgumentException {
        int tryCount;
        try {
            tryCount = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[오류] 시도 횟수는 숫자여야 합니다.");
        }

        if (tryCount <= 0) {
            throw new IllegalArgumentException("[오류] 시도 횟수는 1 이상의 숫자여야 합니다.");
        }

        return tryCount;
    }

    private static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }
        return cars;
    }

    private static void runRace(Car[] cars, int tryCount) {
        while (tryCount > 0) {
            runSingleRound(cars);
            System.out.println();
            tryCount--;
        }
    }

    private static void runSingleRound(Car[] cars) {
        for (Car car : cars) {
            car.number = Randoms.pickNumberInRange(0, 9);
            if (car.number >= 4) {
                car.move();
            }
            printCarStatus(car);
        }
    }

    private static void printCarStatus(Car car) {
        System.out.print(car.name + " : ");
        for (int j = 0; j < car.result; j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void printWinners(Car[] cars) {
        ArrayList<String> winners = findWinners(cars);
        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }

    private static ArrayList<String> findWinners(Car[] cars) {
        int maxPosition = findMaxPosition(cars);
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.result == maxPosition) {
                winners.add(car.name);
            }
        }
        return winners;
    }

    private static int findMaxPosition(Car[] cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.result > max) {
                max = car.result;
            }
        }
        return max;
    }
}
