package pers.huqiang.tankGame5;

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
    //增加一个成员，EnemyTank可以得到所有敌人tank的Vector
    //分析
    //1.
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }
    //提供一个人方法可以将MyPanel的成员Vector<EnemyTank> enemyTanks = new Vector<>();
    //设置到我们的enemyTank的成员
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }
    //编写方法，判断当前这个敌人tank是否和enemyTanks中的其他坦克重叠活碰撞
    public boolean isTouchEnemytank() {
        //判断当前敌人坦克（this）方向
        switch (this.getDirect()) {
            case 0://上
                //让当前敌人tank和其他所有敌人tank比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        //分析
                        //1.如果敌人tank是上下方向，x的范围【enemytank.getX(),enemytank.getX()+40】
                        //  y的范围【enemytank.getY(),enemytank.getY()+60】
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //2.当前坦克左上角的坐标x 【this.getX(),this.getY(),】

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克右上角的坐标x 【this.getX()+40,this.getY(),】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左右方向
                        //分析
                        //1.如果敌人tank是左右方向，x的范围【enemytank.getX(),enemytank.getX()+60】
                        //  y的范围【enemytank.getY(),enemytank.getY()+40】
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //2.当前坦克左上角的坐标x 【this.getX(),this.getY(),】

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克右上角的坐标x 【this.getX()+40,this.getY(),】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        //分析
                        //1.如果敌人tank是上下方向，x的范围【enemytank.getX(),enemytank.getX()+40】
                        //  y的范围【enemytank.getY(),enemytank.getY()+60】
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //2.当前坦克右上角的坐标x 【this.getX()+ 60,this.getY(),】

                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克右下角的坐标x 【this.getX()+60,this.getY()+40,】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左右方向
                        //分析
                        //1.如果敌人tank是左右方向，x的范围【enemytank.getX(),enemytank.getX()+60】
                        //                      y的范围【enemytank.getY(),enemytank.getY()+40】
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //2.当前坦克右上角的坐标x 【this.getX() +60,this.getY(),】

                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克右下角的坐标x 【this.getX()+60,this.getY()+40,】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        //分析
                        //1.如果敌人tank是上下方向，x的范围【enemytank.getX(),enemytank.getX()+40】
                        //  y的范围【enemytank.getY(),enemytank.getY()+60】
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //2.当前坦克左下角的坐标x 【this.getX(),this.getY() + 60,】

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克右下角的坐标x 【this.getX()+40,this.getY()+60,】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左右方向
                        //分析
                        //1.如果敌人tank是左右方向，x的范围【enemytank.getX(),enemytank.getX()+60】
                        //                      y的范围【enemytank.getY(),enemytank.getY()+40】
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //2.当前坦克左下角的坐标x 【this.getX(),this.getY()+60,】

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克右下角的坐标x 【this.getX()+40,this.getY()+60,】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        //分析
                        //1.如果敌人tank是上下方向，x的范围【enemytank.getX(),enemytank.getX()+40】
                        //  y的范围【enemytank.getY(),enemytank.getY()+60】
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //2.当前坦克左上角的坐标x 【this.getX(),this.getY()】

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克左下角的坐标x 【this.getX(),this.getY()+40,】
                            if (this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左右方向
                        //分析
                        //1.如果敌人tank是左右方向，x的范围【enemytank.getX(),enemytank.getX()+60】
                        //                      y的范围【enemytank.getY(),enemytank.getY()+40】
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //2.当前坦克左上角的坐标x 【this.getX(),this.getY()+40,】

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY()>= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克右下角的坐标x 【this.getX(),this.getY()+40,】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
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
                        if (getY() > 0 && !isTouchEnemytank()) {
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
                        if (getX() + 60 < 1000 && !isTouchEnemytank()) {
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
                        if (getY() + 60 < 750 && !isTouchEnemytank()) {
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
                        if (getX() > 0 && !isTouchEnemytank()) {
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
