package com.caro.romeocaro.domain.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.caro.romeocaro.data.User
import com.caro.romeocaro.data.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel(){


    private val _users = mutableStateOf<List<User>>(emptyList())
    val users : State<List<User>> = _users

    fun getUsers(){
        _users.value = userRepository.getUsers()
    }
}