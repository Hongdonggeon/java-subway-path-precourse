package subway.initStatus;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.GraphRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitService {
	public static void saveInitStations() {
		List<Station> initStations = InitStation.getStationNames().stream()
			.map(Station::new)
			.collect(Collectors.toList());
		StationRepository.addStations(initStations);
	}

	public static void saveInitLines() {
		List<Line> initLines = InitLine.getLineInfos();
		LineRepository.addLines(initLines);
	}

	public static void saveInitSection() {
		GraphRepository.addVertexByStationName(StationRepository.stations());
		GraphRepository.graphInit();
	}

	public static void setInitStatus() {
		saveInitStations();
		saveInitLines();
		saveInitSection();
	}
}
