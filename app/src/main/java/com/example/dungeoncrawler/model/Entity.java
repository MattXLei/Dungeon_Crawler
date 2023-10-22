package com.example.dungeoncrawler.model;

public abstract class Entity {
    MovementStrategy movementStrategy;

    Location location;

    public Entity() {
        movementStrategy = null;
        location = new Location(0.0f, 0.0f);
    }
    public Entity(MovementStrategy ms, Location location) {
        movementStrategy = ms;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public MovementStrategy getMovementStrategy() {

        return movementStrategy;
    }
}
