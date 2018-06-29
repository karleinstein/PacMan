package com.karleinstein.legend.view;

import com.karleinstein.legend.manager.PlayWav;
import com.karleinstein.legend.model.Title;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPanel extends BasePanel implements ActionListener {
    public static final int PANEL_WIDTH = 560;
    public static final int PANEL_HEIGHT = 650;
    private JLabel imageTitle;
    private JButton btnEasy;
    private static final String ACTION_PLAY_GAME = "ACTION_PLAY_GAME";
    private Title title;
    private OnMenuSelectedListener onMenuSelectListener;
    private ImageIcon imageIcon;
    public PlayWav playWav;

    @Override
    public void initContainer() {
        setLayout(null);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setBackground(Color.GRAY);
        title = new Title(200, 400);
        playWav = new PlayWav("begin");
        playWav.play();
        playWav.loop(-1);
    }

    @Override
    public void initComponents() {

        Font font = new Font("Arial", Font.BOLD, 30);
        FontMetrics lbTibleFontMetrics = getFontMetrics(font);
        int lblbHeight = lbTibleFontMetrics.getHeight();
        try {
            imageIcon = new ImageIcon(ImageIO.read(getClass().getResource("/res/drawable/title.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //imageTitle.setFont(font);)
        imageTitle = new JLabel();
        //imageTitle.setForeground(Color.RED);
        imageTitle.setBounds(200, 150, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        imageTitle.setIcon(imageIcon);
        add(imageTitle);
        btnEasy = new JButton("PLAY");
        btnEasy.setFont(font);
        int lbWidth = lbTibleFontMetrics.stringWidth(btnEasy.getText());
        //btnEasy.setOpaque(true);
        btnEasy.setForeground(Color.RED);
        btnEasy.setBounds((PANEL_WIDTH - imageTitle.getX()) / 2 + 45, imageTitle.getHeight() + 200, lbWidth + 50, lblbHeight);
        add(btnEasy);
        startTitle();
    }


    @Override
    public void registerListeners() {
        btnEasy.setActionCommand(ACTION_PLAY_GAME);
        btnEasy.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ACTION_PLAY_GAME:
                onMenuSelectListener.onMenuSelectedListener("PLAY_GAME_PANEL");
                break;
            default:
                break;
        }
    }

    public void setOnMenuSelectListener(OnMenuSelectedListener onMenuSelectListener) {
        this.onMenuSelectListener = onMenuSelectListener;
    }

    private void startTitle() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        title.moveTitle();
                        repaint();
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
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
        title.drawCoin(graphics2D);
        title.drawTitle(graphics2D);
        title.drawCyan(graphics2D);
        title.drawOrange(graphics2D);
        title.drawRed(graphics2D);
    }
}
