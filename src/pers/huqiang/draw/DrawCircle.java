package pers.huqiang.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @description: 演示如何在面板上画出圆形
 * @time: 2023-06-12 13:31
 * @version: 1.0
 * @author: Tiger_HQ
 */

public class DrawCircle extends JFrame {//JFrame对应窗口,可以理解成一个画框
    //定义一个面板
    private Mypanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();

    }
    public DrawCircle() {
        //初始化面板
        mp = new Mypanel();
        //把面板放入窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(400, 300);
        this.setVisible(true);
    }
}
//1.先定义一个面板MyPanel，继承JPanel类，画图形就在面板上画
class Mypanel extends JPanel {
    //说明:
    //1.MyPanel 对象就是一个画板
    //2.Graphics g 把g理解成一支画笔
    //3.Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//完成父类方法完成初始化
        //System.out.println("paint方法被调用。。。");
        //画出一个圆形
        g.drawOval(10, 10, 10, 10);
    }
}