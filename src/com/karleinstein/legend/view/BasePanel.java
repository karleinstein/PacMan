package com.karleinstein.legend.view;

import javax.swing.*;

public abstract class BasePanel extends JPanel implements ViewInitializer {
    public BasePanel(){
        initContainer();
        initComponents();
        registerListeners();
    }

}
