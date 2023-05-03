package com.works.html

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.core.view.get
import com.works.html.adapter.customNewsListAdapter
import com.works.html.models.NewsData
import com.works.html.services.NewsService

class MainActivity : AppCompatActivity() {
    lateinit var newsList: ListView
    val newService = NewsService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsList = findViewById(R.id.listViewNews)




        val runnable = Runnable {


            val customAdapter = customNewsListAdapter(this, newService.newsList())

            runOnUiThread {

                newsList.adapter = customAdapter

                // Arayüz tasarımlarını runnable içindeyken arayüz tasarımları bu fonksiyon içinde ayrı yapılması gerekiyor
                // Yapılmaması takdirinde android.view.ViewRootImpl$CalledFromWrongThreadException: hatası alınır
            }

            newsList.setOnItemClickListener { adapterView, view, i, l ->
                val selectedNews = newsList.getItemAtPosition(i) as NewsData

                //Log.d("selectedNews",selectedNews.href)


               val intent = Intent(this,WebViewActivity::class.java)
                intent.putExtra("href",selectedNews.href)


                startActivity(intent)
            }

        }


        Thread(runnable).start()

    }
}