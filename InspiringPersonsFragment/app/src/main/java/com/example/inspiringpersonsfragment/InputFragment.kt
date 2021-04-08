package com.example.inspiringpersonsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add_person.*
import java.util.*

class InputFragment : Fragment() {
    companion object {
        fun newInstance(): InputFragment{
            return InputFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_add_person, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddPerson.setOnClickListener{addToList()}
    }

    private fun addToList() {

        if(inputComplete()) {

            val date = etBirthDayInput.text.toString()

            val delimiter1 = "/"
            val delimiter2 = "."
            val dateParts = date.split(delimiter1,delimiter2)

            val newPerson = Person(PersonRepository.getSize() + 1, etNameInput.text.toString(), GregorianCalendar(dateParts[2].toInt(), dateParts[1].toInt(), dateParts[0].toInt()), etImageLinkInput.text.toString(), etInfoInput.text.toString(), etQuoteInput.text.toString())

            PersonRepository.add(newPerson)
            Toast.makeText(this.context, "Person added to the list", Toast.LENGTH_SHORT).show()

        }

        else
            Toast.makeText(this.context, "Input not complete", Toast.LENGTH_SHORT).show()
    }

    private fun inputComplete(): Boolean {
        if(etNameInput.text.toString().equals("") || etBirthDayInput.text.toString().equals("") || etImageLinkInput.text.toString().equals("") || etInfoInput.text.toString().equals("") || etQuoteInput.text.toString().equals("")) return false

        return true

    }
}