package cheremsha;

public abstract class CheremshaFactory {

    public abstract Cheremsha createCheremsha();

    public void prepareCheremsha() {
        Cheremsha cheremsha = createCheremsha();

        System.out.println("Created: " + cheremsha.getName());
        cheremsha.prepare();
    }
}