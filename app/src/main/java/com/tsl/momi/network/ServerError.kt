package com.tsl.momi.network

class ServerError {
    var current_password: List<String>? = null
    var email: List<String>? = null
    var username: List<String>? = null
    var password: List<String>? = null
    var first_name: List<String>? = null
    var last_name: List<String>? = null
    var location: List<String>? = null
    var paypal_email: List<String>? = null
    var gender: List<String>? = null
    var marital_status: List<String>? = null
    var children: List<String>? = null
    var birthday: List<String>? = null
    var avatar: List<String>? = null
    var provider: List<String>? = null
    var non_field_errors: List<String>? = null
    var new_email: List<String>? = null
    var token: List<String>? = null
    var detail: List<String>? = null
    var phone_number: List<String>? = null
    var code: String? = null

    fun getErrorString(): String {
        val result = StringBuilder()
        val newLine = System.getProperty("line.separator")

        //determine fields declared in this class only (no fields of superclass)
        val fields = this.javaClass.declaredFields

        //print field names paired with their values
        for (field in fields) {
            if (field.name == "serialVersionUID") {
                continue
            }
            try {
                //requires access to private field:
                if (field.get(this) != null && field.get(this) !== 0) {
                    result.append(field.get(this))
                }
            } catch (ex: IllegalAccessException) {
                println(ex)
            }

        }
        var str = result.toString()
        str = str.replace("\\[".toRegex(), "").replace("\\]".toRegex(), "")

        return str
    }
}