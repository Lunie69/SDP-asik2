package cheremsha;

public class SweetCheremshaFactory extends CheremshaFactory {

    @Override
    public Cheremsha createCheremsha() {
        return new SweetCheremsha();
    }
}