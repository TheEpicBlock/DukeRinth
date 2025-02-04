package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;

public enum VersionFileType {
    @SerializedName("required-resource-pack")
    REQUIRED_RESOURCE_PACK,
    @SerializedName("optional-resource-pack")
    OPTIONAL_RESOURCE_PACK,
}
