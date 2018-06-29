package com.karleinstein.legend.model;

import com.karleinstein.legend.manager.ImageStore;
import com.karleinstein.legend.view.Gui;
import com.karleinstein.legend.view.MenuPanel;

import java.awt.*;

public class Title {
    private int x;
    private int y;
    private static final int SIZE = 40;
    private int animation;
    private int count;
    private int speed;
    private Image[] imageRight;

    public Title(int x, int y) {
        this.x = x;
        this.y = y;
        imageRight = new Image[4];
        imageRight[0] = ImageStore.IMG_PAC;
        imageRight[1] = ImageStore.IMG_PAC_RIGHT1;
        imageRight[2] = ImageStore.IMG_PAC_RIGHT2;
        imageRight[3] = ImageStore.IMG_PAC_RIGHT3;
        speed=2;
    }

    public void drawTitle(Graphics2D graphics2D) {
        count++;
        if (count == 10) {
            animation++;
            count = 0;
        }
        if (animation == 4) {
            animation = 0;
        }
        graphics2D.drawImage(imageRight[animation], x, y, SIZE, SIZE, null);
    }

    public void moveTitle() {
        x+=speed;
        if (x > MenuPanel.PANEL_WIDTH) {
            x = 0;
        }
    }
    public void drawCoin(Graphics2D graphics2D) {
        graphics2D.drawImage(ImageStore.IMG_FOOD, x +SIZE, y, SIZE, SIZE, null);
    }

    public void drawCyan(Graphics2D graphics2D) {
        graphics2D.drawImage(ImageStore.IMG_GHOSTRED1, x - SIZE-20, y, SIZE, SIZE, null);
    }

    public void drawOrange(Graphics2D graphics2D) {
        graphics2D.drawImage(ImageStore.IMG_GHOSTBLUE1, x - 2 * SIZE-40, y, SIZE, SIZE, null);
    }

    public void drawRed(Graphics2D graphics2D) {
        graphics2D.drawImage(ImageStore.IMG_GHOSTRED1, x - 3 * SIZE-60, y, SIZE, SIZE, null);
    }

}
