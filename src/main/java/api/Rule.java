package api;

/**
 * Created by stefano on 11/07/2015.
 */
public interface Rule {

	Pattern getPattern();

	Action getAction();

}
