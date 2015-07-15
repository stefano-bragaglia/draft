package api;

/**
 * Created by stefano on 11/07/2015.
 */
public interface Edge extends Entity {

    Node getTail();

    Node getHead();

    Node getOther(Node node);

    void delete();

}
