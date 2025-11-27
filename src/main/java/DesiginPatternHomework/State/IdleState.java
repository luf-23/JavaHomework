package DesiginPatternHomework.State;

/**
 * 待机状态 - 等待用户投币
 */
public class IdleState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("💰 投币成功！请选择商品...");
        machine.setState(machine.getHasCoinState());
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("❌ 请先投币！");
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("❌ 您还没有投币，无需退币");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("❌ 请先投币并选择商品");
    }

    @Override
    public String toString() {
        return "【待机状态】等待投币...";
    }
}
