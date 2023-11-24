package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TextItemBinding

class TextAdapter :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {
    private val data: ArrayList<String> = ArrayList()

    fun add(text:String){
        data.add(text)
        notifyItemInserted(data.size -1)
    }

    class TextViewHolder(private val binding: TextItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: String) {
            binding.elementTextView.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(TextItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun save(bundle: Bundle) {
        bundle.putStringArrayList("key", data)
    }

    fun restore(bundle: Bundle) {
        val restoredList = bundle.getStringArrayList("key") ?: ArrayList()
        data.addAll(restoredList)
    }
}