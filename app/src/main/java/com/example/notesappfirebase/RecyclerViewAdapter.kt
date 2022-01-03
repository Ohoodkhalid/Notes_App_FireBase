package com.example.notesappfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter (val mainActivity: MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    private var notes = emptyList<Note>()
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent,false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = notes[position]


        holder.itemView.apply {
            noteTV.text = note.noteText

            updateBu.setOnClickListener{

                mainActivity.dilog("update",note.noteText,note.pk)


            }

            deleteBu.setOnClickListener{
                mainActivity.dilog("delete",note.noteText,note.pk)

            }

        }
    }

    override fun getItemCount() = notes.size

    fun update(note: List<Note>){
        this.notes = note
        notifyDataSetChanged()
    }

}

