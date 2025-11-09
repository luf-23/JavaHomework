package DesiginPatternHomework.Decorator;

public class HappySheep implements Sheep{
    private int lives = 5;

    @Override
    public void run() {
        System.out.println("喜羊羊正在奔跑...");
    }

    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public void loseLife() {
        if (lives > 0) {
            lives--;
            System.out.println("被灰太狼咬到！生命值减1，当前生命：" + lives);
        }
        if (lives == 0) {
            System.out.println("喜羊羊Game Over!");
        }
    }
}
