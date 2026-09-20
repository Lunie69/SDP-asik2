package cheremsha;

public class SpicyCheremshaFamilyFactory implements CheremshaFamilyFactory {

    @Override
    public Cheremsha createCheremsha() {
        return new SpicyCheremsha();
    }

    @Override
    public Sauce createSauce() {
        return new SpicySauce();
    }

    @Override
    public Seasoning createSeasoning() {
        return new SpicySeasoning();
    }
}