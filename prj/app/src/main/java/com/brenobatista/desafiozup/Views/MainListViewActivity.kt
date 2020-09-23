package com.brenobatista.desafiozup.Views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageButton
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ButtonBarLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brenobatista.desafiozup.R
import com.brenobatista.desafiozup.ViewModels.MainListViewModel

class MainListViewActivity : AppCompatActivity() {

    companion object {
        private val vm = MainListViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list_view)

        // Cria a RecyclerView e seta seu adapter
        val list: RecyclerView = findViewById(R.id.recyclerViewServicos)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = vm.reposAdapter

        // Criação dos serviços de consumo de APIs
        vm.initServices()

        findViewById<ImageButton>(R.id.imageButtonMyAccount).setOnClickListener {
            startBlankActivity("Navegando para minha conta!")
        }

        findViewById<ImageButton>(R.id.imageButtonMyBalance).setOnClickListener {
            startBlankActivity("Navegando para meu saldo!")
        }

        findViewById<ImageButton>(R.id.imageButtonMyCardBill).setOnClickListener {
            startBlankActivity("Navegando para minha fatura!")
        }
    }

    fun startBlankActivity(mainText: String) {
        val intent = Intent(this, BlankResultActivity::class.java)
        intent.putExtra("CALLED_INTENT_TEXT", mainText)
        startActivity(intent)
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
                    val view: RecyclerView = findViewById(R.id.recyclerViewServicos)

                    view.adapter = vm.filterData(searchPattern)

                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }
}