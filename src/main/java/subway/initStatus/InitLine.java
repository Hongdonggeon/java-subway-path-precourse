package subway.initStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationRepository;

public enum InitLine {
	SECOND("2호선", StationRepository.findStations(Arrays.asList("교대역","강남역","역삼역"))),
	THIRD("3호선", StationRepository.findStations(Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"))),
	SINBUN("신분당선", StationRepository.findStations(Arrays.asList("강남역", "양재역", "양재시민의숲역")));

	private String name;
	private List<Station> stations;

	InitLine(String name, List<Station> stationList) {
		this.name = name;
		this.stations = stationList;
	}

	public String getName() {
		return name;
	}

	public List<Station> getStations() {
		return stations;
	}

	public static List<Line> getLineInfos() {
		return Arrays.stream(InitLine.values())
			.map(line -> new Line(line.getName(), line.getStations()))
			.collect(Collectors.toList());
	}
}
