package com.example.inspiringpersons

import Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_data_entry.*
import layout.PersonRepository
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_entry)
        setUpUI()
    }

    private fun setUpUI() {
            val showList : Button = findViewById(R.id.btnShowList)
            val addPerson : Button = findViewById(R.id.btnAddPerson)

            addPerson.setOnClickListener{addToList()}

            showList.setOnClickListener{navigateToList()}
    }


    private fun addToList() {

        if(inputComplete()) {

            val date = etBirthDayInput.text.toString()

            val delimiter1 = "/"
            val delimiter2 = "."
            val dateParts = date.split(delimiter1,delimiter2)

            val newPerson = Person(PersonRepository.getSize() + 1, etNameInput.text.toString(), GregorianCalendar(dateParts[2].toInt(), dateParts[1].toInt(), dateParts[0].toInt()), etImageLinkInput.text.toString(), etInfoInput.text.toString(), etQuoteInput.text.toString())

            PersonRepository.add(newPerson)

            Toast.makeText(this, "Person added to the list", Toast.LENGTH_SHORT).show()
        }

        else
            Toast.makeText(this, "Input not complete", Toast.LENGTH_SHORT).show()
    }

    private fun inputComplete(): Boolean {
        if(etNameInput.text.toString().equals("") || etBirthDayInput.text.toString().equals("") || etImageLinkInput.text.toString().equals("") || etInfoInput.text.toString().equals("") || etQuoteInput.text.toString().equals("")) return false

        return true

    }


    private fun navigateToList() {
        val detailsIntent = Intent(this, PersonsListActivity::class.java)
        startActivity(detailsIntent)
    }
}