package pers.huqiang.tankGame5;

/**
 * @description:
 * @time: 2023-06-18 20:53
 * @version: 1.0
 * @author: Tiger_HQ
 */
public class Bomb {
    int x, y;//炸弹的坐标
    int life = 9;//炸弹的生命周期
    boolean isLive = true;//是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //减少生命值
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
