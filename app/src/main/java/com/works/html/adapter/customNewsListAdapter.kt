package com.works.html.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.works.html.R
import com.works.html.models.NewsData
import com.bumptech.glide.Glide

class customNewsListAdapter (private val context : Activity, private val list : List<NewsData>) : ArrayAdapter<NewsData>(context,R.layout.custom_news_list,list)

{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.custom_news_list,null,true)

        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_img = rootView.findViewById<ImageView>(R.id.r_img)

        val news = list.get(position)
        r_title.text = news.title
        Glide.with(context).load(news.img).into(r_img)

        return rootView
    }
}