package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.Instant;
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
    @SerializedName("payout_data")
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
    @SerializedName("avatar_url")
    @NonNull
    public String avatarUrl;
    /**
     * The time at which the user was created
     */
    public Instant created;
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
    @SerializedName("auth_providers")
    public List<String> authProviders;
    /**
     * Whether your email is verified (only displayed if requesting your own account)
     */
    @SerializedName("email_verified")
    @Nullable
    public Boolean emailVerified;
    /**
     * Whether you have a password associated with your account (only displayed if requesting your own account)
     */
    @SerializedName("has_password")
    @Nullable
    public Boolean hasPassword;
    /**
     * Whether you have TOTP two-factor authentication connected to your account (only displayed if requesting your own account)
     */
    @SerializedName("has_totp")
    @Nullable
    public Boolean hasTotp;

    /**
     * Checks if the user has a badge
     * @see Badges
     * @param badge The badge to be checked. Use the constants in {@link Badges}
     */
    public boolean hasBadge(int badge) {
        return this.badges != null && ((badges & badge) == 1);
    }
}
