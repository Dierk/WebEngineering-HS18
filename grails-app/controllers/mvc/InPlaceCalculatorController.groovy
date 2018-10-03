package mvc

import grails.validation.Validateable

class InPlaceCalculatorController {

    def calc(CalculatorModel model) {
        model.en = Math.round(model.en * 10) / 10
        model.exam = Math.round(model.exam * 10) / 10
        model.result = Math.round((model.en + model.exam) / 2)
        if (model.errors.fieldErrors.any { it.field == "en" }) {
            model.result = "Cannot calculate. En value was invalid."
            // Determines the CSS class which should be used on client side
            model.en_error = "error"
            // Specifies the error message displayed as tooltip
            model.en_error_message = "value '$model.en' is not valid, must be between 1.0 and 6.0."
        }
        if (0.0 == model.exam) {
            model.result = "Cannot calculate. Exam value was invalid."
        }
        render view: 'calc', model: [model: model]
    }
}

// https://docs.grails.org/latest/guide/validation.html
// https://docs.grails.org/latest/ref/Constraints/Usage.html
class CalculatorModel implements Validateable {

    double en = 0.0
    double exam = 0.0
    String result = ""

    String en_error = ""
    String en_error_message = ""

    static constraints = {
        // scale: number of digits to the right of the decimal point
        en min: 1d, max: 6d, scale: 1
        exam min: 1d, max: 6d, scale: 1
        result nullable: true
    }
}
