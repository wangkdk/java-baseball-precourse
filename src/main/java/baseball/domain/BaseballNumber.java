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
		BaseballNumberValidator.validateOnlyNumberByOneToNine(numbers);
		List<Integer> baseballNumbers = convertValueToBaseballNumbers(numbers);
		return new BaseballNumber(baseballNumbers);
	}

	private static List<Integer> convertValueToBaseballNumbers(String numbers) {
		List<Integer> baseballNumbers = new ArrayList<>();
		for (int i = 0; i < numbers.length(); i++) {
			String number = String.valueOf(numbers.charAt(i));
			baseballNumbers.add(Integer.valueOf(number));
		}
		return baseballNumbers;
	}
}
