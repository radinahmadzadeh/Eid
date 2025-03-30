package db;
import java.util.HashMap;
import java.util.Date;

public class Database {
    private static HashMap<Integer, Entity> entities = new HashMap<>();
    private static int idCounter = 1; // Counter for generating unique IDs

    public static void add(Entity entity) {
        if (entity instanceof Trackable) {
            Trackable trackableEntity = (Trackable) entity;
            Date currentDate = new Date();
            trackableEntity.setCreationDate(currentDate);
            trackableEntity.setLastModificationDate(currentDate);
        }
        entity.id = idCounter++;
        entities.put(entity.id, entity);
    }

    public static void update(Entity entity) {
        if (entity instanceof Trackable) {
            Trackable trackableEntity = (Trackable) entity;
            Date currentDate = new Date();
            trackableEntity.setLastModificationDate(currentDate);
        }
        entities.put(entity.id, entity);
    }

    public static Entity get(int id) {
        return entities.get(id);
    }
}
