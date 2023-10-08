package ex202_contract;

public class Person {
    private final String id;
    private final PersonIdType idType;
    private final String firstName;
    private final String lastName;

    public Person(String id, PersonIdType idType, String firstName, String lastName) {
        this.id = id;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public PersonIdType getIdType() {
        return idType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public enum PersonIdType {
        BELGIAN_PASSPORT,
        INTERNATIONAL_PASSPORT
    }
}
