package api;

/**
 * Created by stefano on 11/07/2015.
 */
public interface Node extends Entity {

    boolean hasType(String type);

    Edge createEdge(Node node, String type);

    void delete();

    void delete(Edge edge);

    int getIngoingDegree();

    int getOutgoingDegree();

    int getDegree();

}
