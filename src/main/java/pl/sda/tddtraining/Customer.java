package pl.sda.tddtraining;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter

public class Customer {
    private final String name;
    private final String lastName;
    private final Integer age;
    private final Integer salary;
    private final Integer id;
    @Setter(value = AccessLevel.PRIVATE)
    private static Integer counter = 1;

    public Customer(String name, String lastName, int age, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.id = counter++;
    }

    public Customer(String name, String lastName, int age, String salary) {
        this(name, lastName, age, Integer.valueOf(salary));
        // używamy pierwszego konstruktora; Stringa nie możemy rzutować na Integer, dlatego uzywamy metody valueOf
        //możemy rzutować tylko klasy, które dziedziczą z klasy na którą dziedziczymy
    }

    // piszemy poniższe metody aby nie wywalało błędu
    public String getCustomerNameWithLastName() {
        String tempName = getName();
        if (tempName == null) {
            tempName = "";
        }

        //tutaj zrobiliśmy if w ładniejszy sposób
        String tempLastName = getLastName() == null ? "" : getLastName();
        return tempName.trim() + " " + tempLastName.trim();
    }

    // BLANK to null oraz pusty ciąg znaków - jest to szerszy zakres
    // EMPTY to pusty ciąg znaków lub null

    public String getCustomerNameWithLastNameWthStringUtils() {
        return StringUtils.defaultIfBlank(getName(), "").trim()
                + (StringUtils.isBlank(getName()) ? "" : " ")
                + StringUtils.defaultIfBlank(getLastName(), "").trim();
    }
}
