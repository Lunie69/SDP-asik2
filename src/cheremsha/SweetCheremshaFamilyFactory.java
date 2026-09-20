package cheremsha;

public class SweetCheremshaFamilyFactory implements CheremshaFamilyFactory {

    @Override
    public Cheremsha createCheremsha() {
        return new SweetCheremsha();
    }

    @Override
    public Sauce createSauce() {
        return new SweetSauce();
    }

    @Override
    public Seasoning createSeasoning() {
        return new SweetSeasoning();
    }
}