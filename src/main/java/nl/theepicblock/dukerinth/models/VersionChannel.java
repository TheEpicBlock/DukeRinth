package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;

public enum VersionChannel {
    @SerializedName("release")
    RELEASE,
    @SerializedName("beta")
    BETA,
    @SerializedName("alpha")
    ALPHA,
}
