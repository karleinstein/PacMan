package com.karleinstein.legend.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootPanel extends BasePanel implements OnMenuSelectedListener {
    public static final int PANEL_WIDTH = 560;
    public static final int PANEL_HEIGHT = 650;
    private GamePlayPanel gamePlayPanel;
    private MenuPanel menuPanel;

    @Override
    public void initContainer() {
        setLayout(null);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setBackground(Color.BLACK);

    }

    @Override
    public void initComponents() {
        menuPanel = new MenuPanel();
        add(menuPanel);
    }

    @Override
    public void registerListeners() {
        menuPanel.setOnMenuSelectListener(this);
    }

    @Override
    public void onMenuSelectedListener(String name) {
        switch (name) {
            case "PLAY_GAME_PANEL":
                menuPanel.setVisible(false);
                gamePlayPanel = new GamePlayPanel();
                add(gamePlayPanel);
                menuPanel.playWav.stop();
                gamePlayPanel.setFocusable(true);
                gamePlayPanel.requestFocusInWindow();
                gamePlayPanel.validate();
                break;
            default:
                break;
        }
    }
}
