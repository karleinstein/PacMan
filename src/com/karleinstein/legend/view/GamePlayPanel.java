package com.karleinstein.legend.view;

import com.karleinstein.legend.manager.GameManager;
import com.karleinstein.legend.model.Pac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

public class GamePlayPanel extends BasePanel {
    public static final int PANEL_WIDTH = 560;
    public static final int PANEL_HEIGHT = 650;
    private GameManager gameManager;
    private Font font;
    private FontMetrics lbScoreFontMetrics;
    private BitSet bitSet;
    private JLabel lbScore;
    private JLabel lbScore2;

    @Override
    public void initContainer() {
        setLayout(null);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setBackground(Color.BLACK);
        gameManager = new GameManager();
        setFocusable(true);
        requestFocusInWindow();
        bitSet = new BitSet();
    }

    @Override
    public void initComponents() {
        gameManager.generateMap();
        font = new Font("Arial", Font.PLAIN, 20);
        lbScoreFontMetrics = getFontMetrics(font);
        lbScore = new JLabel("Score:");
        lbScore.setForeground(Color.RED);
        lbScore.setFont(font);
        lbScore.setLocation(0, 580);
        lbScore.setSize(lbScoreFontMetrics.stringWidth(lbScore.getText()), lbScoreFontMetrics.getHeight());
        add(lbScore);
        lbScore2 = new JLabel();
        add(lbScore2);
    }

    @Override
    public void registerListeners() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                bitSet.set(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                bitSet.set(e.getKeyCode(), false);
            }
        });
        startGame();
    }

    public void startGame() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lbScore2.setText(gameManager.getScore() + "");
                    lbScore2.setForeground(Color.GREEN);
                    lbScore2.setFont(font);
                    lbScore2.setLocation(lbScore.getWidth(), 580);
                    lbScore2.setSize(lbScoreFontMetrics.stringWidth(lbScore2.getText()), lbScoreFontMetrics.getHeight());
                    gameManager.checkScore();
                    gameManager.gameOver();
                    gameManager.moveCyan();
                    gameManager.moveOrange();
                    gameManager.moveRed();
                    if (bitSet.get(KeyEvent.VK_LEFT)) {
                        gameManager.movementCheck(Pac.LEFT);
                    }
                    if (bitSet.get(KeyEvent.VK_RIGHT)) {
                        gameManager.movementCheck(Pac.RIGHT);
                    }
                    if (bitSet.get(KeyEvent.VK_UP)) {
                        gameManager.movementCheck(Pac.UP);
                    }
                    if (bitSet.get(KeyEvent.VK_DOWN)) {
                        gameManager.movementCheck(Pac.DOWN);
                    }
                    gameManager.movePac();
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        gameManager.drawMap(graphics2D);
        gameManager.drawPac(graphics2D);
        gameManager.drawOrange(graphics2D);
        gameManager.drawCyan(graphics2D);
        gameManager.drawRed(graphics2D);


    }

}
