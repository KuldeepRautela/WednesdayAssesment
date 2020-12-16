package com.example.wednesdayassesment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wednesdayassesment.R
import com.example.wednesdayassesment.jetpack.model.Artist

class ArtistAdapter(val dataList: List<Artist>) :
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder =
        ArtistViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_artist,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

    class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var artistName = itemView.findViewById<TextView>(R.id.id_name)
        var artistImg = itemView.findViewById<ImageView>(R.id.id_img)

        fun bind(artist: Artist) {
            artistName.setText(artist.trackName)
            Glide.with(itemView).load(artist.songImg).into(artistImg)
        }

    }
}