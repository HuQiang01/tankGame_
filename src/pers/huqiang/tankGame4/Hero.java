package pers.huqiang.tankGame4;

/**
 * @description: 自己的坦克
 * @time: 2023-06-12 16:44
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class Hero extends Tank {
    //定义一个Shot对象,表示一个射击行为
    Shot shot = null;
    public Hero(int x, int y) {
        super(x, y);
    }
    public void shotEnemyTank() {
        //创建Shot对象，根据当前Hero对象的位置和方向
        switch (getDirect()) {//得到Hero对象方向
            case 0://向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //启动我们的Shot线程
        new Thread(shot).start();
    }
}
