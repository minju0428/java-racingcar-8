# java-racingcar-precourse
# 자동차 경주 게임



**자동차 경주 게임**은 `camp.nextstep.edu.missionutils` 패키지의 클래스를 활용하여, n대의 자동차가 순차적으로 전진하며 레이싱하는 콘솔 기반 프로그램입니다.



## 기능 목록



- [x] 경주할 자동차 이름을 쉼표(,)로 입력받습니다.

- [x] 시도할 횟수를 입력받습니다.

- [x] 자동차 이름은 1자 이상, 5자 이하만 가능하며, 이를 벗어나면 `IllegalArgumentException` 발생.

- [x] 자동차는 0~9 사이 난수를 기반으로 4 이상일 경우 전진.

- [x] 각 차수별 실행 결과를 출력합니다.

- [x] 최종 우승자를 출력하며, 공동 우승자도 지원합니다.



## 주요 메서드 설명 (`Application.java`)



- **main(String[] args)**  

  프로그램의 메인 진입점으로, 전체 흐름(입력, 실행, 출력)을 제어하고 예외를 처리합니다.



- **getValidCarNames()**  

  사용자로부터 자동차 이름을 입력받습니다.



- **validateCarNames(String[] carNames)**  

  자동차 이름 배열을 받아, 이름 길이(1~5자)를 검증합니다.  

  유효하지 않을 경우 `IllegalArgumentException` 발생.



- **getValidTryCount()**  

  사용자로부터 시도 횟수를 입력받습니다.



- **parseAndValidateTryCount(String numberStr)**  

  입력된 문자열을 숫자로 변환하고, 1 이상인지 검증합니다.  

  유효하지 않을 경우 `IllegalArgumentException` 발생.



- **createCars(String[] carNames)**  

  검증된 이름 배열을 기반으로 `Car` 객체 배열을 생성합니다.



- **runRace(Car[] cars, int tryCount)**  

  입력된 시도 횟수만큼 레이스를 반복하며, 각 차수마다 `runSingleRound` 호출.



- **runSingleRound(Car[] cars)**  

  1회차 경주를 수행하며, 각 자동차의 전진 여부를 결정하고 `printCarStatus` 호출.



- **printCarStatus(Car car)**  

  자동차의 현재 상태(`이름 : ---`)를 출력합니다.



- **printWinners(Car[] cars)**  

  레이스 종료 후 최종 우승자를 출력합니다.



- **findWinners(ArrayList<Car> cars)**  

  가장 멀리 이동한 자동차를 찾아 ArrayList로 반환합니다.



- **findMaxPosition(Car[] cars)**  

  자동차들 중 가장 멀리 이동한 최대 거리를 반환합니다.
