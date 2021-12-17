package subway.controller;

import subway.InitService;
import subway.view.InputView;

public class Controller {
	public void play() {
		InitService.saveInitStations();
		InitService.saveInitLines();
		InitService.saveInitSection();

		String s = InputView.selectMainFunction();
		if (s.equals("1")) {
			InputView.selectPathFunction();
		}

	}
}
