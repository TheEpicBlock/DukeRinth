package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * An organization of users who control a project
 */
public class Organization {
    /**
     * The id of the organization
     */
    @NonNull
    public String id;
    /**
     * The slug of the organization
     */
    @NonNull
    public String slug;
    /**
     * The title of the organization
     */
    @NonNull
    public String name;
    /**
     * The associated team of the organization
     */
    @NonNull
    @SerializedName("team_id")
    public String teamId;
    /**
     * The description of the organization
     */
    @NonNull
    public String description;
    /**
     * The icon url of the organization
     */
    @Nullable
    @SerializedName("icon_url")
    public String iconUrl;
    /**
     * The color of the organization (picked from the icon)
     */
    @Nullable
    public Integer color;
    @NonNull
    public List<@NonNull TeamMember> members;
}
