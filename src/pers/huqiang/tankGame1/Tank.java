package pers.huqiang.tankGame1;

/**
 * @description:
 * @time: 2023-06-12 16:43
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class Tank {
    private int x;//坦克横坐标
    private int y;//塔克纵坐标

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
