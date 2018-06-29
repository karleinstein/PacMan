package com.karleinstein.legend.view;

import javax.swing.*;

public class Gui extends JFrame implements ViewInitializer {
    public static final int WIDTH_FRAME = 560;
    public static final int HEIGHT_FRAME = 650;

    public Gui() {
        initContainer();
        initComponents();
        registerListeners();
    }

    @Override
    public void initContainer() {
        setTitle("Pac-Man demo");
        setLayout(null);
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void initComponents() {
        //add(new GamePlayPanel());
        add(new RootPanel());
        //add(new MenuPanel());
    }

    @Override
    public void registerListeners() {

    }
}
