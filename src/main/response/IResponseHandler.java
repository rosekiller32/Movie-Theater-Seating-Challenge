/**
 * 
 */
package main.response;

/**
 * @author h0c01cy
 * @param <T>
 * @param <E>
 */
public interface IResponseHandler<E, T> {
	public E processResponse(T response);
}
