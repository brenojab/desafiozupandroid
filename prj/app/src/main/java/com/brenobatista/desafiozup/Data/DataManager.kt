package com.brenobatista.desafiozup.Data

import com.brenobatista.desafiozup.Models.AppUser

class DataManager {
    val users = ArrayList<AppUser>()

    init {
        initializeAppUsers()
    }

    private fun initializeAppUsers() {
        users.add(AppUser("brenob", "brenozup"))
        users.add(AppUser("alexandrag", "alexandrazup"))
        users.add(AppUser("carlosg", "carloszup"))
    }

}