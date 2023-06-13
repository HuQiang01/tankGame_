package pers.huqiang.tankGame2;

import javax.swing.*;

/**
 * @description:
 * @time: 2023-06-12 16:50
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class HqTankGame02 extends JFrame {
    //定义一个MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        HqTankGame02 hqTankGame01 = new HqTankGame02();
    }
    public HqTankGame02() {
        mp = new MyPanel();
        this.add(mp);//把面板加入窗口
        this.setSize(1000,750);
        this.addKeyListener(mp);//监听面板事件
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
