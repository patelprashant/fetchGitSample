package com.example.fetchgitsample.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fetchgitsample.databinding.ItemRepoBinding
import com.example.fetchgitsample.models.Repository

class RepoRecyclerViewAdapter(private var items: ArrayList<Repository>,
                              private var listener: OnItemClickListener)
    : RecyclerView.Adapter<RepoRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layouInflater = LayoutInflater.from(parent?.context)
        val binding = ItemRepoBinding.inflate(layouInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)


    override fun getItemCount(): Int
            = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(arrayList: ArrayList<Repository>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: ItemRepoBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository,
                 listener: OnItemClickListener?) {

            binding.repository = repo

            if (listener != null) {
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })
            }

            binding.executePendingBindings()
        }

    }
}