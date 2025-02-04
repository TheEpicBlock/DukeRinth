package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class DependencyInfo {
    /**
     * The ID of the version that this version depends on
     */
    @Nullable
    @SerializedName("version_id")
    public String versionId;
    /**
     * The ID of the project that this version depends on
     */
    @Nullable
    @SerializedName("project_id")
    public String projectId;
    /**
     * The file name of the dependency, mostly used for showing external dependencies on modpacks
     */
    @Nullable
    @SerializedName("file_name")
    public String fileName;
    @NonNull
    @SerializedName("dependency_type")
    public DependencyType dependencyType;
}
