package com.example.androidmvp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import android.widget.Toast

import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView

import android.view.View
import com.example.androidmvp.R


class MainActivity : AppCompatActivity(), MainView {


    private var recyclerView: RecyclerView? = null

    private var progressBar: ProgressBar? = null

    private var presenter: MainPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list)

        progressBar = findViewById(R.id.progress)

        presenter = MainPresenter(this, FindItemsInteractor())

    }


    override fun onResume() {

        super.onResume()

        presenter!!.onResume()

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)

        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.getItemId()) {

            com.example.androidmvp.R.id.action_settings ->
                return true
            else ->
                return super.onOptionsItemSelected(item)
        }
    }
    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        recyclerView!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.INVISIBLE
        recyclerView!!.visibility = View.VISIBLE
    }
    override fun setItems(items: List<String>) {
        recyclerView!!.adapter = MainAdapter(items, (run { presenter!!.onItemClicked() }))
    }
    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}