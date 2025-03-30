package db;

import db.exception.InvalidEntityException;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    private static ArrayList<Entity> entities = new ArrayList<>();
    private static HashMap<Integer, Validator> validators = new HashMap<>();

    public static void registerValidator(int entityCode, Validator validator) {
        if (validators.containsKey(entityCode)) {
            throw new IllegalArgumentException("Validator for this entity code already exists.");
        }
        validators.put(entityCode, validator);
    }

    public static void add(Entity entity) throws InvalidEntityException {
        Validator validator = validators.get(entity.getEntityCode());
        if (validator != null) {
            validator.validate(entity);
        }
        entity = entity.copy();
        entities.add(entity);
    }

    public static void update(Entity entity) throws InvalidEntityException {
        Validator validator = validators.get(entity.getEntityCode());
        if (validator != null) {
            validator.validate(entity);
        }
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == entity.id) {
                entities.set(i, entity.copy());
                return;
            }
        }
        throw new InvalidEntityException("Entity with id " + entity.id + " not found.");
    }

    public static Entity get(int id) {
        for (Entity entity : entities) {
            if (entity.id == id) {
                return entity.copy();
            }
        }
        return null;
    }
}
