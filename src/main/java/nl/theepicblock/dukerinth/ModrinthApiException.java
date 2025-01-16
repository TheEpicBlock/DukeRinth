package nl.theepicblock.dukerinth;

import java.net.http.HttpResponse;

/**
 * Indicates something went wrong whilst decoding the request.
 */
public class ModrinthApiException extends RuntimeException {
    public HttpResponse<?> httpResponse;

    public ModrinthApiException(HttpResponse<?> httpResponse) {
        super("Failed to "+httpResponse.request().method()+" "+httpResponse.uri()+" ("+httpResponse.statusCode()+")");
        this.httpResponse = httpResponse;
    }
}
