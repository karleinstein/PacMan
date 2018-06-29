package com.karleinstein.legend.model;

import com.karleinstein.legend.manager.ImageStore;

import java.awt.*;

public class Cyan extends BaseModel {
    private Rectangle rectCyan;

    public Cyan(int x, int y) {
        this.x = x;
        this.y = y;
        rectCyan = new Rectangle(x, y, SIZE, SIZE);
    }

    @SuppressWarnings("Duplicates")
    public void moveCyan() {
        switch (directionGhost) {
            case LEFT:
                rectCyan.setLocation(x - 1, y);
                x--;
                break;
            case RIGHT:
                rectCyan.setLocation(x + 1, y);
                x++;

                break;
            case UP:
                rectCyan.setLocation(x, y - 1);
                y--;
                break;
            case DOWN:
                rectCyan.setLocation(x, y + 1);
                y++;
                break;
            default:
                break;
        }

    }


    public void drawCyan(Graphics2D graphics2D) {
        if (!isDead) {
            switch (directionGhost) {
                case LEFT:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTBLUE3, x, y, SIZE, SIZE, null);
                    break;
                case RIGHT:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTBLUE1, x, y, SIZE, SIZE, null);
                    break;
                case UP:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTBLUE4, x, y, SIZE, SIZE, null);
                    break;
                case DOWN:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTBLUE2, x, y, SIZE, SIZE, null);
                    break;
                default:
                    graphics2D.drawImage(ImageStore.IMG_GHOSTBLUE1, x, y, SIZE, SIZE, null);
                    break;
            }
        } else {
            graphics2D.drawImage(ImageStore.IMG_GHOST_SCARE, x, y, SIZE, SIZE, null);
        }
    }

    public Rectangle getRectCyan() {
        return rectCyan;
    }

    public void setDirection(int direction) {
        this.directionGhost = direction;
    }

}
