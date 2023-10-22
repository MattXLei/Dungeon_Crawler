package com.example.dungeoncrawler.model;

import android.util.Log;

public abstract class Entity {
    MovementStrategy movementStrategy;

    Location location;
    public Entity(MovementStrategy ms, Location location) {
        movementStrategy = ms;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(float newX, float newY) {
        location.setxCord(newX);
        location.setyCord(newY);
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
}
