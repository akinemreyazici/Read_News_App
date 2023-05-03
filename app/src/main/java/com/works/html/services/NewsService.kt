package com.works.html.services

import android.util.Log
import com.works.html.models.NewsData
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NewsService
{
    fun newsList() : List<NewsData>
    {
        val arr = mutableListOf<NewsData>()
        val url = "https://www.haberler.com"
        val document: Document = Jsoup.connect(url).timeout(15000).get()
        val elements: Elements = document.getElementsByAttribute("data-headlinenumber")
        for (item in elements)
        {
            val img = item.getElementsByTag("img")

            val title = img.attr("alt")
            val src = img.attr("data-src")
            val href = item.attr("abs:href")

            //Log.d("title",title)
            //Log.d("src",src)
            //Log.d("href",href)

            if (title != "" && src != "" && href != "")
            {
                val news = NewsData(title,src,href)
                arr.add(news)
            }
        }
        return arr
    }
}