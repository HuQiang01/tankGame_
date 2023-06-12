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

        //画出tank-封装方法
        drawTank(hero.getX(), hero.getY(), g, 0, 0);


    }
    //画出坦克封装方法，编写方法，画出坦克。

    /**
     * @param x      坦克左上角x坐标
     * @param y      坦克左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向 上下左右
     * @param type   坦克类型 颜色区分
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0: //我们的tank
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的tank
                g.setColor(Color.yellow);
                break;
        }
        //根据tank的方向绘制tank
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出tank左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出tank右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出tank盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1:

            case 2:

            case 3:

            default:
                System.out.println("暂时没有处理");
        }
    }
}
