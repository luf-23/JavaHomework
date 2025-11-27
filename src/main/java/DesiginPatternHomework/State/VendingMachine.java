package DesiginPatternHomework.State;

/**
 * 自动售货机 - 上下文类
 * 维护当前状态，并将行为委托给当前状态对象
 */
public class VendingMachine {
    // 所有可能的状态
    private VendingMachineState idleState;
    private VendingMachineState hasCoinState;
    private VendingMachineState dispensingState;
    private VendingMachineState soldOutState;

    // 当前状态
    private VendingMachineState currentState;

    // 商品数量
    private int productCount;

    public VendingMachine(int productCount) {
        // 初始化所有状态
        this.idleState = new IdleState();
        this.hasCoinState = new HasCoinState();
        this.dispensingState = new DispensingState();
        this.soldOutState = new SoldOutState();

        this.productCount = productCount;

        // 根据商品数量设置初始状态
        if (productCount > 0) {
            this.currentState = idleState;
        } else {
            this.currentState = soldOutState;
        }
    }

    /**
     * 投币
     */
    public void insertCoin() {
        System.out.println("\n➡️ 用户操作：投币");
        currentState.insertCoin(this);
    }

    /**
     * 选择商品
     */
    public void selectProduct() {
        System.out.println("\n➡️ 用户操作：选择商品");
        currentState.selectProduct(this);
    }

    /**
     * 退币
     */
    public void refund() {
        System.out.println("\n➡️ 用户操作：退币");
        currentState.refund(this);
    }

    /**
     * 出货
     */
    public void dispense() {
        currentState.dispense(this);
    }

    /**
     * 设置状态
     */
    public void setState(VendingMachineState state) {
        this.currentState = state;
        System.out.println("🔄 状态切换 → " + state);
    }

    /**
     * 减少商品数量
     */
    public void reduceProductCount() {
        if (productCount > 0) {
            productCount--;
        }
    }

    /**
     * 补货
     */
    public void refill(int count) {
        System.out.println("\n📦 管理员操作：补货 " + count + " 件");
        this.productCount += count;
        if (currentState == soldOutState && productCount > 0) {
            setState(idleState);
        }
        System.out.println("📊 当前库存：" + productCount + " 件");
    }

    // Getters
    public int getProductCount() {
        return productCount;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public VendingMachineState getSoldOutState() {
        return soldOutState;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }
}
