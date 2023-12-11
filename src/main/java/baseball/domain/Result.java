package baseball.domain;

public class Result {
    private final int strike;
    private final int ball;

    public Result(Numbers user, Numbers computer) {
        strike = computer.countStrike(user);
        ball = computer.countBall(user);
    }

    public String getResult() {
        if (strike != 0 && ball != 0) {
            return String.format(Message.BALL_STRIKE.message, ball, strike);
        }
        if (strike != 0 && ball == 0) {
            return String.format(Message.STRIKE.message, strike);
        }
        if (strike == 0 && ball != 0) {
            return String.format(Message.BALL.message, ball);
        }
        return Message.NOTHING.message;
    }

    public boolean checkGameOver() {
        return strike == 3;
    }

    private enum Message {
        BALL_STRIKE("%d볼 %d스트라이크"),
        STRIKE("%d스트라이크"),
        BALL("%d볼"),
        NOTHING("낫싱");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
