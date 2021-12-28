package subway.initStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InitStation {
	kyodae("교대역"), kangnam("강남역"), yuksam("역삼역"), nambu("남부터미널역"), yangjae("양재역"), yangjaeforest("양재시민의숲역"), maebong(
		"매봉역"),
	;
	private String name;

	InitStation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static List<String> getStationNames() {
		return Arrays.stream(InitStation.values())
			.map(InitStation::getName)
			.collect(Collectors.toList());
	}
}
