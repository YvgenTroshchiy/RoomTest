package com.troshchiy.roomtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.troshchiy.roomtest.db.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel class MainViewModel @Inject constructor(private val repository: UsersRepository) : ViewModel() {

    fun fillDb() {
        viewModelScope.launch(Dispatchers.IO) { repository.fillDb() }
    }

    fun clearDb() {
        viewModelScope.launch(Dispatchers.IO) { repository.clearDb() }
    }

    fun logDataBase() {
        viewModelScope.launch(Dispatchers.IO) { repository.logDataBase() }
    }
}
