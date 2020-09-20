package com.brenobatista.desafiozup.Views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brenobatista.desafiozup.Data.ReposAdapter
import com.brenobatista.desafiozup.R
import com.brenobatista.desafiozup.Services.SearchResult
import com.brenobatista.desafiozup.Services.createService
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainListViewActivity : AppCompatActivity() {

    private val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list_view)

        val list: RecyclerView = findViewById(R.id.recyclerViewServicos)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        var service = createService()
        service.searchServices().enqueue(object : Callback<SearchResult> {

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                // Tratar exceções
                Log.wtf("GET_DATA_ERROR","Erro ao obter dados do serviço", t)
            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {

                val data = response.body()
                val repos = data?.items

                if(repos != null) {
                    Log.wtf("","")
                }
                //adapter.submitList(repos)
            }

        })

//        val simpleData = listOf(
//            ServiceData("Investir meu dinheiro"),
//            ServiceData("Comprar créditos para meu telefone"),
//            ServiceData("Fazer uma transação"),
//            ServiceData("Contato")
//        )

        //adapter.submitList(simpleData)
    }
}