package id.kafka.kotlin_implementation.model

class Response {
    var code: Int
    var message: String
    var data: Any
    constructor(code: Int, message: String, data: Any?) {
        this.code = code
        this.message = message
        if (data != null) {
            this.data = data
        } else {
            this.data = {}
        }
    }
}