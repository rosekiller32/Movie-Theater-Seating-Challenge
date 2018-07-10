/**
 * 
 */
package main.request;

/**
 * @author h0c01cy
 * @param <T>
 * @param <E>
 *
 */
public interface IRequestHandler<T, E> {
	public E processResquest(T request);
}
