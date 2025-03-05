package at.htlle.pos;

import java.util.Objects;

public abstract class Entity {
    private int id;

    public Entity(){

    }

    public Entity(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) throw new IllegalArgumentException("Passed argument 'id' must not be negative");
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.valueOf(getId());
    }
}

