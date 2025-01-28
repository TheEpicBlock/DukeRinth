package nl.theepicblock.dukerinth;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import nl.theepicblock.dukerinth.internal.GsonBodyHandler;
import nl.theepicblock.dukerinth.internal.Util;
import nl.theepicblock.dukerinth.models.Organization;
import nl.theepicblock.dukerinth.models.TeamMember;
import nl.theepicblock.dukerinth.models.Project;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class ProjectRoute {
    private final ModrinthApi internalApi;

    public @Nullable Project getProject(String id) {
        try {
            var response = internalApi.client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(internalApi.baseUrl.resolve("/v2/project/" + id)).build(),
                    new GsonBodyHandler<>(Project.class, internalApi.gson)
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

    public CompletableFuture<@Nullable Project> getProjectAsync(String id) {
        return internalApi.client.sendAsync(
                HttpRequest.newBuilder()
                        .GET()
                        .uri(internalApi.baseUrl.resolve("/v2/project/" + id)).build(),
                new GsonBodyHandler<>(Project.class, internalApi.gson)
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

    public List<@NonNull Project> getProjects(@NonNull String... ids) {
        if (ids.length == 0) {
            return List.of();
        }
        if (ids.length == 1) {
            var u = getProject(ids[0]);
            return u == null ? List.of() : List.of(u);
        }
        return getProjects(List.of(ids));
    }

    public List<@NonNull Project> getProjects(List<@NonNull String> ids) {
        if (ids.size() == 1) {
            var u = getProject(ids.get(0));
            return u == null ? List.of() : List.of(u);
        }
        return getProjects((Collection<String>)ids);
    }

    public List<@NonNull Project> getProjects(Collection<@NonNull String> ids) {
        if (ids.isEmpty()) {
            return List.of();
        }
        return getProjects((Iterable<String>)ids);
    }

    public List<@NonNull Project> getProjects(Iterable<@NonNull String> ids) {
        // TODO handle url encoding properly
        var builder = new StringBuilder();
        builder.append("/v2/projects?ids=%5B");
        boolean first = true;
        for (var id : ids) {
            if (first) {
                first = false;
            } else {
                builder.append(",");
            }
            builder.append("%22");
            builder.append(id);
            builder.append("%22");
        }
        builder.append("%5D");
        return getProjectsInternal(internalApi.baseUrl.resolve(builder.toString()));
    }

    private List<@NonNull Project> getProjectsInternal(URI uri) {
        try {
            HttpResponse<List<Project>> response = internalApi.client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(uri).build(),
                    GsonBodyHandler.ofList(Project.class, internalApi.gson)
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

    /**
     * Note, this does not give full ownership information. Must be combined with {@link #getProjectOrganization(String)}.
     * Will return null if the request 404'd.
     */
    public List<@NonNull TeamMember> getProjectMembers(String id) {
        try {
            HttpResponse<List<TeamMember>> response = internalApi.client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(internalApi.baseUrl.resolve("/v3/project/" + id + "/members")).build(),
                    GsonBodyHandler.ofList(TeamMember.class, internalApi.gson)
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

    /**
     * Note, this does not give full ownership information. Must be combined with {@link #getProjectOrganizationAsync(String)}.
     * Will return null if the request 404'd.
     */
    public CompletableFuture<List<@NonNull TeamMember>> getProjectMembersAsync(String id) {
        return internalApi.client.sendAsync(
                HttpRequest.newBuilder()
                        .GET()
                        .uri(internalApi.baseUrl.resolve("/v3/project/" + id + "/members")).build(),
                (GsonBodyHandler<? extends List<@NonNull TeamMember>>)GsonBodyHandler.ofList(TeamMember.class, internalApi.gson)
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

    /**
     * Note, this does not give full ownership information. Must be combined with {@link #getProjectMembers(String)}.
     * Will return null if the request 404'd.
     */
    public @Nullable Organization getProjectOrganization(String id) {
        try {
            var response = internalApi.client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(internalApi.baseUrl.resolve("/v2/project/" + id)).build(),
                    new GsonBodyHandler<>(Organization.class, internalApi.gson)
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

    /**
     * Note, this does not give full ownership information. Must be combined with {@link #getProjectMembersAsync(String)}.
     * Will return null if the request 404'd.
     */
    public CompletableFuture<@Nullable Organization> getProjectOrganizationAsync(String id) {
        return internalApi.client.sendAsync(
                HttpRequest.newBuilder()
                        .GET()
                        .uri(internalApi.baseUrl.resolve("/v2/project/" + id)).build(),
                new GsonBodyHandler<>(Organization.class, internalApi.gson)
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
}
