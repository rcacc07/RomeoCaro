package com.caro.romeocaro.data.repository

import com.caro.romeocaro.data.User

class UserRepository {

    fun getUsers () : List<User> {
        return listOf(
            User(1,"romel","rcaro@gmail.com") ,
            User(2,"matheus","mcaro@gmail.com")
        )
    }
}