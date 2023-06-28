package pers.huqiang.tankGame5;

import javax.swing.*;

/**
 * @description:
 * @time: 2023-06-12 16:50
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class HqTankGame05 extends JFrame {
    //定义一个MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        HqTankGame05 hqTankGame01 = new HqTankGame05();
    }
    public HqTankGame05() {
        mp = new MyPanel();
        //将mp放入Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//把面板加入窗口
        this.setSize(1200,950);
        this.addKeyListener(mp);//监听面板事件
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
