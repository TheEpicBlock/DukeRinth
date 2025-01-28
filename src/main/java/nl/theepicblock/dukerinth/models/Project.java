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
     * The slug of a project, used for vanity URLs
     */
    @Nullable
    public String slug;
    @NonNull
    @SerializedName("project_type")
    public String projectType;
    /**
     * The title or name of the project
     */
    @NonNull
    public String title;
    /**
     * A short description of the project.
     */
    @NonNull
    public String description;
    /**
     * A long form description of the project.
     * Will be formatted in markdown.
     */
    @NonNull String body;
    /**
     * The ID of the team that has ownership of this project
     */
    @NonNull
    public String team;
    /**
     * The optional organization of people that have ownership of this project.
     */
    @Nullable
    public String organization;
    /**
     * A message that a moderator sent regarding the project / The rejection data of the project
     * @deprecated moved to threads system
     */
    @Deprecated
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
     * The status of the project
     */
    @NonNull
    public ProjectStatus status;
    /**
     * The requested status of this projct
     */
    @NonNull
    @SerializedName("requested_status")
    public ProjectStatus requestedStatus;
    /**
     * The total number of downloads the project has
     */
    public int downloads;
    /**
     * The total number of users following the project
     */
    public int followers;
    /**
     * A list of the categories that the project belongs to.<br>
     * Eg: {@code ["utility"]}
     */
    @NonNull
    public List<@NonNull String> categories;
    /**
     * A list of the additional categories that the project belongs to.
     */
    @NonNull
    @SerializedName("additional_categories")
    public List<@NonNull String> additionalCategories;
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
    public List<@NonNull String> gameVersions;
    /**
     * A list of all of the loaders supported by the project<br>
     * Eg: {@code ["forge", "fabric", "quilt"]}
     */
    @NonNull
    public List<@NonNull String> loaders;
    /**
     * A list of images that have been uploaded to the project’s gallery
     */
    @NonNull
    public List<@NonNull GalleryEntry> gallery;
    @Nullable
    @SerializedName("icon_url")
    public String iconUrl;
    @Nullable
    @SerializedName("issues_url")
    public String issuesUrl;
    @Nullable
    @SerializedName("source_url")
    public String sourceUrl;
    @Nullable
    @SerializedName("wiki_url")
    public String wikiUrl;
    @Nullable
    @SerializedName("discord_url")
    public String discordUrl;
    @Nullable
    @SerializedName("donation_urls")
    public List<@NonNull DonationLink> donationUrls;
    /**
     * The thread of the moderation messages of the project
     */
    @NonNull
    public String threadId;
    @NonNull
    @SerializedName("monetization_status")
    public MonetizationStatus monetizationStatus;
}
