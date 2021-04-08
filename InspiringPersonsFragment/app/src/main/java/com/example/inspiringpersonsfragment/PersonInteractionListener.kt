package com.example.inspiringpersonsfragment

interface PersonInteractionListener {
    fun onShowQuote(id: Int)
    fun onDelete(id: Int)
    fun onEdit(id: Int)
}
