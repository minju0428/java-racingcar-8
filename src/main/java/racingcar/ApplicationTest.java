package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "jun : -", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리_5자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[오류] 자동차 이름은 1자 이상 5자 이하여야 합니다.")
        );
    }

    @Test
    void 이름에_대한_예외_처리_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[오류] 자동차 이름은 1자 이상 5자 이하여야 합니다.")
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_숫자_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[오류] 시도 횟수는 숫자여야 합니다.")
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_0_이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[오류] 시도 횟수는 1 이상의 숫자여야 합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}