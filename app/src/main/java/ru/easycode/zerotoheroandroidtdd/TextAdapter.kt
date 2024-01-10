package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TextItemBinding

class TextAdapter : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {
    private val data = ArrayList<CharSequence>()

    fun update(newList: List<CharSequence>) {
        val diffUtil = DiffUtilCallback(old = data, new = newList)
        val diff = DiffUtil.calculateDiff(diffUtil)
        data.clear()
        data.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }

    class TextViewHolder(private val binding: TextItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String) {
            binding.elementTextView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(TextItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(data[position].toString())
    }
}

class DiffUtilCallback(
    private val old: List<CharSequence>,
    private val new: List<CharSequence>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}