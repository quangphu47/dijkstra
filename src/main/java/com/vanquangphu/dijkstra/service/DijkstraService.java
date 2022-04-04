package com.vanquangphu.dijkstra.service;

import com.vanquangphu.dijkstra.model.Dijkstra;
import com.vanquangphu.dijkstra.model.EdgeForm;
import com.vanquangphu.dijkstra.model.Graph;
import com.vanquangphu.dijkstra.model.Node;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DijkstraService {
    public String run(EdgeForm edgeForm){
        String[] vertices = edgeForm.getVertices().split(",");
        Map<String, Node> mapNameNode = new HashMap<>();

        for (String v : vertices){
            mapNameNode.put(v, new Node(v));
        }

        String[] list = edgeForm.getEdges().split(":");
        for(int  i=0;i<list.length; i=i+3){
            Node nodeN = mapNameNode.get(list[i]);
            Node nodeD = mapNameNode.get(list[i+1]);
            int k = Integer.valueOf(list[i+2]);
            nodeN.addDestination(nodeD, k);
        }

        Graph graph = new Graph();

        for(String name : mapNameNode.keySet()){
            graph.addNode(mapNameNode.get(name));
        }

        graph = Dijkstra.calculateShortestPathFromSource(graph, mapNameNode.get(edgeForm.getRootEdge()));

        String result= "";
        for (Node node : graph.getNodes()) {
            result +="Khoảng cách từ "+ edgeForm.getRootEdge() + " đến " + node.getName() + " là " + node.getDistance()+"\n";
        }

        return result;
    }
}
