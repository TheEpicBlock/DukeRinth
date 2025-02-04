package nl.theepicblock.dukerinth;

import java.util.List;

public class VersionFilter {
    protected List<String> loaders;
    protected List<String> gameVersions;
    protected Boolean featured;

    private VersionFilter(List<String> loaders, List<String> gameVersions, Boolean featured) {
        this.loaders = loaders;
        this.gameVersions = gameVersions;
        this.featured = featured;
    }

    public static VersionFilter all() {
        return new VersionFilter(null, null, null);
    }

    public static VersionFilter ofLoader(String loader) {
        return new VersionFilter(List.of(loader), null, null);
    }

    public static VersionFilter ofLoaders(List<String> loaders) {
        return new VersionFilter(loaders, null, null);
    }

    public static VersionFilter ofGameVersion(String version) {
        return new VersionFilter(null, List.of(version), null);
    }

    public static VersionFilter ofGameVersions(List<String> versions) {
        return new VersionFilter(null, versions, null);
    }

    public VersionFilter andGameVersion(String version) {
        this.gameVersions = List.of(version);
        return this;
    }

    public VersionFilter andGameVersions(List<String> version) {
        this.gameVersions = version;
        return this;
    }

    public VersionFilter andFeaturedOnly() {
        this.featured = true;
        return this;
    }

    public VersionFilter andNonFeaturedOnly() {
        this.featured = false;
        return this;
    }
}
