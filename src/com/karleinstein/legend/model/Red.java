package com.karleinstein.legend.model;

import com.karleinstein.legend.manager.ImageStore;

import java.awt.*;

public class Red extends BaseModel {
    private Rectangle rectRed;

    public Red(int x, int y) {
        this.x = x;
        this.y = y;
        rectRed = new Rectangle(x, y, SIZE, SIZE);
    }

    public void drawRed(Graphics2D graphics2D) {
        if (!isDead) {
            switch (directionGhost) {
                case LEFT:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTRED3, x, y, SIZE, SIZE, null);
                    break;
                case RIGHT:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTRED1, x, y, SIZE, SIZE, null);
                    break;
                case UP:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTRED4, x, y, SIZE, SIZE, null);
                    break;
                case DOWN:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTRED2, x, y, SIZE, SIZE, null);
                    break;
                default:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTRED1, x, y, SIZE, SIZE, null);
                    break;
            }
        } else {
            graphics2D.drawImage(ImageStore.IMG_GHOST_SCARE, x, y, SIZE, SIZE, null);
        }

    }

    @SuppressWarnings("Duplicates")
    public void moveRed() {
        switch (directionGhost) {
            case LEFT:
                rectRed.setLocation(x - 1, y);
                x--;

                break;
            case RIGHT:
                rectRed.setLocation(x + 1, y);
                x++;
                break;
            case UP:
                rectRed.setLocation(x, y - 1);
                y--;
                break;
            case DOWN:
                rectRed.setLocation(x, y + 1);
                y++;
                break;
            default:
                break;
        }

    }

    public Rectangle getRectRed() {
        return rectRed;
    }

    public void setDirection(int direction) {
        this.directionGhost = direction;
    }
}
