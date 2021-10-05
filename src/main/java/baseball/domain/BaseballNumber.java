package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
	private final List<Integer> baseballNumbers;

	private BaseballNumber(List<Integer> baseballNumbers) {
		BaseballNumberValidator.validateNumbersSize(baseballNumbers);
		BaseballNumberValidator.validateNumbersDuplicate(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}

	public static BaseballNumber create(List<Integer> baseballNumbers) {
		return new BaseballNumber(baseballNumbers);
	}

	public static BaseballNumber create(String numbers) {
		List<Integer> baseballNumbers = convertValueToBaseballNumbers(numbers);
		return new BaseballNumber(baseballNumbers);
	}

	private static List<Integer> convertValueToBaseballNumbers(String numbers) {
		BaseballNumberValidator.validateOnlyNumberByOneToNine(numbers);
		List<Integer> baseballNumbers = new ArrayList<>();
		for (int i = 0; i < numbers.length(); i++) {
			String number = String.valueOf(numbers.charAt(i));
			baseballNumbers.add(Integer.valueOf(number));
		}
		return baseballNumbers;
	}

	public BaseballResult match(BaseballNumber playerBaseballNumbers) {
		BaseballResult baseballResult = new BaseballResult();
		for (int i = 0; i < playerBaseballNumbers.baseballNumbers.size(); i++) {
			baseballResult.plusStrike(checkStrike(playerBaseballNumbers.baseballNumbers, i));
			baseballResult.plusBall(checkBall(playerBaseballNumbers.baseballNumbers, i));
		}
		return baseballResult;
	}

	private int checkStrike(List<Integer> playerBaseballNumbers, int index) {
		if (baseballNumbers.get(index).equals(playerBaseballNumbers.get(index))) {
			return 1;
		}
		return 0;
	}

	private int checkBall(List<Integer> playerBaseballNumbers, int index) {
		if (baseballNumbers.contains(playerBaseballNumbers.get(index))
			&& !baseballNumbers.get(index).equals(playerBaseballNumbers.get(index))) {
			return 1;
		}
		return 0;
	}
}
