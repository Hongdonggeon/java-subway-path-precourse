package subway;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InitLine {
	SECOND("2호선"), THIRD("3호선"), SINBUN("신분당선");

	private String name;

	InitLine(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static List<String> getLineNames() {
		return Arrays.stream(InitLine.values())
			.map(InitLine::getName)
			.collect(Collectors.toList());
	}
}
