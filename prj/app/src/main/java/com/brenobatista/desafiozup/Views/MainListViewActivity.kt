package com.brenobatista.desafiozup.Views

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brenobatista.desafiozup.Data.ReposAdapter
import com.brenobatista.desafiozup.R
import com.brenobatista.desafiozup.Services.ServicesResult
import com.brenobatista.desafiozup.Services.createService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainListViewActivity : AppCompatActivity() {

    private val reposAdapter = ReposAdapter()
    private var filterAdapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list_view)

        // Cria a RecyclerView e seta seu adapter
        val list: RecyclerView = findViewById(R.id.recyclerViewServicos)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = reposAdapter

        // Criação dos serviços de consumo de APIs
        val service = createService()
        service.searchServices().enqueue(object : Callback<ServicesResult> {
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
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_bar, menu)
        val searcher = menu?.findItem(R.id.action_search)

        if (searcher != null) {
            val searchView = searcher.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(searchQuery: String?): Boolean {

                    val searchPattern = searchQuery.toString().toLowerCase()

                    var lst = reposAdapter.currentList.filter { p ->
                        p.serviceName.toLowerCase().contains(searchPattern)
                    }
                    filterAdapter.submitList(lst)

                    val view: RecyclerView = findViewById(R.id.recyclerViewServicos)
                    view.adapter = filterAdapter

                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    private fun filter() {

    }
}