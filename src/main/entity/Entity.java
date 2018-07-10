package main.entity;

/**
 * The entity class for all the entity in the movie theater.
 * @author Han-Tse Chiou
 * @param <T>
 */
public class Entity<T> {
	protected T id;
	public T getId() {
		return id;
	}
}
