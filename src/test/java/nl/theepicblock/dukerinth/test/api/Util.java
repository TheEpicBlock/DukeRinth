package nl.theepicblock.dukerinth.test.api;

import nl.theepicblock.dukerinth.ModrinthApi;
import nl.theepicblock.dukerinth.UserAgentBuilder;

public class Util {
    public static final ModrinthApi CLIENT = new ModrinthApi(new UserAgentBuilder("dukerinth").comment("used for junit tests"));
}
