package mvc

class Person {

    String firstName
    String lastName
    String email

    String toString() {
        return firstName + " " + lastName
    }

    static constraints = {
        email(email: true)
        firstName(blank: false, maxSize: 40)
        lastName(minSize: 3, maxSize: 40)
    }
}
