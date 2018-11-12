package mvc

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class CalculatorSpec extends GebSpec {

    // Defines a when-then workflow
    void "Basic calculation with secured access"() {
        when: "go to openly accessible start page"
            go '/static/GradeCalculator.html'
        then:
            title == "Grade Calculator"

        when: "set valid input"
            $("form").en = 5.0
            $("form").exam = 6.0
            $("input", type: "submit").click()

        then: "security intercepts and leads us to login"
            title == "Login"
        when:
            $("form").username = "guest"
            $("form").password = "guest"
            $("input", type: "submit").click()

        then: "successful login leads to requested page"
            title == "Average"
            $("output").text() == "5.5"


        when: "click on back link"
            $("a", text: "calculator").click()
        then:
            title == "Grade Calculator"


//        when: // currently logout raises js errors when testing...
//            go '/logout'
//        then:
//            title == 'Welcome to Grails'
    }
}
