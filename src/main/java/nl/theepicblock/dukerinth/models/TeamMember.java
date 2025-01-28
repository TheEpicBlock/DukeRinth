package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class TeamMember {
    /**
     * The ID of the team this team member is a member of
     */
    @NonNull
    @SerializedName("team_id")
    public String teamId;
    @NonNull
    public User user;
    /**
     * The user’s role on the team
     */
    @NonNull
    public String role;
    /**
     * The user’s permissions in bitfield format (requires authorization to view).
     * In an organization-controlled project, these are the unique overriding permissions for the user's role for any project in the organization, if they exist.
     * In an organization, these are the default project permissions for any project in the organization.
     * Guaranteed to not be {@code null} as long as you have permission to view
     * @see #hasPermission(int) 
     */
    public Integer permissions;
    /**
     * A bitset containing the user's permissions in this organization.
     * In a project team, this is {@code null}.
     */
    public Integer organization_permissions;
    /**
     * Whether the user has joined the team or is just invited to it
     */
    public boolean accepted;
    /**
     * The split of payouts going to this user. The proportion of payouts they get is their split divided by the sum of the splits of all members.
     */
    @SerializedName("payouts_split")
    public Double payoutsSplit;
    /**
     * The order of the team member.
     */
    public long ordering;
    /**
     * Checks if the user has a specific permission listed.
     * @param permission Use a constant from {@link ProjectPermissions}
     */
    public boolean hasPermission(int permission) {
        return this.permissions != null && ((this.permissions & permission) == 1);
    }
}
