package mvc

import grails.plugin.springsecurity.annotation.Secured
import mvs.SecRole

@Secured(SecRole.ADMIN)
class PersonController {

    static scaffold = Person
}
