package subway.menuOption;

import java.util.Arrays;

public enum DetailedMenuOption {
	SHORTEST_DISTANCE("1"), SHORTEST_TIME("2"), BACK("B");

	String menuOption;

	DetailedMenuOption(String menuOption) {
		this.menuOption = menuOption;
	}

	public String getOptionMenu() {
		return menuOption;
	}

	public static DetailedMenuOption getOption(String stringOption) {
		return Arrays.stream(DetailedMenuOption.values())
			.filter(option -> option.getOptionMenu().equals(stringOption))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능이다."));
	}
}
