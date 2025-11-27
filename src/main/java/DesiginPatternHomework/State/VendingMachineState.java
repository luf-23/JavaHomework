package DesiginPatternHomework.State;

/**
 * 状态接口 - 定义自动售货机的各种行为
 */
public interface VendingMachineState {
    /**
     * 投币
     */
    void insertCoin(VendingMachine machine);

    /**
     * 选择商品
     */
    void selectProduct(VendingMachine machine);

    /**
     * 退币
     */
    void refund(VendingMachine machine);

    /**
     * 出货
     */
    void dispense(VendingMachine machine);
}
