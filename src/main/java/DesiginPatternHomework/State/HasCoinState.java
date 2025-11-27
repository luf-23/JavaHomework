package DesiginPatternHomework.State;

/**
 * 已投币状态 - 等待用户选择商品
 */
public class HasCoinState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("⚠️ 您已经投币，无需重复投币");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        if (machine.getProductCount() > 0) {
            System.out.println("🎯 商品已选择，正在出货...");
            machine.setState(machine.getDispensingState());
        } else {
            System.out.println("😢 抱歉，商品已售罄！正在退币...");
            machine.setState(machine.getSoldOutState());
        }
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("💸 退币成功！");
        machine.setState(machine.getIdleState());
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("❌ 请先选择商品");
    }

    @Override
    public String toString() {
        return "【已投币状态】请选择商品...";
    }
}
