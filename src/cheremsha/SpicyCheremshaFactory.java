package cheremsha;

public class SpicyCheremshaFactory extends CheremshaFactory {

    @Override
    public Cheremsha createCheremsha() {
        return new SpicyCheremsha();
    }
}