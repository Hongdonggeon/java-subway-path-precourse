package subway;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionInfo;
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
		SectionInfo.saveVertex(StationRepository.stations());
		SectionInfo.saveEdge(LineRepository.findLine("2호선").getStations());
		SectionInfo.saveEdge(LineRepository.findLine("3호선").getStations());
		SectionInfo.saveEdge(LineRepository.findLine("신분당선").getStations());
		SectionInfo.saveDistance();
		SectionInfo.saveTime();
	}
}
