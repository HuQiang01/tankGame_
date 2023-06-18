package pers.huqiang.tankGame3;

/**
 * @description:
 * @time: 2023-06-12 16:43
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class Tank {
    private int x;//坦克横坐标
    private int y;//坦克纵坐标
    private int direct;//表示坦克方向 0上 1右 2下 3左
    private int speed = 1;//表示tank的速度

    //上右下左移动
    public void moveUp() {
        y -= speed;
    }
    public void moveRight() {
        x += speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveLeft() {
        x -= speed;
    }

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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
