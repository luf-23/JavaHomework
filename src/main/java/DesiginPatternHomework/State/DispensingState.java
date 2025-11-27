package DesiginPatternHomework.State;

/**
 * 出货状态 - 正在出货
 */
public class DispensingState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("⚠️ 正在出货，请稍候...");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("⚠️ 正在出货，请稍候...");
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("❌ 商品正在出货，无法退币");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("✅ 商品已出货，请取走您的商品！");
        machine.reduceProductCount();
        
        if (machine.getProductCount() > 0) {
            System.out.println("📦 剩余商品数量：" + machine.getProductCount());
            machine.setState(machine.getIdleState());
        } else {
            System.out.println("🚫 商品已全部售罄");
            machine.setState(machine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return "【出货状态】正在出货...";
    }
}
