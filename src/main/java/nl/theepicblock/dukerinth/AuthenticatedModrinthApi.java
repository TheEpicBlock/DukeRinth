package nl.theepicblock.dukerinth;

import lombok.NonNull;

public class AuthenticatedModrinthApi {
    private final ModrinthApi source;
    private final String token;

    AuthenticatedModrinthApi(ModrinthApi source, String token) {
        this.source = source;
        this.token = token;
    }
}
