package com.example.lampung

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLampunges: RecyclerView
    private var list: ArrayList<Lampung> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLampunges = findViewById(R.id.rv_lampunges)
        rvLampunges.setHasFixedSize(true)

        list.addAll(LampungesData.listData)
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {

                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvLampunges.layoutManager = LinearLayoutManager(this)
        val listLampungAdapter = ListLampungAdapter(list)
        rvLampunges.adapter = listLampungAdapter

        listLampungAdapter.setOnItemClickCallback(object : ListLampungAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Lampung) {
                val moveWithDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveWithDataIntent.putExtra(DetailActivity.EXTRA_DATA, data)
                startActivity(moveWithDataIntent)


            }


        })


    }
}