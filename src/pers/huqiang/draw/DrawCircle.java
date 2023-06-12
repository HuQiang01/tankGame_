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
        System.out.println("exit the program");

    }
    public DrawCircle() {
        //初始化面板
        mp = new Mypanel();
        //把面板放入窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
//1.先定义一个面板MyPanel，继承JPanel类，画图形就在面板上画
class Mypanel extends JPanel {
    //说明:
    //1.MyPanel 对象就是一个画板
    //2.Graphics g 把g理解成一支画笔
    //3.Graphics 提供了很多绘图的方法
    //4.java绘图技术
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//完成父类方法完成初始化
        //System.out.println("paint方法被调用。。。");
        //画出一个圆形,画椭圆边框
        //g.drawOval(10, 10, 10, 10);
        //演示绘制不同的图形
        //画直线drawLine(int x1, int y2, int x2, int y2)
        //g.drawLine(10, 10, 100, 100);
        //画矩形边框
        //g.drawRect(10, 10, 100, 100);
        //填充矩形
        //g.setColor(Color.cyan);//设置颜色
        //g.fillRect(10, 10, 100, 100);
        //填充椭圆
        //g.setColor(Color.red);
        //g.fillOval(10, 10, 100, 100);
        //画图片
        //1.加载图片资源,/bg.png  表示在该项目的根目录获取图片资源
        //Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        //g.drawImage(image,10, 10, 175, 221, this);
        //画字符串，给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 50));
        g.drawString("北京你好", 100, 100);//100，100点位是字符串左下角


    }
}