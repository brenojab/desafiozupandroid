package com.brenobatista.desafiozup.ViewModels

import android.util.Log
import com.brenobatista.desafiozup.Data.ReposAdapter
import com.brenobatista.desafiozup.Models.ServicesResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainListViewModel : BaseViewModel() {

    fun initServices() {
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
                    val svcReturn = data?.services

                    if (svcReturn?.count()!! > 0)
                        reposAdapter.submitList(svcReturn)

                } catch (e: Exception) {
                    // Tratar exceções
                    Log.wtf("GET_DATA_ERROR", "Erro ao obter dados do serviço", e)
                }
            }
        })
    }

    fun filterData(query: String): ReposAdapter {
        var lst = reposAdapter.currentList.filter { p ->
            p.serviceName.toLowerCase().contains(query)
        }
        filterAdapter.submitList(lst)
        return filterAdapter
    }


}