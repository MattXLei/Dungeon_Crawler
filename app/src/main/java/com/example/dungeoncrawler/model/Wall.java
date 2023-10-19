package com.example.dungeoncrawler.model;

public class Wall {
    private static Location location;

    public Wall(Location location) {
        this.location = new Location(location.getxCord(), location.getyCord());
    }

    public static Location getLocation() {
        return location;
    }
    public static void setLocation(float newX, float newY) {
        Wall.location.setxCord(newX);
        Wall.location.setyCord(newY);
    }

}
