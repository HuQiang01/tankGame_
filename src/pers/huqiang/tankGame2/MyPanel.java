package pers.huqiang.tankGame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @description: 坦克大大战的绘图区域
 * @time: 2023-06-12 16:45
 * @version: 1.0
 * @author: Tiger_HQ
 */
//为了实现监听事件 实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //定义敌人的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        //初始的坦克
        hero = new Hero(100, 100);
        hero.setSpeed(4);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人tank
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置tank方向
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        //画出自己的tank-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        //画出敌人的坦克,遍历Vector
        for (EnemyTank enemyTank : enemyTanks) {
            //取出tank
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
        }


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
            case 0: //敌人的tank
                g.setColor(Color.cyan);
                break;
            case 1: //我们的tank
                g.setColor(Color.yellow);
                break;
        }
        //根据tank的方向绘制不同形状的tank
        //direct表示方向0 1 2 3 上右下左
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出tank左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出tank右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出tank盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1://表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出tank上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出tank下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出tank盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2://表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出tank左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出tank右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出tank盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3://表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出tank上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出tank下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出tank盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wasd按下的键
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下W键
            //改变tank方向
            hero.setDirect(0);
            //修改坦克的坐标
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
