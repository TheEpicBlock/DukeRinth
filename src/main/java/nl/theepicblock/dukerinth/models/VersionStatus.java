package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;

public enum VersionStatus {
    @SerializedName("listed")
    LISTED,
    @SerializedName("archived")
    ARCHIVED,
    @SerializedName("draft")
    DRAFT,
    @SerializedName("unlisted")
    UNLISTED,
    @SerializedName("scheduled")
    SCHEDULED,
    @SerializedName("unknown")
    UNKNOWN,
}
