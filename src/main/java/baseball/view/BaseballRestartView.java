package baseball.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import nextstep.utils.Console;

public class BaseballRestartView {
	private final static String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private final static String VALIDATE_RESTART_INPUT_MESSAGE = "[ERROR] 잘못된 문자를 입력하였습니다. 다시 입력해주세요.";
	private final static Map<String, Boolean> selectOption = new HashMap<>();

	static {
		selectOption.put("1", true);
		selectOption.put("2", false);
	}

	private BaseballRestartView() {
	}

	public static boolean selectRestart() {
		System.out.println(RESTART_INPUT_MESSAGE);
		String inputSelect = Console.readLine();
		try {
			return validateInputSelect(inputSelect);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return selectRestart();
		}
	}

	private static boolean validateInputSelect(String inputSelect) {
		Boolean isRestart = selectOption.get(inputSelect);
		if (Objects.isNull(isRestart)) {
			throw new IllegalArgumentException(VALIDATE_RESTART_INPUT_MESSAGE);
		}
		return isRestart;
	}
}
