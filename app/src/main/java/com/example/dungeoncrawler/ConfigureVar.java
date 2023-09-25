package com.example.dungeoncrawler;

public class ConfigureVar {
    private static double difficulty = .5;

    private static int image;

    public static void setDifficulty(double difficulty) {
        ConfigureVar.difficulty = difficulty;
    }

    public static void setImage(int image) {
        ConfigureVar.image = image;
    }

    public static double getDifficulty() {
        return difficulty;
    }
}
