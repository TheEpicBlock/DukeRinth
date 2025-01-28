package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;

/**
 * A status decides the visibility of a project in search, URLs, and the whole site itself
 */
public enum ProjectStatus {
    /**
     * Project is displayed on search, and accessible by URL
     */
    @SerializedName("approved")
    APPROVED,
    @SerializedName("archived")
    ARCHIVED,
    /**
     * Project is not displayed on search, and not accessible by URL (Temporary state, project can reapply)
     */
    @SerializedName("rejected")
    REJECTED,
    /**
     * Project is not displayed on search, and not accessible by URL
     */
    @SerializedName("draft")
    DRAFT,
    /**
     * Project is not displayed on search, but accessible by URL
     */
    @SerializedName("unlisted")
    UNLISTED,
    /**
     * Project is not displayed on search, and not accessible by URL (Temporary state, project under review)
     */
    @SerializedName("processing")
    PROCESSING,
    /**
     * Same as unlisted, but set by a moderator. Cannot be switched to another type without moderator approval
     */
    @SerializedName("withheld")
    WITHHELD,
    /**
     * Project is scheduled to be released in the future
     */
    @SerializedName("scheduled")
    SCHEDULED,
    /**
     * Project is approved, but is not viewable to the public
     */
    @SerializedName("private")
    PRIVATE,
    @SerializedName("unknown")
    UNKNOWN,
}
