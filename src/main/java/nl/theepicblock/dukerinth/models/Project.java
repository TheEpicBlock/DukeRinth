package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.Instant;
import java.util.List;

public class Project {
    /**
     * The ID of the project, encoded as a base62 string
     */
    @NonNull
    public String id;
    /**
     * The ID of the team that has ownership of this project
     */
    @NonNull
    public String team;
    /**
     * A message that a moderator sent regarding the project
     */
    @Nullable
    @SerializedName("moderator_message")
    public ModeratorMessage moderatorMessage;
    /**
     * The date the project was published
     */
    @NonNull
    public Instant published;
    /**
     * The date the project was last updated
     */
    @NonNull
    public Instant updated;
    /**
     * The date the project’s status was set to an approved status
     */
    @Nullable
    public Instant approved;
    /**
     * The date the project’s status was submitted to moderators for review
     */
    @Nullable
    public Instant queued;
    /**
     * The total number of users following the project
     */
    public int followers;
    /**
     * The license of the project
     */
    public License license;
    /**
     * A list of the version IDs of the project (will never be empty unless draft status)
     */
    public List<String> versions;
    /**
     * A list of all of the game versions supported by the project.<br>
     * Eg: {@code ["1.19", "1.19.1", "1.20"]}
     */
    @NonNull
    @SerializedName("game_versions")
    public List<String> gameVersions;
    /**
     * A list of all of the loaders supported by the project<br>
     * Eg: {@code ["forge", "fabric", "quilt"]}
     */
    @NonNull
    public List<String> loaders;
    /**
     * A list of images that have been uploaded to the project’s gallery
     */
    @NonNull
    public List<GalleryEntry> gallery;
}
