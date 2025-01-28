package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;

public enum MonetizationStatus {
    @SerializedName("force-demonetized")
    FORCE_DEMONETIZED,
    @SerializedName("demonetized")
    DEMONETIZED,
    @SerializedName("monetized")
    MONETIZED,
}
