package DesiginPatternHomework.State;

/**
 * 售罄状态 - 商品已售罄
 */
public class SoldOutState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("❌ 商品已售罄，无法投币！正在退币...");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("❌ 商品已售罄，无法选择");
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("⚠️ 商品已售罄");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("❌ 商品已售罄，无法出货");
    }

    @Override
    public String toString() {
        return "【售罄状态】商品已售罄";
    }
}
