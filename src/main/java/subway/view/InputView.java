package subway.view;

import java.util.Scanner;

public class InputView {
	private static final String MAIN_FUNCTION_ALARM = "## 메인 화면\n1. 경로 조회\nQ. 종료\n";
	private static final String WANTED_FUNCTION_SELECT_ALARM = "원하는 기능을 선택하세요.";
	private static final String PATH_FUNCTION_CRITERIA_ALARM = "## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기\n";
	private static final String START_STATION_INPUT_ALARM = "## 출발역을 입력하세요.";
	private static final String ARRIVAL_STATION_INPUT_ALARM = "## 도착역을 입력하세요.";

	private static Scanner scanner = new Scanner(System.in);

	public static String inputString() {
		return scanner.next().trim();
	}

	public static String selectMainFunction() {
		System.out.println();
		System.out.println(MAIN_FUNCTION_ALARM);
		System.out.println(WANTED_FUNCTION_SELECT_ALARM);
		return inputString();
	}

	public static String selectPathFunction() {
		System.out.println();
		System.out.println(PATH_FUNCTION_CRITERIA_ALARM);
		System.out.println(WANTED_FUNCTION_SELECT_ALARM);
		return inputString();
	}

	public static String inputStartStation() {
		System.out.println();
		System.out.println(START_STATION_INPUT_ALARM);
		return inputString();
	}

	public static String inputArrivalStation() {
		System.out.println();
		System.out.println(ARRIVAL_STATION_INPUT_ALARM);
		return inputString();
	}
}
