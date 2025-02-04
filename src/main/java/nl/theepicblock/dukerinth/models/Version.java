package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.File;
import java.time.Instant;
import java.util.List;

public class Version {
    /**
     * The name of this version
     */
    @NonNull
    public String name;
    /**
     * The version number. Ideally will follow semantic versioning
     */
    @NonNull
    @SerializedName("version_number")
    public String versionNumber;
    /**
     * The changelog for this version
     */
    @NonNull
    public String changelog;
    @NonNull
    public List<@NonNull DependencyInfo> dependencies;
    /**
     * A list of versions of Minecraft that this version supports
     */
    @SerializedName("game_versions")
    @NonNull
    public List<String> gameVersions;
    /**
     * The release channel for this version
     */
    @SerializedName("version_type")
    @NonNull
    public VersionChannel versionType;
    /**
     * The mod loaders that this version supports. In case of resource packs, use “minecraft”
     */
    @NonNull
    public List<@NonNull String> loaders;
    /**
     * Whether the version is featured or not
     */
    public boolean featured;
    @NonNull
    public VersionChannel status;
    @Nullable
    @SerializedName("requested_status")
    public VersionChannel requestedStatus;
    @NonNull
    public String id;
    @NonNull
    @SerializedName("project_id")
    public String projectId;
    @NonNull
    @SerializedName("date_published")
    public Instant datePublished;
    public int downloads;
    /**
     * A list of files available for download for this version
     */
    @NonNull
    public List<@NonNull VersionFile> files;
}
