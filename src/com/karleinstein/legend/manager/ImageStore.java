package com.karleinstein.legend.manager;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageStore {
    public static final Image IMG_BRICK = getImage("/res/drawable/wall.png");
    public static final Image IMG_FOOD = getImage("/res/drawable/bean_2.png");
    public static final Image IMG_BIG_FOOD = getImage("/res/drawable/bean_3.png");
    public static final Image IMG_WALL_GHOST = getImage("/res/drawable/wall_ghost.png");
    public static final Image IMG_PAC = getImage("/res/drawable/pacman_0_0.png");
    public static final Image IMG_PAC_RIGHT1 = getImage("/res/drawable/pacman_0_1.png");
    public static final Image IMG_PAC_RIGHT2 = getImage("/res/drawable/pacman_0_2.png");
    public static final Image IMG_PAC_RIGHT3 = getImage("/res/drawable/pacman_0_3.png");
    public static final Image IMG_PAC_DOWN1 = getImage("/res/drawable/pacman_1_1.png");
    public static final Image IMG_PAC_DOWN2 = getImage("/res/drawable/pacman_1_2.png");
    public static final Image IMG_PAC_DOWN3 = getImage("/res/drawable/pacman_1_3.png");
    public static final Image IMG_PAC_LEFT1 = getImage("/res/drawable/pacman_2_1.png");
    public static final Image IMG_PAC_LEFT2 = getImage("/res/drawable/pacman_2_2.png");
    public static final Image IMG_PAC_LEFT3 = getImage("/res/drawable/pacman_2_3.png");
    public static final Image IMG_PAC_UP1 = getImage("/res/drawable/pacman_3_1.png");
    public static final Image IMG_PAC_UP2 = getImage("/res/drawable/pacman_3_2.png");
    public static final Image IMG_PAC_UP3 = getImage("/res/drawable/pacman_3_3.png");
    public static final Image IMG_GHOSTRED1 = getImage("/res/drawable/ghost_0_0.png");
    public static final Image IMG_GHOSTRED2 = getImage("/res/drawable/ghost_0_2.png");
    public static final Image IMG_GHOSTRED3 = getImage("/res/drawable/ghost_0_4.png");
    public static final Image IMG_GHOSTRED4 = getImage("/res/drawable/ghost_0_6.png");
    public static final Image IMG_GHOSTBLUE1 = getImage("/res/drawable/ghost_2_0.png");
    public static final Image IMG_GHOSTBLUE2 = getImage("/res/drawable/ghost_2_2.png");
    public static final Image IMG_GHOSTBLUE3 = getImage("/res/drawable/ghost_2_4.png");
    public static final Image IMG_GHOSTBLUE4 = getImage("/res/drawable/ghost_2_6.png");
    public static final Image IMG_GHOSTOR1 = getImage("/res/drawable/ghost_3_0.png");
    public static final Image IMG_GHOSTOR2 = getImage("/res/drawable/ghost_3_2.png");
    public static final Image IMG_GHOSTOR3 = getImage("/res/drawable/ghost_3_4.png");
    public static final Image IMG_GHOSTOR4 = getImage("/res/drawable/ghost_3_6.png");
    public static final Image IMG_GHOST_SCARE=getImage("/res/drawable/ghost_vulnerable_0.png");

    public static Image getImage(String path) {
        URL url = ImageStore.class.getResource(path);
        return new ImageIcon(url).getImage();
    }
}
