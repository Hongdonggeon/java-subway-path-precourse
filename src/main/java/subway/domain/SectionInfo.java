package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SectionInfo {
	private static WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph;
	private static WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph;
	private static List<DefaultWeightedEdge> edgeList;

	public static void saveVertex(List<Station> stations) {
		distanceGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
		timeGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
		edgeList = new ArrayList<>();
		for (Station station : StationRepository.stations()) {
			distanceGraph.addVertex(station);
			timeGraph.addVertex(station);
		}
	}

	public static void saveEdge(List<Station> stations) {
		for (int i = 0; i < stations.size() - 1; i++) {
			DefaultWeightedEdge weightedEdge = distanceGraph.addEdge(stations.get(i), stations.get(i + 1));
			edgeList.add(weightedEdge);
		}
	}

	public static void saveDistance() {
		List<Integer> distances = Arrays.asList(2, 2, 3, 6, 1, 2, 10);
		int index = 0;
		for (DefaultWeightedEdge defaultWeightedEdge : edgeList) {
			distanceGraph.setEdgeWeight(defaultWeightedEdge, distances.get(index));
			index++;
		}
	}

	public static void saveTime() {
		List<Integer> times = Arrays.asList(3, 3, 2, 5, 1, 8, 3);
		int index = 0;
		for (DefaultWeightedEdge defaultWeightedEdge : edgeList) {
			timeGraph.setEdgeWeight(defaultWeightedEdge, times.get(index));
			index++;
		}
	}
}
