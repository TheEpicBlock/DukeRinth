package nl.theepicblock.dukerinth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nl.theepicblock.dukerinth.internal.InstantSerializer;
import nl.theepicblock.dukerinth.internal.RoleSerializer;
import nl.theepicblock.dukerinth.models.Role;
import org.jspecify.annotations.NonNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.time.Instant;

public class ModrinthApi {
    protected final @NonNull URI baseUrl;
    protected final @NonNull String userAgent;

    protected final @NonNull HttpClient client;
    protected final @NonNull Gson gson;

    private final @NonNull UserRoute users;
    private final @NonNull ProjectRoute projects;

    public ModrinthApi(String userAgent) {
        this(userAgent, "https://api.modrinth.com/");
    }

    public ModrinthApi(UserAgentBuilder userAgent) {
        this(userAgent, "https://api.modrinth.com/");
    }

    public ModrinthApi(UserAgentBuilder userAgent, String baseUrl) {
        this(userAgent.toString(), baseUrl);
    }

    public ModrinthApi(@NonNull String userAgent, @NonNull String baseUrl) {
        this.userAgent = userAgent;
        this.baseUrl = URI.create(baseUrl);

        this.client = HttpClient
                .newBuilder()
                .build();
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Instant.class, new InstantSerializer())
                .registerTypeAdapter(Role.class, new RoleSerializer())
                .create();
        this.users = new UserRoute(this);
        this.projects = new ProjectRoute(this);
    }

    public UserRoute users() {
        return this.users;
    }

    public ProjectRoute projects() {
        return this.projects;
    }
}
