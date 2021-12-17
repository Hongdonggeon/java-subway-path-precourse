package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String STATION_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 최소 두글자 이상이여야 한다.";

    private String name;
    private List<Station> stations;

    public List<Station> getStations() {
        return stations;
    }

    public Line(String name, List<Station> stationsInLine) {
        validateNameLength(name);
        this.name = name;
        stations = new ArrayList<>();
        this.stations = stationsInLine;
    }

    public String getName() {
        return name;
    }

    public static void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Line line = (Line)o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
