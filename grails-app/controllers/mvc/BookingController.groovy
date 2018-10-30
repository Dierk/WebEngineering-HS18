package mvc

class BookingController {

    static scaffold = Booking

    def foo() {

        // give me all the rooms that dierk has booked

        def dierk = Person.findByEmailLike("dierk%")
        def rooms = Booking.findAllByBooker(dierk).room

        println rooms

        render text: rooms.toString()
    }

}
