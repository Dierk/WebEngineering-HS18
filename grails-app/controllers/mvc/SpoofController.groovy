package mvc

class SpoofController {

    def index() {



        String msg = request
            .getHeaderNames()
            .collect { name -> name + ": " + request.getHeaders(name).toList() }
            .join("\n")

        render text: "<pre>" + msg + "</pre>"
    }
}
