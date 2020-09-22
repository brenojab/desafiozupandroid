package com.brenobatista.desafiozup.ViewModels

import androidx.lifecycle.ViewModel
import com.brenobatista.desafiozup.Data.ReposAdapter
import com.brenobatista.desafiozup.Services.createService

open class BaseViewModel : ViewModel() {

    val reposAdapter = ReposAdapter()
    var filterAdapter = ReposAdapter()

    val service = createService()
}