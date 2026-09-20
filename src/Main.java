package cheremsha;

public class Main {

    public static void main(String[] args) {

        System.out.println("!Factory Method!");

        CheremshaFactory spicyFactory = new SpicyCheremshaFactory();
        Cheremsha spicyCheremsha = spicyFactory.createCheremsha();

        System.out.println(spicyCheremsha.getName());
        spicyCheremsha.prepare();

        System.out.println();

        CheremshaFactory sweetFactory = new SweetCheremshaFactory();
        Cheremsha sweetCheremsha = sweetFactory.createCheremsha();

        System.out.println(sweetCheremsha.getName());
        sweetCheremsha.prepare();


        System.out.println("!Abstract Factory!");

        CheremshaFamilyFactory spicyFamily =
                new SpicyCheremshaFamilyFactory();

        showFamily(spicyFamily);

        System.out.println();

        CheremshaFamilyFactory sweetFamily =
                new SweetCheremshaFamilyFactory();

        showFamily(sweetFamily);
    }

    private static void showFamily(CheremshaFamilyFactory factory) {

        Cheremsha cheremsha = factory.createCheremsha();
        Sauce sauce = factory.createSauce();
        Seasoning seasoning = factory.createSeasoning();

        System.out.println("Cheremsha: " + cheremsha.getName());
        System.out.println("Sauce: " + sauce.getName());
        System.out.println("Seasoning: " + seasoning.getName());
    }
}