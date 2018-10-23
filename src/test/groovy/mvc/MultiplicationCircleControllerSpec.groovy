package mvc

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See http://guides.grails.org/grails-controller-testing/guide/index.html
 */
class MultiplicationCircleControllerSpec extends Specification implements ControllerUnitTest<MultiplicationCircleController> {

    @Unroll
    void "asking for #segments segments should provide #segments lines"(segments) {
        given:
            def model = new MultiplicationCircleModel(segmentCount: segments) // todo: add the table base when it is available
        when:
            controller.index(model)
        then:
            model.lines.size() == segments
        where:
            segments << [0, 1, 10, 100]
    }


}
