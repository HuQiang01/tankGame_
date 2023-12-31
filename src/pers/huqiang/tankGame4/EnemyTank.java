package pers.huqiang.tankGame4;

import java.util.Map;
import java.util.Vector;

/**
 * @description:
 * @time: 2023-06-14 01:36
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector保存多个shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //这里我们判断如果shots.size < 1,创建一颗子弹放入到shots集合中
            if (isLive && shots.size() < 1) {
                Shot s = null;
                //根据坦克方向创建子弹
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(),0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20,1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60,0);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20,3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            //根据tank方向继续移动
            switch (getDirect()) {
                case 0://上
                    //让tank保持一个方向走30步
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://右
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://下
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //休眠50毫秒

            //然后随机的改变tank方向0-3
            setDirect((int)(Math.random() * 4));
            //什么时候推出线程
            if (!isLive) {
                break;
            }
        }
    }
}
