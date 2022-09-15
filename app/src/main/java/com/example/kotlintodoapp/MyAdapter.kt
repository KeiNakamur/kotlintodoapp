package com.example.kotlintodoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.size

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    val titles = arrayOf(
        "タイトル1",
        "タイトル2"
    )

    val details = arrayOf(
        "説明1",
        "説明2"
    )

    val images = intArrayOf(
        R.drawable.check,
        R.drawable.unchecked
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        //listviewにレイアウトを指定する場合はlayoutInflaterを使用
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.recyclerview_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])



    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }
}