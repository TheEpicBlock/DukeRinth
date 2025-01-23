package nl.theepicblock.dukerinth.models;

import org.jspecify.annotations.Nullable;

public class License {
    /**
     * The SPDX license ID of a project
     * Eg: {@code LGPL-3.0-or-later}
     */
    public String id;
    /**
     * The long name of a license
     * Eg: {@code GNU Lesser General Public License v3 or later}
     */
    public String name;
    @Nullable
    /**
     * The URL to this license. Only used when the author provides a custom url.
     */
    public String url;
}
