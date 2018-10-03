package mvc

class InPlaceCalculatorController {

    def calc(CalculatorModel model) {
        model.en = Math.round(model.en * 10) / 10
        model.exam = Math.round(model.exam * 10) / 10
        model.result = Math.round((model.en + model.exam) / 2)
        if (0.0 == model.en) {
            model.result = "Cannot calculate. En value was invalid."
        }
        if (0.0 == model.exam) {
            model.result = "Cannot calculate. Exam value was invalid."
        }
        render view: 'calc', model: [model: model]
    }
}

class CalculatorModel {

    double en = 0.0
    double exam = 0.0
    String result = ""
}
