package com.necatican.loginpage

class User {
    var user_no: Int = 0
    var user_name: String= ""
    var user_mail:String= ""

    constructor(user_no:Int, user_name:String,user_mail:String){
        this.user_no= user_no
        this.user_name= user_name
        this.user_mail= user_mail


    }
}