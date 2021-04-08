package com.example.inspiringpersons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_persons_list.*
import layout.PersonRepository

class PersonsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persons_list)
        setUpUi()

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun setUpUi() {

        personsDisplay.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        personsDisplay.itemAnimator = DefaultItemAnimator()
        personsDisplay.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
        displayData()
    }


    private fun displayData() {

        val personListener = object: PersonInteractionListener{
            override fun onShowDQuote(id: Int) {
                val person = PersonRepository.get(id)
                Toast.makeText(applicationContext, person?.quote, Toast.LENGTH_LONG).show()
            }


        }

        personsDisplay.adapter = PersonAdapter(PersonRepository.persons, personListener)


    }

}
