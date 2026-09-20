# SDP-asik2 | Factory Method & Abstract Factory

## 1. Project

**SDP-asik2 | Cheremsha Factory**

This project demonstrates two creational design patterns:

* Factory Method
* Abstract Factory

The project uses Cheremsha as the main product domain.

---

## 2. Product - Cheremsha

Cheremsha is a herb, a wild plant that resembles an onion.

It can be used in salads, sauces, pies, soups, or eaten in its pure form.

In this project, Cheremsha is represented through an interface, which allows different types of Cheremsha to be created.

---

# 3. Factory Method

## Product

The Product in the Factory Method is the `Cheremsha` interface.

It defines the common methods that every Cheremsha product must have:

```java
public interface Cheremsha {

    void prepare();

    String getName();
}
```

---

## Concrete Products

There are two Concrete Products:

* `SpicyCheremsha`
* `SweetCheremsha`

Both implement the `Cheremsha` interface.

For example:

```java
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
```

Another Concrete Product is:

```java
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
```

---

## Creator

The Creator is the abstract class `CheremshaFactory`.

It declares the Factory Method:

```java
public abstract class CheremshaFactory {

    public abstract Cheremsha createCheremsha();

    public void prepareCheremsha() {
        Cheremsha cheremsha = createCheremsha();

        System.out.println("Created: " + cheremsha.getName());
        cheremsha.prepare();
    }
}
```

The method `createCheremsha()` is the Factory Method because it defines how a `Cheremsha` object should be created, while the concrete factory decides which specific class will be created.

---

## Concrete Creators

There are two Concrete Creators:

* `SpicyCheremshaFactory`
* `SweetCheremshaFactory`

`SpicyCheremshaFactory` creates `SpicyCheremsha`:

```java
public class SpicyCheremshaFactory extends CheremshaFactory {

    @Override
    public Cheremsha createCheremsha() {
        return new SpicyCheremsha();
    }
}
```

`SweetCheremshaFactory` creates `SweetCheremsha`:

```java
public class SweetCheremshaFactory extends CheremshaFactory {

    @Override
    public Cheremsha createCheremsha() {
        return new SweetCheremsha();
    }
}
```

This means the client does not need to know how each concrete Cheremsha object is created.

---

# 4. Abstract Factory

The Abstract Factory extends the project by creating a complete family of related products.

There are three product types:

* Cheremsha
* Sauce
* Seasoning

There are two product families:

* Spicy family
* Sweet family

---

## Abstract Products

### Cheremsha

```java
public interface Cheremsha {

    void prepare();

    String getName();
}
```

### Sauce

```java
public interface Sauce {

    String getName();
}
```

### Seasoning

```java
public interface Seasoning {

    String getName();
}
```

Each interface defines a common contract for its product type.

---

## Concrete Products

### Spicy Family

The spicy family contains:

* `SpicyCheremsha`
* `SpicySauce`
* `SpicySeasoning`

### Sweet Family

The sweet family contains:

* `SweetCheremsha`
* `SweetSauce`
* `SweetSeasoning`

The products from the same family are designed to work together.

---

# 5. Abstract Factory Interface

The Abstract Factory is `CheremshaFamilyFactory`.

It has one creation method for every product type:

```java
public interface CheremshaFamilyFactory {

    Cheremsha createCheremsha();

    Sauce createSauce();

    Seasoning createSeasoning();
}
```

The factory can create a complete family of related products.

---

# 6. Concrete Factories

There are two Concrete Factories:

* `SpicyCheremshaFamilyFactory`
* `SweetCheremshaFamilyFactory`

## Spicy Factory

```java
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
```

It creates the complete spicy family:

```text
SpicyCheremsha
SpicySauce
SpicySeasoning
```

## Sweet Factory

```java
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
```

It creates the complete sweet family:

```text
SweetCheremsha
SweetSauce
SweetSeasoning
```

---

# 7. Client

The Client is the `Main` class.

The Client works with the Abstract Factory and Abstract Product interfaces instead of directly creating concrete products.

For example:

```java
CheremshaFamilyFactory spicyFamily =
        new SpicyCheremshaFamilyFactory();

showFamily(spicyFamily);
```

The `showFamily()` method receives the abstract factory:

