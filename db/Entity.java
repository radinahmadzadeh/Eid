package db;

public abstract class Entity {
    protected int id;
    private static int counter = 1;
    public Entity() {
        this.id = counter++;
    }
    public int getId() {
        return id;
    }
    public abstract Entity copy();
    public int getEntityCode() {
        return this.getClass().getSimpleName().hashCode();
    }
    public void setId(int i) {
    }
}
