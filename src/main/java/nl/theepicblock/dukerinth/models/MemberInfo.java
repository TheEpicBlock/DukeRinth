package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class MemberInfo {
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
     * The user’s permissions in bitfield format (requires authorization to view)
     * @see #hasPermission(int) 
     */
    @Nullable
    public Integer permissions;
    /**
     * Whether or not the user has accepted to be on the team (requires authorization to view)
     */
    @Nullable
    public Boolean accepted;
    /**
     * The split of payouts going to this user. The proportion of payouts they get is their split divided by the sum of the splits of all members.
     */
    @SerializedName("payouts_split")
    public int payoutsSplit;
    /**
     * The order of the team member.
     */
    public int ordering;
    /**
     * Checks if the user has a specific permission listed.
     * @param permission Use a constant from {@link ProjectPermissions}
     */
    public boolean hasPermission(int permission) {
        return this.permissions != null && ((this.permissions & permission) == 1);
    }
}
