package nl.theepicblock.dukerinth.models;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ModeratorMessage {
    /**
     * The message that a moderator has left for the project
     */
    @NonNull
    public String message;
    /**
     * The longer body of the message that a moderator has left for the project
     */
    @Nullable
    public String body;
}
