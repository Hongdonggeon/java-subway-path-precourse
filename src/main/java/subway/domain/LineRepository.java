package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final String NOT_EXIST_LINE_NAME_ERROR_MESSAGE = "[ERROR] 입력하신 노선이 존재하지 않습니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static void addLines(List<Line> initLines){
        initLines.addAll(lines);
    }

    public static Line findLine(String lineName) {
        return lines().stream()
            .filter(line -> line.getName().equals(lineName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_LINE_NAME_ERROR_MESSAGE));
    }
}
