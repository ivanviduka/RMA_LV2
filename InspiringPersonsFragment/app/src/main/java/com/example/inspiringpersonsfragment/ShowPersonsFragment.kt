package com.example.inspiringpersonsfragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_show_list.*


class ShowPersonsFragment : Fragment() {
    companion object {
        fun newInstance(): ShowPersonsFragment{
            return ShowPersonsFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_show_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        personsDisplay.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        personsDisplay.itemAnimator = DefaultItemAnimator()
        personsDisplay.addItemDecoration(DividerItemDecoration(this.context, RecyclerView.VERTICAL))
        displayData()

    }


    private fun displayData() {

        val context = this.context

        val personListener = object: PersonInteractionListener {

            override fun onShowQuote(id: Int) {
                val person = PersonRepository.get(id)
                Toast.makeText(context, person?.quote, Toast.LENGTH_LONG).show()
            }

            override fun onDelete(id: Int) {
                PersonRepository.remove(id)
                (personsDisplay.adapter as PersonAdapter).refreshData(PersonRepository.persons)
            }

            override fun onEdit(id: Int) {
                val person = PersonRepository.get(id)


                showDialog(person)
                (personsDisplay.adapter as PersonAdapter).refreshData(PersonRepository.persons)
            }

        }

        personsDisplay.adapter = PersonAdapter(PersonRepository.persons, personListener)

    }

    private fun showDialog(person: Person?) {

        val builder = AlertDialog.Builder(this.context)
        val inflater = layoutInflater
        val dialogLayout : View = inflater.inflate(R.layout.edit_text_layout, null)
        val editText : EditText = dialogLayout.findViewById(R.id.et_DialogInput)

        with(builder) {
            setTitle("Enter new informations")
            setPositiveButton("OK" ) {dialog, which ->
                person?.info =  editText.text.toString()

            }
            setNegativeButton("Cancel", null)
            setView(dialogLayout)
            show()
        }



    }


}