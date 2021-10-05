package baseball.domain;

public class BaseballResult {
    private final static String PERFECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private final static String STRIKE_MESSAGE = "스트라이크 ";
    private final static String BALL_MESSAGE = "볼";
    private final static String NOTHING_MESSAGE = "낫싱";

    private int strike;
    private int ball;

    public void plusStrike(int strike) {
        this.strike += strike;
    }

    public void plusBall(int ball) {
        this.ball += ball;
    }

    public boolean isPerfect() {
        return strike == 3;
    }

    public String getPerfectMessage() {
        return PERFECT_MESSAGE;
    }

    public String getResultMessage() {
        return generateStrikeMessage() + generateBallMessage()
            + generateNothingMessage();
    }

    private String generateStrikeMessage() {
        if (strike > 0) {
            return strike + STRIKE_MESSAGE;
        }
        return "";
    }

    private String generateBallMessage() {
        if (ball > 0) {
            return ball + BALL_MESSAGE;
        }
        return "";
    }

    private String generateNothingMessage() {
        if (strike == 0 && ball == 0) {
            return NOTHING_MESSAGE;
        }
        return "";
    }
}
