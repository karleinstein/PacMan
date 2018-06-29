package com.karleinstein.legend.model;

import com.karleinstein.legend.manager.ImageStore;

import java.awt.*;

public class MapItem extends BaseModel {
    public static final int TYPE_BRICK = 1;
    public static final int SIZE = 20;
    public static final int TYPE_FOOD = 2;
    public static final int TYPE_BIG_FOOD = 3;
    public static final int TYPE_WALL_GHOST = 4;
    public int type;

    public MapItem(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        rectangle=new Rectangle(x,y,SIZE,SIZE);
    }


    public void draw(Graphics2D graphics2D) {
        switch (type) {
            case TYPE_BRICK:
                graphics2D.drawImage(ImageStore.IMG_BRICK, x, y, SIZE, SIZE, null);
                break;
            case TYPE_FOOD:
                graphics2D.drawImage(ImageStore.IMG_FOOD, x, y, SIZE, SIZE, null);
                break;
            case TYPE_BIG_FOOD:
                graphics2D.drawImage(ImageStore.IMG_BIG_FOOD, x, y, SIZE, SIZE, null);
                break;
            case TYPE_WALL_GHOST:
                graphics2D.drawImage(ImageStore.IMG_WALL_GHOST, x, y, SIZE, SIZE, null);
                break;
            default:
                break;
        }
    }
}
