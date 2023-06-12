package pers.huqiang.tankGame1;

import javax.swing.*;

/**
 * @description:
 * @time: 2023-06-12 16:50
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class HqTankGame01 extends JFrame {
    //定义一个MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        HqTankGame01 hqTankGame01 = new HqTankGame01();
    }
    public HqTankGame01() {
        mp = new MyPanel();
        this.add(mp);//把面板加入窗口
        this.setSize(1000,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
