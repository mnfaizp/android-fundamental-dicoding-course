package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fundamental.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHeroes.setHasFixedSize(true)

        list.addAll(getHeroList())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hero_type, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.action_list -> {
                showRecyclerList()
            }

            R.id.action_grid -> {

            }

            R.id.action_card -> {

            }
        }
    }

    private fun showRecyclerList() {
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        binding.rvHeroes.adapter = listHeroAdapter
    }

    private fun getHeroList(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDetail = resources.getStringArray(R.array.data_detail)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val heroList = ArrayList<Hero>()
        for (position in dataName.indices) {
            val hero = Hero(
                dataPhoto[position],
                dataName[position],
                dataDetail[position]
            )
            heroList.add(hero)
        }
        return heroList
    }
}