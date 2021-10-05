package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballResultTest {
    private final static String PERFECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private final static String STRIKE_MESSAGE = "스트라이크 ";
    private final static String BALL_MESSAGE = "볼";
    private final static String NOTHING_MESSAGE = "낫싱";

    private BaseballResult baseballResult;

    @BeforeEach
    void setup() {
        baseballResult = new BaseballResult();
    }

    @DisplayName("perfect - 3 스트라이크")
    @Test
    void perfect() {
        baseballResult.plusStrike(3);
        assertTrue(baseballResult.isPerfect());
    }

    @DisplayName("non perfect - 1 스트라이크 1 볼")
    @Test
    void nonPerfect() {
        baseballResult.plusBall(1);
        baseballResult.plusStrike(1);
        assertFalse(baseballResult.isPerfect());
    }

    @DisplayName("perfect message")
    @Test
    void getPerfectMessage() {
        assertEquals(PERFECT_MESSAGE, baseballResult.getPerfectMessage());
    }

    @DisplayName("strike message - 2스트라이크")
    @Test
    void generateStrikeMessage() {
        baseballResult.plusStrike(2);
        assertEquals(2 + STRIKE_MESSAGE, baseballResult.getResultMessage());
    }

    @DisplayName("ball message - 3볼")
    @Test
    void generateBallMessage() {
        baseballResult.plusBall(3);
        assertEquals(3 + BALL_MESSAGE, baseballResult.getResultMessage());
    }

    @DisplayName("nothing message")
    @Test
    void generateNothingMessage() {
        assertEquals(NOTHING_MESSAGE, baseballResult.getResultMessage());
    }

    @DisplayName("strike ball message - 2스트라이크 1볼")
    @Test
    void getResultMessage_twoStrike_oneBall() {
        baseballResult.plusStrike(2);
        baseballResult.plusBall(1);
        String resultMessage = baseballResult.getResultMessage();
        assertEquals(2 + STRIKE_MESSAGE + 1 + BALL_MESSAGE, baseballResult.getResultMessage());
        assertFalse(resultMessage.contains(NOTHING_MESSAGE));
    }
}
