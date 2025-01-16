package nl.theepicblock.dukerinth;

/**
 * Error thrown when something goes wrong whilst sending the request. Not
 * when something goes wrong decoding the request.
 */
public class InternalNetworkingException extends RuntimeException {
    public InternalNetworkingException(String message) {
        super(message);
    }

    public InternalNetworkingException(Throwable cause) {
        super(cause);
    }
}
