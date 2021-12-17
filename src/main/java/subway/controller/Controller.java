package subway.controller;

import java.util.List;

import subway.InitService;
import subway.domain.SectionInfo;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

public class Controller {
	public void initStatus() {
		InitService.saveInitStations();
		InitService.saveInitLines();
		InitService.saveInitSection();
	}
	public void play() {
		initStatus();
		while (true) {
			String s = InputView.selectMainFunction();
			if (s.equals("1")) {
				String functionOption = InputView.selectPathFunction();
				Station startStation = StationRepository.findStation(InputView.inputStartStation());
				Station arrivalStation = StationRepository.findStation(InputView.inputArrivalStation());
				if (functionOption.equals("1")) {
					List<Station> pathInLeastDistance = SectionInfo.findPathInLeastDistance(startStation,
						arrivalStation);
					int leastDistance = SectionInfo.findLeastDistance(startStation, arrivalStation);
					System.out.println(leastDistance);
				} else if (functionOption.equals("2")) {
					List<Station> pathInLeastTime = SectionInfo.findPathInLeastTime(startStation, arrivalStation);
					int leastTime = SectionInfo.findLeastTime(startStation, arrivalStation);
					System.out.println(leastTime);
				}
			}
		}
	}
}
