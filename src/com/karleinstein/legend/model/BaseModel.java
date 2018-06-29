package com.karleinstein.legend.model;

import java.awt.*;

public abstract class BaseModel {
    public int x;
    public int y;
    public Rectangle rectangle;
    protected int directionGhost;
    protected boolean isDead=false;
    public static final int SIZE = 20;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
