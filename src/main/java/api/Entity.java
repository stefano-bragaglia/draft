package api;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by stefano on 11/07/2015.
 */
public interface Entity extends Serializable {

    long getId();

    Collection<String> getProperties();

    Optional<Serializable> getProperty(String name);

    boolean hasProperty(String name);

    void setProperty(String name, Serializable value);

    void removeProperty(String name);

}
