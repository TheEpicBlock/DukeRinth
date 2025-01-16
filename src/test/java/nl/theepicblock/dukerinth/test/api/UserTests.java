package nl.theepicblock.dukerinth.test.api;

import nl.theepicblock.dukerinth.ModrinthApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class UserTests {
    @Test
    public void getProspector() {
        var pros = Util.CLIENT.users().getUser("prospector");

        Assertions.assertNotNull(pros);
        Assertions.assertEquals("Dc7EYhxG", pros.id);
        Assertions.assertEquals(Instant.parse("2020-11-06T04:56:05.014379Z"), pros.created);

        // Can't access these
        Assertions.assertNull(pros.email);
        Assertions.assertNull(pros.payoutData);
    }

    @Test
    public void getBulk() {
        var users = Util.CLIENT.users().getUsers("prospector", "geometrically");

        Assertions.assertNotNull(users);
        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals("Dc7EYhxG", users.get(0).id);
        Assertions.assertEquals("MpxzqsyW", users.get(1).id);
    }
}
