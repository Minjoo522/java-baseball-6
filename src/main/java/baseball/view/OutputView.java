package baseball.view;

public class OutputView {
    private OutputView() {
        // 인스턴스 생성 방지용
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
