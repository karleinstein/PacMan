package com.karleinstein.legend.model;

import com.karleinstein.legend.manager.ImageStore;

import java.awt.*;

public class Orange extends BaseModel {
    private Rectangle rectOrange;

    public Orange(int x, int y) {
        this.x = x;
        this.y = y;
        rectOrange = new Rectangle(x, y, SIZE, SIZE);
    }

    public void drawOrange(Graphics2D graphics2D) {
        if (!isDead) {
            switch (directionGhost) {
                case LEFT:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTOR3, x, y, SIZE, SIZE, null);
                    break;
                case RIGHT:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTOR1, x, y, SIZE, SIZE, null);
                    break;
                case UP:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTOR4, x, y, SIZE, SIZE, null);
                    break;
                case DOWN:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTOR2, x, y, SIZE, SIZE, null);
                    break;
                default:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTOR1, x, y, SIZE, SIZE, null);
                    break;
            }
        } else {
            graphics2D.drawImage(ImageStore.IMG_GHOST_SCARE, x, y, SIZE, SIZE, null);
        }
    }

    @SuppressWarnings("Duplicates")
    public void moveOrange() {
        switch (directionGhost) {
            case LEFT:
                rectOrange.setLocation(x - 1, y);
                    x--;
                break;
            case RIGHT:
                rectOrange.setLocation(x + 1, y);
                    x++;
                break;
            case UP:
                rectOrange.setLocation(x, y - 1);
                    y--;
                break;
            case DOWN:
                rectOrange.setLocation(x, y + 1);
                    y++;
                break;
            default:
                break;
        }

    }

    public Rectangle getRectOrange() {
        return rectOrange;
    }

    public void setDirection(int direction) {
        this.directionGhost = direction;
    }
}
