package nl.theepicblock.dukerinth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jspecify.annotations.NonNull;

import java.net.URI;
import java.net.http.HttpClient;

public class ModrinthApi {
    protected final @NonNull URI baseUrl;
    protected final @NonNull String userAgent;

    protected final @NonNull HttpClient client;
    protected final @NonNull Gson gson;

    private final @NonNull UserRoute users;

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
        this.gson = new GsonBuilder().create();
        this.users = new UserRoute(this);
    }

    public UserRoute users() {
        return this.users;
    }
}
