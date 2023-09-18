package com.example.giphy.section.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphy.R
import com.example.giphy.model.GifItem
import com.example.giphy.databinding.ListItemBinding

class GifsAdapter: PagingDataAdapter<GifItem, GifsAdapter.ViewHolder>(GifComparator) {

    class ViewHolder(private val v: ListItemBinding): RecyclerView.ViewHolder(v.root) {
        fun bindGifItem(item: GifItem) = with(v) {
            Glide.with(v.root.context).asGif().load(item.url).into(image)
            v.root.setOnClickListener {
                v.root.findNavController().navigate(
                    R.id.action_listFragment_to_showFragment,
                    Bundle().apply { putString("url", item.url) }
                )
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bindGifItem(item) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    object GifComparator : DiffUtil.ItemCallback<GifItem>() {
        override fun areItemsTheSame(oldItem: GifItem, newItem: GifItem): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: GifItem, newItem: GifItem): Boolean {
            return oldItem.url == newItem.url
        }
    }
}