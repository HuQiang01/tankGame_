package pers.huqiang.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @description: 演示小球的上下左右移动-> 讲解Java的事件控制
 * @time: 2023-06-12 22:16
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class BallMove extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        //窗口JFrame对象 可以监听键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
//KeyListener 是监听器
class MyPanel extends JPanel implements KeyListener {
    //为了让小球可以移动，把他左上角的坐标(x,y)设置变量
    int x = 10, y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);//默认黑色。画出小球
    }
    //有字符输出时 该方法触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键松按下 该方法触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "被按下");
        //根据用户按下的不同键，来处理小球移动(上下左右键)
        //在java中会给每一个键分配一个值int类型
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        //让面板重绘
        this.repaint();

    }
    //当某个键松开了 该方法触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
