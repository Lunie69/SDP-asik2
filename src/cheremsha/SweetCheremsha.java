package cheremsha;

public class SweetCheremsha implements Cheremsha {

    @Override
    public void prepare() {
        System.out.println("Preparing sweet cheremsha with sweet sauce.");
    }

    @Override
    public String getName() {
        return "Sweet Cheremsha";
    }
}