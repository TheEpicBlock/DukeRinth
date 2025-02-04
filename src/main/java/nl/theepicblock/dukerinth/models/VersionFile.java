package nl.theepicblock.dukerinth.models;

import com.google.gson.annotations.SerializedName;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Map;

public class VersionFile {
    @NonNull
    public Map<@NonNull String, @NonNull String> hashes;
    @NonNull
    public String url;
    @NonNull
    public String filename;
    public boolean primary;
    public int size;
    @SerializedName("file_type")
    @Nullable
    public VersionFileType fileType;
}