```java
private static void showFamily(CheremshaFamilyFactory factory) {

    Cheremsha cheremsha = factory.createCheremsha();
    Sauce sauce = factory.createSauce();
    Seasoning seasoning = factory.createSeasoning();

    System.out.println("Cheremsha: " + cheremsha.getName());
    System.out.println("Sauce: " + sauce.getName());
    System.out.println("Seasoning: " + seasoning.getName());
}
```

The Client does not directly instantiate `SpicySauce`, `SweetSauce`, `SpicySeasoning`, or `SweetSeasoning`.

---

# 8. Project Structure

```text
cheremsha
│
├── Main.java
│
├── Cheremsha.java
├── SpicyCheremsha.java
├── SweetCheremsha.java
│
├── CheremshaFactory.java
├── SpicyCheremshaFactory.java
├── SweetCheremshaFactory.java
│
├── Sauce.java
├── SpicySauce.java
├── SweetSauce.java
│
├── Seasoning.java
├── SpicySeasoning.java
├── SweetSeasoning.java
│
├── CheremshaFamilyFactory.java
├── SpicyCheremshaFamilyFactory.java
└── SweetCheremshaFamilyFactory.java
```

---

# 9. 5 Clean Code Principles

## 1. Meaningful and intention-revealing names

### Before

```java
public class Factory1 {

    public Object create() {
        // ...
    }
}
```

The names do not clearly explain what the class or method does.

### After

```java
public class SpicyCheremshaFamilyFactory {

    public Cheremsha createCheremsha() {
        return new SpicyCheremsha();
    }
}
```

The names clearly show what the class creates and which product family it belongs to.

---

## 2. Small methods

Each method in the Concrete Factories has one simple responsibility.

For example:

```java
@Override
public Sauce createSauce() {
    return new SpicySauce();
}
```

This method only creates a sauce. It does not create other products or contain unrelated logic.

This makes the code easier to read and maintain.

---

## 3. Small and focused classes

Different classes have different responsibilities.

For example:

```text
SpicyCheremsha
    → represents spicy Cheremsha

SpicySauce
    → represents spicy sauce

SpicySeasoning
    → represents spicy seasoning

SpicyCheremshaFamilyFactory
    → creates the complete spicy family
```

Each class focuses on one main responsibility instead of putting all functionality into one large class.

---

## 4. Programming to interfaces

The Client works with interfaces instead of concrete implementations.

For example:

```java
CheremshaFamilyFactory spicyFamily =
        new SpicyCheremshaFamilyFactory();
```

and:

```java
Cheremsha cheremsha = factory.createCheremsha();
Sauce sauce = factory.createSauce();
Seasoning seasoning = factory.createSeasoning();
```

The code depends on `Cheremsha`, `Sauce`, `Seasoning`, and `CheremshaFamilyFactory` abstractions.

This makes it easier to replace one concrete family with another.

---

## 5. No unnecessary duplication / Centralized object creation

Instead of creating concrete products directly in the Client:

```java
SpicyCheremsha cheremsha = new SpicyCheremsha();
SpicySauce sauce = new SpicySauce();
SpicySeasoning seasoning = new SpicySeasoning();
```

the Client asks the factory to create them:

```java
Cheremsha cheremsha = factory.createCheremsha();
Sauce sauce = factory.createSauce();
Seasoning seasoning = factory.createSeasoning();
```

Object creation is centralized inside the Concrete Factories.

This keeps the Client simple and makes changing the product family easier.

---

# 10. How to Run

1. Open the project in IntelliJ IDEA.
2. Open `Main.java`.
3. Run the `main()` method.
4. The program demonstrates Factory Method.
5. The program then demonstrates Abstract Factory.
6. The created products and product families are displayed in the console.

## Example Output

```text
!Factory Method!
Spicy Cheremsha
Preparing spicy cheremsha with hot sauce.

Sweet Cheremsha
Preparing sweet cheremsha with sweet sauce.
!Abstract Factory!
Cheremsha: Spicy Cheremsha
Sauce: Hot & Spicy Sauce
Seasoning: Spicy Seasoning

Cheremsha: Sweet Cheremsha
Sauce: Sweet Sauce
Seasoning: Sweet Seasoning
```
