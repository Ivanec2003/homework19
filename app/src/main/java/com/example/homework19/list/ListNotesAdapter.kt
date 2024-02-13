package com.example.homework19.list
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework19.NoteModel
import com.example.homework19.R

class ListNotesAdapter: ListAdapter <NoteModel, ListNotesAdapter.MyViewHolder>(TaskDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewNote: ImageView = itemView.findViewById(R.id.imageViewNote)
        private val textViewTitleNote: TextView = itemView.findViewById(R.id.textViewTitleNote)
        private val textViewDescriptionNote: TextView = itemView.findViewById(R.id.textViewDescriptionNote)
        fun bind(note: NoteModel){
            val title = "Title: " + note.title
            val description = "Description:\n" + note.desription
            imageViewNote.setImageResource(note.image)
            textViewTitleNote.text = title
            textViewDescriptionNote.text = description
        }
    }
    class TaskDiffCallBack: DiffUtil.ItemCallback<NoteModel>(){
        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.title == newItem.title && oldItem.desription == newItem.desription && oldItem.image == newItem.image
        }

        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }
    }

}