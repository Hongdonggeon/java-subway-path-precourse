package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import subway.domain.GraphRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.initStatus.InitService;
import subway.matchedFunction;
import subway.menuOption.DetailedMenuOption;
import subway.menuOption.MainMenuOption;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
	private static Map<MainMenuOption, matchedFunction> mainFunction = new HashMap<>();
	private static Map<DetailedMenuOption, matchedFunction> pathFunction = new HashMap<>();

	public void init() {
		mainFunction.put(MainMenuOption.PATHLOOKUP, SubwayController::run);
		mainFunction.put(MainMenuOption.EXIT,() -> {});
		pathFunction.put(DetailedMenuOption.SHORTEST_DISTANCE, SubwayController::lookUpLeastDistance);
		pathFunction.put(DetailedMenuOption.SHORTEST_TIME, SubwayController::lookUpLeastTime);
		pathFunction.put(DetailedMenuOption.BACK, ()->{});
	}

	public void play() {
		init();
		InitService.setInitStatus();
		while (true) {
			MainMenuOption option = MainMenuOption.getOption(InputView.selectMainFunction());
			mainFunction.get(option).run();
			if (option == MainMenuOption.EXIT) {
				break;
			}
		}
	}

	public static void run() {
		DetailedMenuOption option;
		do {
			option = DetailedMenuOption.getOption(InputView.selectPathFunction());
			pathFunction.get(option).run();
		} while (option != DetailedMenuOption.BACK);
	}


	public static void lookUpLeastDistance() {
		try {
			Station startStation = StationRepository.findStation(InputView.inputStartStation());
			Station arrivalStation = StationRepository.findStation(InputView.inputArrivalStation());
			validateEqualStation(startStation, arrivalStation);
			List<Station> pathInLeastDistance = GraphRepository.findPathInLeastDistance(startStation, arrivalStation);
			List<String> stationNames = StationRepository.castingStationsToString(pathInLeastDistance);
			int leastDistance = GraphRepository.findLeastDistance(startStation, arrivalStation);
			int leastTime = GraphRepository.getTimeInLeastDistance(pathInLeastDistance);
			OutputView.showResult(leastDistance, leastTime, stationNames);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void lookUpLeastTime() {
		try {
			Station startStation = StationRepository.findStation(InputView.inputStartStation());
			Station arrivalStation = StationRepository.findStation(InputView.inputArrivalStation());
			validateEqualStation(startStation, arrivalStation);
			List<Station> pathInLeastTime = GraphRepository.findPathInLeastTime(startStation, arrivalStation);
			List<String> stationNames = StationRepository.castingStationsToString(pathInLeastTime);
			int leastTime = GraphRepository.findLeastTime(startStation, arrivalStation);
			int leastDistance = GraphRepository.getDistanceInLeastTime(pathInLeastTime);
			OutputView.showResult(leastDistance, leastTime, stationNames);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void validateEqualStation(Station startStation, Station endStation) {
		if (startStation.equals(endStation)) {
			throw new IllegalArgumentException("출발역과 도착역이 동일합니다.");
		}
	}
}
