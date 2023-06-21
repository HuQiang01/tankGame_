package pers.huqiang.tankGame4;

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
//为了让Panel不停的重绘子弹，需要将MyPanel实现一个Runnable接口当初线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    //定义一个Vector，用于存放炸弹
    //说明，当子弹击中tank时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        //初始的坦克
        hero = new Hero(500, 100);
        hero.setSpeed(4);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人tank
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置tank方向
            enemyTank.setDirect(2);
            //启动敌人tank线程，动起来
            new Thread(enemyTank).start();
            //给该enemyTank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            //立即启动shot对象
            new Thread(shot).start();
            enemyTanks.add(enemyTank);

        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        //画出自己的tank-封装方法
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //画出hero射击的子弹
//        if (hero.shot != null && hero.shot.isLive) {
//            g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
//        }
        //绘制一颗子弹
        if (hero.shot != null && hero.shot.isLive) {
            g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
        }
        //将hero的子弹集合遍历绘制取出
//        for (int i = 0; i < hero.shots.size(); i++) {
//            Shot shot = hero.shots.get(i);
//            if (shot != null && shot.isLive) {
//                g.draw3DRect(shot.x, shot.y, 1, 1, false);
//            } else {//如果该shot对象已经无效，就从shots集合中拿掉
//                hero.shots.remove(shot);
//            }
//        }
        //如果bombs集合中有炸弹，就画出
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            //根据当前的bomb的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让炸弹生命值减少
            bomb.lifeDown();
            //如果bomb.life的值为0，就从bombs的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
        //画出敌人的坦克,遍历Vector
        for (EnemyTank enemyTank : enemyTanks) {
            //从Vector取出tank
            if (enemyTank.isLive) {//当敌人tank是存活的才绘制该tank
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出enemyTank所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    //绘制子弹
                    if (shot.isLive) {//isLive == true
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
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
    //如果我们的tank可以发射多颗子弹
    //在判断我方子弹是否击中敌人tank时，就需要把我们子弹集合中所有的子弹取出和敌人所有tank进行判断
    //怎么写？？？












    //编写方法判断敌人tank是否击中我们的tank
    public  void hitHero() {
        //遍历所有的敌人tank
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人tank
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出当前enemyTank子弹
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中hero
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }



    //编写方法，判断我方的子弹是否击中敌人坦克
    //什么时候判断我方的子弹是否击中敌人tank？放到run方法比较好
    public void hitTank(Shot s, Tank Tank) {
        //判断s击中tank
        switch (Tank.getDirect()) {
            case 0://tank上
            case 2://tank下
                if (s.x > Tank.getX() && s.x < Tank.getX() + 40
                        && s.y > Tank.getY() && s.y < Tank.getY() + 60) {
                    s.isLive = false;
                    Tank.isLive = false;
                    //当我方子弹击中敌人坦克后，将enemyTank从Vector中移除
                    enemyTanks.remove(Tank);
                    //创建一个Bomb对象加入到bombs集合中
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://tank右
            case 3://tank左
                if (s.x > Tank.getX() && s.x < Tank.getX() + 60
                        && s.y > Tank.getY() && s.y < Tank.getY() + 40) {
                    s.isLive = false;
                    Tank.isLive = false;
                    //当我方子弹击中敌人坦克后，将enemyTank从Vector中移除
                    enemyTanks.remove(Tank);
                    //创建一个Bomb对象加入到bombs集合中
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                }
                break;

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
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }
        //如果用户按下J键，就发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //判断hero的子弹是否销毁，发射一颗子弹
            if (hero.shot == null || !hero.shot.isLive) {
                hero.shotEnemyTank();
            }
            //发射多颗子弹
//            hero.shotEnemyTank();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔10毫秒重绘区域
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断是否击中敌人坦克
            if (hero.shot != null && hero.shot.isLive) {
                //遍历敌人所有的tank
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot, enemyTank);
                }
            }
            //判断敌人子弹是否击中我方tank
            hitHero();
            this.repaint();
        }
    }
}
