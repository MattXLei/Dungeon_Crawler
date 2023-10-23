package com.example.dungeoncrawler.model;

public class Wall implements Observer{
    private static Location start;

    private static Location end;

    /*
       direction of a wall prevents an entity from moving past that wall in the saved direction
       0 = right, 1 = down, 2 = left, 3 = up
    */
    private static int direction;

    public Wall(Location start, Location end, int direction) {
        this.start = new Location(start.getxCord(), start.getyCord());
        this.end = new Location(end.getxCord(), end.getyCord());
        this.direction = direction;
    }

    public static Location getStart() {
        return start;
    }

    public static Location getEnd() {
        return end;
    }

    public static void setStart(float newX, float newY) {
        Wall.start.setxCord(newX);
        Wall.start.setyCord(newY);
    }

    public static void setEnd(float newX, float newY) {
        Wall.end.setxCord(newX);
        Wall.end.setyCord(newY);
    }

    public boolean checkCollision(Location entityLocation, int changeX, int changeY) {
        float newX = entityLocation.getxCord() + changeX;
        float newY = entityLocation.getyCord() + changeY;
        if (direction == 0) {
            if (newX > start.getxCord()) {
                return true;
            }
        }
        if (direction == 1) {
            if (newY > start.getyCord()) {
                return true;
            }
        }
        if (direction == 2) {
            if (newX < start.getxCord()) {
                return true;
            }
        }
        if (direction == 3) {
            if (newY < start.getxCord()) {
                return true;
            }
        }
        return false;
    }
}
