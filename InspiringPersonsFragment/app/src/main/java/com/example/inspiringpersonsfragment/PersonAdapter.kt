package com.example.inspiringpersonsfragment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_person.view.*
import java.util.*


class PersonAdapter (
    persons : MutableList<Person>,
    personListener : PersonInteractionListener
): RecyclerView.Adapter<PersonHolder>() {

    private val persons: MutableList<Person>
    private val personListener : PersonInteractionListener

    init {

        this.persons = mutableListOf()
        this.persons.addAll(persons)
        this.personListener = personListener
    }

    fun refreshData(persons: MutableList<Person>) {
        this.persons.clear()
        this.persons.addAll(persons)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = persons.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val personView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        val personHolder = PersonHolder(personView)
        return personHolder
    }
    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person = persons[position]
        holder.bind(person, personListener)
    }

}

class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(person: Person, personListener : PersonInteractionListener) {

        itemView.tvPersonName.text = person.name

        val year = person.birthday.get(Calendar.YEAR)
        val month = person.birthday.get(Calendar.MONTH)
        val day = person.birthday.get(Calendar.DAY_OF_MONTH)
        val date = day.toString() + "." + month.toString() + "." + year.toString()
        itemView.tvPersonBirthday.text = date


        itemView.tvPersonDesc.text = person.info
        Picasso.get()
            .load(person.photo)
            .fit()
            .placeholder(R.drawable.ic_launcher_background)
            .error(android.R.drawable.stat_notify_error)
            .into(itemView.ivPersonPhoto)

        itemView.ivPersonPhoto.setOnClickListener { personListener.onShowQuote(person.id)}
        itemView.btnDelete.setOnClickListener{personListener.onDelete(person.id)}
        itemView.btnEdit.setOnClickListener{personListener.onEdit(person.id)}


    }


}