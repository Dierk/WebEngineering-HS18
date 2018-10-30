package mvc

import grails.util.Environment

import javax.security.auth.login.FailedLoginException

class BootStrap {

    def init = { servletContext ->

        if(Environment.current != Environment.DEVELOPMENT) { // guard clause
            return;
        }

        Person dierk = new Person(firstName: "Dierk", lastName: "König", email: "dierk.koenig@fhnw.ch")
        dierk.save(flush: true, failOnError: true)

        for(int i = 0; i<1000; i++) {
            Person p = new Person(firstName: "first"+i, lastName: "last"+i, email: "a@b.com")
            p.save(failOnError: true)
        }

        Room r = new Room(description: "5.4D11", capacity: 40)
        r.save(failOnError: true);

        Date today = new Date().clearTime()
        Booking b = new Booking(booker: dierk, room: r, date: today, slot: Booking.AM)
        b.save(failOnError: true)
    }


    def destroy = {
    }
}
