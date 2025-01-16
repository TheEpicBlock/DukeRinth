package nl.theepicblock.dukerinth.models;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

public class User {
    /**
     * The user’s username
     */
    @NonNull
    public String username;
    /**
     * The user’s display name
     */
    @Nullable
    public String name;
    /**
     * The user’s email (only displayed if requesting your own account). Requires {@code USER_READ_EMAIL} PAT scope.
     */
    @Nullable
    public String email;
    /**
     * A description of the user
     */
    public String bio;
    /**
     * Various data relating to the user’s payouts status (you can only see your own)
     */
    @Nullable
    public PayoutData payoutData;
    /**
     * The user’s ID
     */
    @NonNull
    public String id;
    /**
     * The user’s avatar url
     */
    @NonNull
    public String avatar_url;
    /**
     * The time at which the user was created
     */
    public Date created;
    /**
     * The user’s role
     */
    public Role role;
    /**
     * Any badges applicable to this user. These are currently unused and undisplayed, and as such are subject to change
     * @see #hasBadge(int)
     */
    public Integer badges;
    /**
     * A list of authentication providers you have signed up for (only displayed if requesting your own account)
     *
     * <h1>Example:</h1>
     * {@code [
     *   "github",
     *   "gitlab",
     *   "steam",
     *   "microsoft",
     *   "google",
     *   "discord"
     * ]}
     */
    public List<String> auth_providers;
    /**
     * Whether your email is verified (only displayed if requesting your own account)
     */
    @Nullable
    public Boolean email_verified;
    /**
     * Whether you have a password associated with your account (only displayed if requesting your own account)
     */
    @Nullable
    public Boolean has_password;
    /**
     * Whether you have TOTP two-factor authentication connected to your account (only displayed if requesting your own account)
     */
    @Nullable
    public Boolean has_totp;

    /**
     * Checks if the user has a badge
     * @see Badges
     * @param badge The badge to be checked. Use the constants in {@link Badges}
     */
    public boolean hasBadge(int badge) {
        return this.badges != null && ((badges & badge) == 1);
    }
}
