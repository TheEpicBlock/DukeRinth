package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;

public enum DependencyType {
    @SerializedName("required")
    REQUIRED,
    @SerializedName("optional")
    OPTIONAL,
    @SerializedName("incompatible")
    INCOMPATIBLE,
    @SerializedName("embedded")
    EMBEDDED,
}
