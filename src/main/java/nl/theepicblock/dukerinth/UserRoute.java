package nl.theepicblock.dukerinth;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.AllArgsConstructor;
import nl.theepicblock.dukerinth.internal.GsonBodyHandler;
import nl.theepicblock.dukerinth.internal.Util;
import nl.theepicblock.dukerinth.models.User;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class UserRoute {
    private final ModrinthApi internalApi;

    public @Nullable User getUser(String id) {
        try {
            var response = internalApi.client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(internalApi.baseUrl.resolve("/v2/user/" + id)).build(),
                    new GsonBodyHandler<>(User.class, internalApi.gson)
            );
            if (response.statusCode() == 404) {
                return null;
            } else if (Util.isOk(response.statusCode())) {
                return response.body();
            } else {
                throw new ModrinthApiException(response);
            }
        } catch (IOException | InterruptedException e) {
            throw new InternalNetworkingException(e);
        }
    }

    public CompletableFuture<@Nullable User> getUserAsync(String id) {
        return internalApi.client.sendAsync(
                HttpRequest.newBuilder()
                        .GET()
                        .uri(internalApi.baseUrl.resolve("/v2/user/" + id)).build(),
                new GsonBodyHandler<>(User.class, internalApi.gson)
        ).thenApply(response -> {
            if (response.statusCode() == 404) {
                return null;
            } else if (Util.isOk(response.statusCode())) {
                return response.body();
            } else {
                throw new ModrinthApiException(response);
            }
        });
    }

    public List<@NonNull User> getUsers(@NonNull String... ids) {
        if (ids.length == 0) {
            return List.of();
        }
        if (ids.length == 1) {
            var u = getUser(ids[0]);
            return u == null ? List.of() : List.of(u);
        }
        return getUsers(ids);
    }

    public List<@NonNull User> getUsers(List<@NonNull String> ids) {
        if (ids.size() == 1) {
            var u = getUser(ids.get(0));
            return u == null ? List.of() : List.of(u);
        }
        return getUsers((Collection<String>)ids);
    }

    public List<@NonNull User> getUsers(Collection<@NonNull String> ids) {
        if (ids.isEmpty()) {
            return List.of();
        }
        return getUsers((Iterable<String>)ids);
    }

    public List<@NonNull User> getUsers(Iterable<@NonNull String> ids) {
        var builder = new StringBuilder();
        builder.append("/v2/users?ids=[");
        boolean first = true;
        for (var id : ids) {
            if (first) {
                first = false;
            } else {
                builder.append(",");
            }
            builder.append('"');
            builder.append(id);
            builder.append('"');
        }
        builder.append('\"');
        return getUsersInternal(internalApi.baseUrl.resolve(builder.toString()));
    }

    private List<@NonNull User> getUsersInternal(URI uri) {
        try {
            HttpResponse<List<User>> response = internalApi.client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(uri).build(),
                    GsonBodyHandler.ofList(User.class, internalApi.gson)
            );
            if (response.statusCode() == 404) {
                return null;
            } else if (Util.isOk(response.statusCode())) {
                return response.body();
            } else {
                throw new ModrinthApiException(response);
            }
        } catch (IOException | InterruptedException e) {
            throw new InternalNetworkingException(e);
        }
    }
}
