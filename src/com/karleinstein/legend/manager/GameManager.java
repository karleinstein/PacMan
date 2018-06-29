package com.karleinstein.legend.manager;

import com.karleinstein.legend.model.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    private ArrayList<MapItem> items;
    private ArrayList<MapItem> foods;
    private ArrayList<MapItem> wallGhosts;
    private ArrayList<MapItem> bigFoods;
    private int animation;
    private Red red;
    private Cyan cyan;
    private Orange orange;
    private int score;
    private int tempDirection;
    public static final int Columns = 29; //cot
    public static final int Rows = 28; //hang
    private Pac pac;

    public GameManager() {
        foods = new ArrayList<>();
        items = new ArrayList<>();
        wallGhosts = new ArrayList<>();
        bigFoods = new ArrayList<>();
        pac = new Pac(200, 320);
        red = new Red(520, 40);
        cyan = new Cyan(20, 40);
        orange = new Orange(300, 200);
    }


    public void setScore(int score) {
        this.score = score;
    }

    public void generateMap() {
        try {
            String path = GameManager.class.getResource("/res/assets/map.txt").getPath();
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            for (int i = 0; i < Columns; i++) {
                String line = br.readLine();
                for (int j = 0; j < Rows; j++) {
                    int type = line.charAt(j) - 48;
                    if (type != 0) {
                        int x = MapItem.SIZE * j;
                        int y = MapItem.SIZE * i;
                        MapItem mapItem = new MapItem(x, y, type);
                        switch (type) {
                            case MapItem.TYPE_BRICK:
                                items.add(mapItem);
                                break;
                            case MapItem.TYPE_WALL_GHOST:
                                wallGhosts.add(mapItem);
                                break;
                            case MapItem.TYPE_FOOD:
                                foods.add(mapItem);
                                break;
                            case MapItem.TYPE_BIG_FOOD:
                                bigFoods.add(mapItem);
                                break;
                            default:
                                break;
                        }
                    }


                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMap(Graphics2D graphics2D) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).draw(graphics2D);
        }
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).draw(graphics2D);
        }
        for (int i = 0; i < bigFoods.size(); i++) {
            bigFoods.get(i).draw(graphics2D);
        }
        for (int i = 0; i < wallGhosts.size(); i++) {
            wallGhosts.get(i).draw(graphics2D);
        }

    }


    public void drawPac(Graphics2D graphics2D) {
        pac.draw(graphics2D);
    }

    public void drawCyan(Graphics2D graphics2D) {
        cyan.drawCyan(graphics2D);
    }

    public void drawOrange(Graphics2D graphics2D) {
        orange.drawOrange(graphics2D);
    }

    public void drawRed(Graphics2D graphics2D) {
        red.drawRed(graphics2D);
    }

    public boolean isCyanCanMove() {
        if (isCyanCollisionWalls()) {
            return false;
        }
        return true;
    }

    public boolean isOrangeCanMove() {
        if (isOrangeCollisionWalls()) {
            return false;
        }
        return true;
    }

    public boolean isRedCanMove() {
        if (isRedCollisionWalls()) {
            return false;
        }
        return true;
    }


    public void gameOver() {

        if (cyan.getRectCyan().intersects(pac.getRectangle()) || orange.getRectOrange().intersects(pac.getRectangle()) ||
                red.getRectRed().intersects(pac.getRectangle())) {
            int options = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Game over", JOptionPane.YES_NO_OPTION);
            if (options == JOptionPane.YES_OPTION) {
                pac = new Pac(200, 320);
                red = new Red(520, 40);
                cyan = new Cyan(20, 40);
                orange = new Orange(300, 200);
                generateMap();
                score = 0;
            } else {
                System.exit(3);
            }
        }


    }


    public void moveCyan() {
        if (cyan.x < pac.x) {
            cyan.getRectCyan().setLocation(cyan.x + 1, cyan.y);
            if (isCyanCanMove()) {
                cyan.setDirection(Cyan.RIGHT);
                cyan.moveCyan();
            }

        }
        if (cyan.x > pac.x) {
            cyan.getRectCyan().setLocation(cyan.x - 1, cyan.y);
            if (isCyanCanMove()) {
                cyan.setDirection(Cyan.LEFT);
                cyan.moveCyan();
            }
        }
        if (cyan.y < pac.y) {
            cyan.getRectCyan().setLocation(cyan.x, cyan.y + 1);
            if (isCyanCanMove()) {
                cyan.setDirection(Cyan.DOWN);
                cyan.moveCyan();
            }
        }
        if (cyan.y > pac.y) {
            cyan.getRectCyan().setLocation(cyan.x, cyan.y - 1);
            if (isCyanCanMove()) {
                cyan.setDirection(Cyan.UP);
                cyan.moveCyan();
            }
        }
    }


    public void moveOrange() {
        if (orange.x < pac.x) {
            orange.getRectOrange().setLocation(orange.x + 1, orange.y);
            if (isOrangeCanMove()) {
                orange.setDirection(Orange.RIGHT);
                orange.moveOrange();
            }

        }
        if (orange.x > pac.x) {
            orange.getRectOrange().setLocation(orange.x - 1, orange.y);
            if (isOrangeCanMove()) {
                orange.setDirection(Orange.LEFT);
                orange.moveOrange();
            }
        }
        if (orange.y < pac.y) {
            orange.getRectOrange().setLocation(orange.x, orange.y + 1);
            if (isOrangeCanMove()) {
                orange.setDirection(Orange.DOWN);
                orange.moveOrange();
            }
        }
        if (orange.y > pac.y) {
            orange.getRectOrange().setLocation(orange.x, orange.y - 1);
            if (isOrangeCanMove()) {
                orange.setDirection(Orange.UP);
                orange.moveOrange();
            }
        }

    }

    public void moveRed() {
        if (red.x < pac.x) {
            red.getRectRed().setLocation(red.x + 1, red.y);
            if (isRedCanMove()) {
                red.setDirection(Red.RIGHT);
                red.moveRed();
            }

        }
        if (red.x > pac.x) {
            red.getRectRed().setLocation(red.x - 1, red.y);
            if (isRedCanMove()) {
                red.setDirection(Red.LEFT);
                red.moveRed();
            }
        }
        if (red.y < pac.y) {
            red.getRectRed().setLocation(red.x, red.y + 1);
            if (isRedCanMove()) {
                red.setDirection(Red.DOWN);
                red.moveRed();
            }
        }
        if (red.y > pac.y) {
            red.getRectRed().setLocation(red.x, red.y - 1);
            if (isRedCanMove()) {
                red.setDirection(Red.UP);
                red.moveRed();
            }
        }


    }


    private boolean isCyanCollisionWalls() {
        for (int i = 0; i < items.size(); i++) {
            if (isCyanCollisionWall(items.get(i))) {
                return true;
            }
        }
        for (int i = 0; i < wallGhosts.size(); i++) {
            if (isCyanCollisionWall(wallGhosts.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isRedCollisionWalls() {
        for (int i = 0; i < items.size(); i++) {
            if (isRedCollisionWall(items.get(i))) {
                return true;
            }
        }
        for (int i = 0; i < wallGhosts.size(); i++) {
            if (isRedCollisionWall(wallGhosts.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isOrangeCollisionWalls() {
        for (int i = 0; i < items.size(); i++) {
            if (isOrangeCollisionWall(items.get(i))) {
                return true;
            }
        }
        for (int i = 0; i < wallGhosts.size(); i++) {
            if (isOrangeCollisionWall(wallGhosts.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isPacCanMove() {
        if (isPacCollisionWalls()) {
            return false;
        }
        return true;
    }

    public void checkScore() {
        animation++;
        for (int i = 0; i < foods.size(); i++) {
            if (pac.getX() == foods.get(i).getX() && pac.getY() == foods.get(i).getY()) {
                score++;
                setScore(score);
                foods.remove(i);
            }
        }
        for (int i = 0; i < bigFoods.size(); i++) {
            if (pac.getX() == bigFoods.get(i).getX() && pac.getY() == bigFoods.get(i).getY()) {
                score += 5;
                setScore(score);
                bigFoods.remove(i);
                cyan.setDead(true);
                orange.setDead(true);
                red.setDead(true);
                System.out.println(animation);
            }
        }
        if (foods.size() == 0) {
            int options = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "You passed this game", JOptionPane.YES_NO_OPTION);
            if (options == JOptionPane.YES_OPTION) {
                generateMap();
                score = 0;
            } else {
                System.exit(3);
            }
        }
        if (animation == 1000) {
            cyan.setDead(false);
            orange.setDead(false);
            red.setDead(false);
            animation = 0;
        }
    }

    public int getScore() {
        return score;
    }

    private boolean isPacCollisionWalls() {
        for (int i = 0; i < items.size(); i++) {
            if (isPacCollisionWall(items.get(i))) {
                return true;
            }
        }
        for (int i = 0; i < wallGhosts.size(); i++) {
            if (isPacCollisionWall(wallGhosts.get(i))) {
                return true;
            }
        }
        return false;
    }


    public void movementCheck(int disiredDirection) {
        if (isValidDirection(disiredDirection)) {
            changePacDirection(disiredDirection);
            pac.setTheLastDirection(disiredDirection);
        }

    }

    private boolean isValidDirection(int disiredDirection) {
        int xRaw = pac.getX();
        int yRaw = pac.getY();
        switch (disiredDirection) {
            case Pac.LEFT:
                pac.rectangle.setLocation(xRaw - 1, yRaw);
                if (isPacCanMove()) {
                    tempDirection = Pac.LEFT;
                    return true;
                } else {
                    pac.rectangle.setLocation(xRaw, yRaw);
                }
                break;
            case Pac.RIGHT:
                pac.rectangle.setLocation(xRaw + 1, yRaw);
                if (isPacCanMove()) {
                    tempDirection = Pac.RIGHT;
                    return true;
                } else {
                    pac.rectangle.setLocation(xRaw, yRaw);
                }
                break;
            case Pac.UP:
                pac.rectangle.setLocation(xRaw, yRaw - 1);
                if (isPacCanMove()) {
                    tempDirection = Pac.UP;
                    return true;
                } else {
                    pac.rectangle.setLocation(xRaw, yRaw);
                }
                break;
            case Pac.DOWN:
                pac.rectangle.setLocation(xRaw, yRaw + 1);
                if (isPacCanMove()) {
                    tempDirection = Pac.DOWN;
                    return true;
                } else {
                    pac.rectangle.setLocation(xRaw, yRaw);
                }
                break;
            default:
                break;
        }
        return false;
    }

    public void movePac() {
        if (isPacCanMove()) {
            pac.move();
        } else {
            pac.setTheLastDirection(tempDirection);
        }
    }


    private boolean isPacCollisionWall(MapItem mapItem) {
        return pac.getRectangle().intersects(mapItem.getRectangle());
    }

    private boolean isOrangeCollisionWall(MapItem mapItem) {
        return orange.getRectOrange().intersects(mapItem.getRectangle());
    }

    private boolean isRedCollisionWall(MapItem mapItem) {
        return red.getRectRed().intersects(mapItem.getRectangle());
    }

    private boolean isCyanCollisionWall(MapItem mapItem) {
        return cyan.getRectCyan().intersects(mapItem.getRectangle());
    }


    public void changePacDirection(int direction) {
        if (pac.getDirection() != direction) {
            pac.setDirection(direction);
        }
    }
}
