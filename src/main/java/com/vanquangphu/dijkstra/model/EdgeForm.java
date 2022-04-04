package com.vanquangphu.dijkstra.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EdgeForm {
    String vertices;
    String edges;
    String rootEdge;

}
