package subway.view;

import java.util.List;

public class OutputView {
	private static final String RESULT_MESSAGE = "## 조회 결과";
	private static final String INFO_ALARM_MESSAGE = "[INFO] ";
	private static final String HYPHON = "---";
	private static final String TOTAL_DISTANCE_MESSAGE = "총 거리: ";
	private static final String TOTAL_TIME_MESSAGE = "총 소요 시간: ";

	public static void showResult(int totalDistance, int totalTime, List<String> stations) {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
		System.out.println(INFO_ALARM_MESSAGE + HYPHON);
		System.out.println(INFO_ALARM_MESSAGE + TOTAL_DISTANCE_MESSAGE + totalDistance +"km");
		System.out.println(INFO_ALARM_MESSAGE + TOTAL_TIME_MESSAGE + totalTime +"분");
		System.out.println(INFO_ALARM_MESSAGE + HYPHON);
		for (String station : stations) {
			System.out.println(INFO_ALARM_MESSAGE + station);
		}
	}
}
