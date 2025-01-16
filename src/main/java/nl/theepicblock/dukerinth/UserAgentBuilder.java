package nl.theepicblock.dukerinth;

public class UserAgentBuilder {
    private String projectName;
    private String version;
    private String comment;
    private String url;
    private String email;

    /**
     * Create a new user agent for a project
     * @param name the name of the project. For example: {@code project_name}, {@code github_username/project_name}
     */
    public UserAgentBuilder(String name) {
        this.projectName = name;
    }

    /**
     * Adds version information about your project
     */
    public UserAgentBuilder version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Add any miscellaneous details
     */
    public UserAgentBuilder comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Adds contact information in the form of a url.
     * This is highly recommended when calling modrinth api's.
     * Examples:
     * {@code https://yourproject.com/}
     * {@code https://github.com/username/project}
     */
    public UserAgentBuilder contactUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Adds contact information in the form of an email.
     * This is highly recommended when calling modrinth api's.
     * Examples:
     * {@code myemailaddress@gmail.com}
     */
    public UserAgentBuilder contactEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(projectName);
        if (version != null) {
            builder.append("/");
            builder.append(version);
        }

        if (comment != null || email != null || url != null) {
            builder.append(" (");
            if (comment != null) {
                builder.append(comment);
            }
            if (url != null) {
                if (comment != null) {
                    builder.append("; ");
                }
                builder.append("+");
                builder.append(url);
            }
            if (email != null) {
                if (comment != null || url != null) {
                    builder.append("; ");
                }
                builder.append(email);
            }
            builder.append(")");
        }
        return builder.toString();
    }
}
