package subway.domain;

import static subway.domain.StationRepository.*;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SectionInfo {
	private static WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
	private static WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);


	public static void addVertexByStationName(List<Station> stationNames) {
		for (Station stationName : stationNames) {
			timeGraph.addVertex(stationName);
			distanceGraph.addVertex(stationName);
		}
	}

	public static void graphInit() {
		secondLineSet();
		thirdLineSet();
		sinbundangLineSet();
	}

	private static void secondLineSet() {
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(findStation("교대역"), findStation("강남역")), 2);
		timeGraph.setEdgeWeight(timeGraph.addEdge(findStation("교대역"), findStation("강남역")), 3);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(findStation("강남역"), findStation("역삼역")), 2);
		timeGraph.setEdgeWeight(timeGraph.addEdge(findStation("강남역"), findStation("역삼역")), 3);
	}
	private static void thirdLineSet() {
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(findStation("교대역"), findStation("남부터미널역")), 3);
		timeGraph.setEdgeWeight(timeGraph.addEdge(findStation("교대역"), findStation("남부터미널역")), 2);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(findStation("남부터미널역"), findStation("양재역")), 6);
		timeGraph.setEdgeWeight(timeGraph.addEdge(findStation("남부터미널역"), findStation("양재역")), 5);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(findStation("양재역"), findStation("매봉역")), 1);
		timeGraph.setEdgeWeight(timeGraph.addEdge(findStation("양재역"),findStation("매봉역")), 1);
	}

	private static void sinbundangLineSet() {
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(findStation("강남역"), findStation("양재역")), 2);
		timeGraph.setEdgeWeight(timeGraph.addEdge(findStation("강남역"), findStation("양재역")), 8);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(findStation("양재역"), findStation("양재시민의숲역")), 10);
		timeGraph.setEdgeWeight(timeGraph.addEdge(findStation("양재역"), findStation("양재시민의숲역")), 3);
	}


	public static int findLeastTime(Station startStation, Station endStation) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
		return (int)dijkstraShortestPath.getPathWeight(startStation, endStation);
	}

	public static List<Station> findPathInLeastTime(Station startStation, Station arrvialStation) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
		List<Station> vertexList = dijkstraShortestPath.getPath(startStation, arrvialStation).getVertexList();
		return vertexList;
	}

	public static int findLeastDistance(Station startStation, Station endStation) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
		return (int)dijkstraShortestPath.getPathWeight(startStation, endStation);
	}

	public static List<Station> findPathInLeastDistance(Station startStation, Station arrvialStation) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
		List<Station> vertexList = dijkstraShortestPath.getPath(startStation, arrvialStation).getVertexList();
		return vertexList;
	}
}
