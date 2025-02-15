package nl.theepicblock.dukerinth;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import nl.theepicblock.dukerinth.internal.GsonBodyHandler;
import nl.theepicblock.dukerinth.internal.Util;
import nl.theepicblock.dukerinth.models.User;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class AuthenticatedRoutes {
    private final ModrinthApi internalApi;
    private final String token;

    /**
     * Gets the currently authenticated user
     */
    public @NonNull User self() {
        try {
            var response = internalApi.client.send(
                    authedBuilder()
                            .GET()
                            .uri(internalApi.baseUrl.resolve("/v2/user")).build(),
                    new GsonBodyHandler<>(User.class, internalApi.gson)
            );
            if (Util.isOk(response.statusCode())) {
                return response.body();
            } else {
                throw new ModrinthApiException(response);
            }
        } catch (IOException | InterruptedException e) {
            throw new InternalNetworkingException(e);
        }
    }

    /**
     * Gets the currently authenticated user
     */
    public @NonNull CompletableFuture<@NonNull User> selfAsync() {
        return internalApi.client.sendAsync(
                authedBuilder()
                        .GET()
                        .uri(internalApi.baseUrl.resolve("/v2/user")).build(),
                new GsonBodyHandler<>(User.class, internalApi.gson)
        ).thenApply(response -> {
            if (Util.isOk(response.statusCode())) {
                return response.body();
            } else {
                throw new ModrinthApiException(response);
            }
        });
    }

    private HttpRequest.Builder authedBuilder() {
        return HttpRequest.newBuilder()
                .setHeader("Authorization", token);
    }
}
