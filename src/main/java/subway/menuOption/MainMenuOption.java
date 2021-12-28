package subway.menuOption;

import java.util.Arrays;

public enum MainMenuOption {
	PATHLOOKUP("1"), EXIT("Q");

	private String option;

	MainMenuOption(String option) {
		this.option = option;
	}

	public String getOptionMenu() {
		return option;
	}

	public static MainMenuOption getOption(String stringOption) {
		return Arrays.stream(MainMenuOption.values())
			.filter(option -> option.getOptionMenu().equals(stringOption))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능이다."));
	}
}
