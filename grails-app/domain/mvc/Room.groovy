package mvc

class Room {

    String description
    int    capacity

    String toString() {
        return description + " (" + capacity + ")"
//        "$description ($capacity)" // groovy style
    }

    static constraints = {
        description(nullable: false, blank: false)
        capacity   (min:0)
    }
}
