package db;

import db.exception.InvalidEntityException;

public interface Validator {
    void validate(Object obj);

    void validate(Entity entity) throws InvalidEntityException;
}
