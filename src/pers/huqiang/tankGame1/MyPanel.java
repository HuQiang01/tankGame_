package pers.huqiang.tankGame1;

import javax.swing.*;
import java.awt.*;

/**
 * @description: 坦克大大战的绘图区域
 * @time: 2023-06-12 16:45
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;
    public MyPanel() {
        hero = new Hero(100, 100);//初始化子的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
    }
}
