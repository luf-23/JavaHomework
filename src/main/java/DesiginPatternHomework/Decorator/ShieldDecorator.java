package DesiginPatternHomework.Decorator;

public class ShieldDecorator extends SheepDecorator {

    private Boolean isShield = false;

    public ShieldDecorator(Sheep sheep) {
        super(sheep);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void loseLife() {
        // 保护罩生效：第一次攻击不掉血
        if (!isShield){
            isShield = true;
            System.out.println("保护罩吸收了伤害！生命值未减少。");
        }else{
            super.loseLife();
        }
    }
}
