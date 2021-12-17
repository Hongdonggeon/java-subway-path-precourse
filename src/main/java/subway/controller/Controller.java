package subway.controller;

import subway.InitService;
import subway.view.InputView;

public class Controller {
	public void initStatus() {
		InitService.saveInitStations();
		InitService.saveInitLines();
		InitService.saveInitSection();
	}
	public void play() {
		initStatus();
		String s = InputView.selectMainFunction();
		if (s.equals("1")) {
			InputView.selectPathFunction();
		}

	}
}
