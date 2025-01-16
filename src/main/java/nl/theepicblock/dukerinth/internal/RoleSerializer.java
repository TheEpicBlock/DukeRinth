package nl.theepicblock.dukerinth.internal;

import com.google.gson.*;
import nl.theepicblock.dukerinth.models.Role;

import java.lang.reflect.Type;

public class RoleSerializer implements JsonDeserializer<Role>, JsonSerializer<Role> {
    @Override
    public Role deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        var str = jsonElement.getAsString();
        if (str.equalsIgnoreCase("admin")) {
            return Role.ADMIN;
        }
        if (str.equalsIgnoreCase("moderator")) {
            return Role.MODERATOR;
        }
        if (str.equalsIgnoreCase("developer")) {
            return Role.DEVELOPER;
        }
        return null;
    }

    @Override
    public JsonElement serialize(Role role, Type type, JsonSerializationContext jsonSerializationContext) {
        switch (role) {
            case ADMIN: return new JsonPrimitive("admin");
            case MODERATOR: return new JsonPrimitive("moderator");
            case DEVELOPER: return new JsonPrimitive("developer");
            default: throw new IllegalStateException();
        }
    }
}
