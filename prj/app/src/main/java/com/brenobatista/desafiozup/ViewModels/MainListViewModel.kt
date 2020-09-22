package com.brenobatista.desafiozup.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.brenobatista.desafiozup.Data.ReposAdapter
import com.brenobatista.desafiozup.Models.ServicesResult
import com.brenobatista.desafiozup.Services.createService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainListViewModel : ViewModel() {

    val reposAdapter = ReposAdapter()
    var filterAdapter = ReposAdapter()

    val service = createService()

    fun initSearchService(){
        return service.getServices().enqueue(object : Callback<ServicesResult> {
            override fun onFailure(call: Call<ServicesResult>, t: Throwable) {
                // Tratar exceções
                Log.wtf("GET_DATA_ERROR", "Erro ao obter dados do serviço", t)
            }

            override fun onResponse(
                call: Call<ServicesResult>,
                response: Response<ServicesResult>
            ) {
                try {
                    val data = response.body()
                    val repos = data?.services

                    if (repos?.count()!! > 0)
                        reposAdapter.submitList(repos)

                } catch (e: Exception) {
                    // Tratar exceções
                    Log.wtf("GET_DATA_ERROR", "Erro ao obter dados do serviço", e)
                }
            }
        })
    }


}