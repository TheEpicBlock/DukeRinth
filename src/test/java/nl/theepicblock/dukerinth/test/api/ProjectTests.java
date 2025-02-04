package nl.theepicblock.dukerinth.test.api;

import nl.theepicblock.dukerinth.VersionFilter;
import nl.theepicblock.dukerinth.models.ProjectStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

@EnabledIfEnvironmentVariable(named = "MR_API_TESTS", matches = "(true|TRUE)")
public class ProjectTests {
    @Test
    public void getModMenu() {
        var modmenu = Util.CLIENT.projects().getProject("modmenu");
        Assertions.assertNotNull(modmenu);
        Assertions.assertEquals("mOgUt4GM", modmenu.id);
//        Assertions.assertEquals("modmenu", modmenu.slug);
        Assertions.assertNotEquals(0, modmenu.loaders.size());
        Assertions.assertNotEquals(0, modmenu.gameVersions.size());
        Assertions.assertTrue(modmenu.versions.contains("M3KFXLhq"));
        Assertions.assertNull(modmenu.moderatorMessage); // Don't think we can read that
        Assertions.assertEquals(ProjectStatus.APPROVED, modmenu.status);
    }

    @Test
    public void modMenuVersions() {
        var oldVersions = Util.CLIENT.projects().getVersions("modmenu", VersionFilter.ofGameVersion("1.18.1"));
        for (var v : oldVersions) {
            Assertions.assertTrue(v.gameVersions.contains("1.18.1"));
        }
    }
}
