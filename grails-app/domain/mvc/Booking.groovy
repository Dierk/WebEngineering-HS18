package mvc

class Booking {

    Person booker
    Room   room
    Date   date
    String slot

    static String AM  = "08:15 - 12:00"
    static String PM1 = "12:15 - 15:00"
    static String PM2 = "15:15 - 18:00"

    static constraints = {
        room()
        booker()
        date(min: new Date().clearTime())
        slot(inList: [Booking.AM, Booking.PM1, Booking.PM2])
    }
}
