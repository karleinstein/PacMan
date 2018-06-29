package com.karleinstein.legend.model;

import com.karleinstein.legend.manager.ImageStore;
import com.karleinstein.legend.view.GamePlayPanel;

import java.awt.*;

public class Pac extends BaseModel {
    private Image[] imgRight;
    private Image[] imgUp;
    private Image[] imgDown;
    private Image[] imgLeft;
    private Image image;
    private int animation;
    private int direction;
    private int count;
    private int theLastDirection;

    public Pac(int x, int y) {
        this.x = x;
        this.y = y;
        imgRight = new Image[4];
        imgRight[0] = ImageStore.IMG_PAC;
        imgRight[1] = ImageStore.IMG_PAC_RIGHT1;
        imgRight[2] = ImageStore.IMG_PAC_RIGHT2;
        imgRight[3] = ImageStore.IMG_PAC_RIGHT3;
        imgLeft = new Image[4];
        imgLeft[0] = ImageStore.IMG_PAC;
        imgLeft[1] = ImageStore.IMG_PAC_LEFT1;
        imgLeft[2] = ImageStore.IMG_PAC_LEFT2;
        imgLeft[3] = ImageStore.IMG_PAC_LEFT3;
        imgUp = new Image[4];
        imgUp[0] = ImageStore.IMG_PAC;
        imgUp[1] = ImageStore.IMG_PAC_UP1;
        imgUp[2] = ImageStore.IMG_PAC_UP2;
        imgUp[3] = ImageStore.IMG_PAC_UP3;
        imgDown = new Image[4];
        imgDown[0] = ImageStore.IMG_PAC;
        imgDown[1] = ImageStore.IMG_PAC_DOWN1;
        imgDown[2] = ImageStore.IMG_PAC_DOWN2;
        imgDown[3] = ImageStore.IMG_PAC_DOWN3;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
    }

    public void setTheLastDirection(int theLastDirection) {
        this.theLastDirection = theLastDirection;
    }

    public void draw(Graphics2D graphics2D) {
        if (animation == 3) {
            animation = 0;
        }
        switch (direction) {
            case LEFT:
                image = imgLeft[animation];
                graphics2D.drawImage(image, x, y, SIZE, SIZE, null);
                break;
            case RIGHT:
                image = imgRight[animation];
                graphics2D.drawImage(image, x, y, SIZE, SIZE, null);
                break;
            case UP:
                image = imgUp[animation];
                graphics2D.drawImage(image, x, y, SIZE, SIZE, null);
                break;
            case DOWN:
                image = imgDown[animation];
                graphics2D.drawImage(image, x, y, SIZE, SIZE, null);
                break;
            default:
                graphics2D.drawImage(ImageStore.IMG_PAC, x, y, SIZE, SIZE, null);
                break;
        }
        count++;
        if (count == 5) {
            animation++;
        } else if (count > 5) {
            count = 0;
        }
    }

    public void move() {
        switch (theLastDirection) {
            case LEFT:
                x--;
                rectangle.setLocation(x - 1, y);
                break;
            case RIGHT:
                x++;
                rectangle.setLocation(x + 1, y);
                break;
            case UP:
                y--;
                rectangle.setLocation(x, y - 1);
                break;
            case DOWN:
                y++;
                rectangle.setLocation(x, y + 1);
                break;
            default:
                break;
        }
        if (x > GamePlayPanel.PANEL_WIDTH) {
            x = 0;
        }
        if (x < 0) {
            x = GamePlayPanel.PANEL_WIDTH;
        }

    }

    public int getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }
}
