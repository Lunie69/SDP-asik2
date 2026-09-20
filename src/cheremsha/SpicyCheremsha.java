package cheremsha;

public class SpicyCheremsha implements Cheremsha {

    @Override
    public void prepare() {
        System.out.println("Preparing spicy cheremsha with hot sauce.");
    }

    @Override
    public String getName() {
        return "Spicy Cheremsha";
    }
}