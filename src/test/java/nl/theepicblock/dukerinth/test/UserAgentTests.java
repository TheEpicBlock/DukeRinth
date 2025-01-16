package nl.theepicblock.dukerinth.test;

import nl.theepicblock.dukerinth.UserAgentBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAgentTests {
    @Test
    public void justName() {
        Assertions.assertEquals(
                "my_project",
                new UserAgentBuilder("my_project")
                        .toString());
    }

    @Test
    public void nameAndVersion() {
        Assertions.assertEquals(
                "my_project/1.0.0",
                new UserAgentBuilder("my_project")
                        .version("1.0.0")
                        .toString());
    }

    @Test
    public void nameAndComment() {
        Assertions.assertEquals(
                "my_project (hello)",
                new UserAgentBuilder("my_project")
                        .comment("hello")
                        .toString());
    }

    @Test
    public void nameAndEmail() {
        Assertions.assertEquals(
                "my_project (me@example.org)",
                new UserAgentBuilder("my_project")
                        .contactEmail("me@example.org")
                        .toString());
    }

    @Test
    public void nameAndUrl() {
        Assertions.assertEquals(
                "my_project (+https://example.org/info)",
                new UserAgentBuilder("my_project")
                        .contactUrl("https://example.org/info")
                        .toString());
    }

    @Test
    public void nameVersionAndEmail() {
        Assertions.assertEquals(
                "my_project/1.0.0 (me@example.org)",
                new UserAgentBuilder("my_project")
                        .version("1.0.0")
                        .contactEmail("me@example.org")
                        .toString());
    }

    @Test
    public void nameCommentAndEmail() {
        Assertions.assertEquals(
                "my_project (hello; me@example.org)",
                new UserAgentBuilder("my_project")
                        .comment("hello")
                        .contactEmail("me@example.org")
                        .toString());
    }

    @Test
    public void nameCommentAndUrl() {
        Assertions.assertEquals(
                "my_project (hello; +https://example.org/info)",
                new UserAgentBuilder("my_project")
                        .comment("hello")
                        .contactUrl("https://example.org/info")
                        .toString());
    }

    @Test
    public void nameCommentEmailAndUrl() {
        Assertions.assertEquals(
                "my_project (hello; +https://example.org/info; me@example.org)",
                new UserAgentBuilder("my_project")
                        .comment("hello")
                        .contactEmail("me@example.org")
                        .contactUrl("https://example.org/info")
                        .toString());
    }

    @Test
    public void nameVersionCommentEmailAndUrl() {
        Assertions.assertEquals(
                "my_project/1.0.0 (hello; +https://example.org/info; me@example.org)",
                new UserAgentBuilder("my_project")
                        .version("1.0.0")
                        .comment("hello")
                        .contactEmail("me@example.org")
                        .contactUrl("https://example.org/info")
                        .toString());
    }
}
