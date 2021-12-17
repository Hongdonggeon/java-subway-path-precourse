package subway;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.Station;
import subway.domain.StationRepository;

public class InitService {
	public static void saveInitStations() {
		List<Station> initStations = InitStation.getStationNames().stream()
			.map(Station::new)
			.collect(Collectors.toList());
		StationRepository.addStations(initStations);
	}
}
