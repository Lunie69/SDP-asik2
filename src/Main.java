package cheremsha;

public class Main {

    public static void main(String[] args) {

        CheremshaFactory spicyFactory = new SpicyCheremshaFactory();
        CheremshaFactory sweetFactory = new SweetCheremshaFactory();

        Cheremsha spicyCheremsha = spicyFactory.createCheremsha();
        Cheremsha sweetCheremsha = sweetFactory.createCheremsha();

        System.out.println(spicyCheremsha.getName());
        spicyCheremsha.prepare();

        System.out.println();

        System.out.println(sweetCheremsha.getName());
        sweetCheremsha.prepare();
    }
}