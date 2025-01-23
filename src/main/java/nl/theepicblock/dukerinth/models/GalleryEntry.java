package nl.theepicblock.dukerinth.models;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.Instant;

public class GalleryEntry {
    /**
     * The URL of the gallery image.<br>
     * Eg: {@code https://cdn.modrinth.com/data/AABBCCDD/images/009b7d8d6e8bf04968a29421117c59b3efe2351a.png}
     */
    @NonNull
    public String url;
    /**
     * Whether the image is featured in the gallery
     */
    @NonNull
    public boolean featured;
    /**
     * The title of the gallery image.<br>
     * Eg: {@code My awesome screenshot!}
     */
    @Nullable
    public String title;
    /**
     * The description of the gallery image.<br>
     * Eg: {@code This awesome screenshot shows all of the blocks in my mod!}
     */
    @Nullable
    public String description;
    /**
     * The date and time the gallery image was created
     */
    @NonNull
    public Instant created;
    /**
     * The order of the gallery image. Gallery images are sorted by this field and then alphabetically by title.
     */
    public int ordering;
}
