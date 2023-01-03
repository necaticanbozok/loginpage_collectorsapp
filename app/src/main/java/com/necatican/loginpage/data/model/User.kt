package com.necatican.loginpage.data.model

data class  User(
    var userName: String? = null,
    var userSurname: String? = null,
    var userMail: String? = null,
    var userPassword: String? = null,
    var favouriteList: List<UserList>?= null,
    var itemList: List<UserList>?= null,
    var favouriteSellersList: List<SellersList>?= null,
)

data class SellersList (
    var userName:String?=null
)

data class UserList(
    var itemPrice:String?=null,
    var itemTitle:String?=null
)

