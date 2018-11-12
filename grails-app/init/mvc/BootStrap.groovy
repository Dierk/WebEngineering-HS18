package mvc

import grails.util.Environment
import mvs.SecRole
import mvs.SecUser
import mvs.SecUserSecRole

import javax.security.auth.login.FailedLoginException

class BootStrap {

    def init = { servletContext ->

        // in production or test, this might already be in the DB
        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole guestRole = save(SecRole.findOrCreateWhere(authority: SecRole.GUEST))


        SecUser guest  = save(new SecUser(username: 'guest', password: 'guest'))
        SecUserSecRole.create(guest, guestRole, true)

        if(Environment.current != Environment.DEVELOPMENT) { // guard clause
            return;
        }

        SecUser testUser  = save(new SecUser(username: 'me', password: 'toobad'))
        SecUserSecRole.create(testUser, adminRole, true) //flush

        // plausibility check
        assert SecRole.count()          == 2
        assert SecUser.count()          == 2
        assert SecUserSecRole.count()   == 2

        Person dierk = save(new Person(firstName: "Dierk", lastName: "König", email: "dierk.koenig@fhnw.ch"))

        for(int i = 0; i<10; i++) {
            save(new Person(firstName: "first"+i, lastName: "last"+i, email: "a@b.com"))
        }

        Room r = save(new Room(description: "5.4D11", capacity: 40))

        Date today = new Date().clearTime()
        Booking b = save(new Booking(booker: dierk, room: r, date: today, slot: Booking.AM))
    }

    static save(domainObject) {
        domainObject.save(failOnError: true, flush:true)
    }

    def destroy = {
    }
}
