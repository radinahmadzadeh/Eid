package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Map<Integer, Entity> entities = new HashMap<>();
    private static int idCounter = 1;
    public static void save(Entity entity) {
        entity.setId(idCounter++);
        entities.put(entity.getId(), entity);
    }
    public static Entity findById(int id) {
        return entities.get(id);
    }
    public static void update(Entity entity) {
        entities.put(entity.getId(), entity);
    }
    public static void delete(int id) {
        entities.remove(id);
    }
    public static ArrayList<Entity> getAll(int entityCode) {
        ArrayList<Entity> result = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity.getClass().getSimpleName().hashCode() == entityCode) {
                result.add(entity);
            }
        }
        return result;
    }
}
