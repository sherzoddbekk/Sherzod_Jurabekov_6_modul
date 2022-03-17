package com.example.sherzod_jurabekov_6_modul.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sherzod_jurabekov_6_modul.R
import com.example.sherzod_jurabekov_6_modul.adapter.CardAdapter
import com.example.sherzod_jurabekov_6_modul.database.AppDatabase
import com.example.sherzod_jurabekov_6_modul.model.CardElement
import com.example.sherzod_jurabekov_6_modul.networking.ApiClient
import com.example.sherzod_jurabekov_6_modul.networking.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val cards:ArrayList<CardElement> = ArrayList()
    lateinit var adapter:CardAdapter
    lateinit var recyclerView: RecyclerView
    private lateinit var apiService: ApiService
    private lateinit var appDatabase: AppDatabase
    lateinit var open_new_act:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = ApiClient.createService(ApiService::class.java)
        appDatabase = AppDatabase.getInstance((this))

        initViews()
        setObservers()
    }


    private fun initViews() {
        open_new_act = findViewById(R.id.iv_open_details)
        open_new_act.setOnClickListener {
            openDeatails()
        }
        recyclerView = findViewById(R.id.reyclerView_card)
        recyclerView.layoutManager = LinearLayoutManager(this)
        refreshAdapter()

    }
    private fun setObservers() {
        apiService.getCards().enqueue(object : Callback<ArrayList<CardElement>?> {
            override fun onResponse(
                call: Call<ArrayList<CardElement>?>,
                response: Response<ArrayList<CardElement>?>
            ) {
                Log.d("@@@",response.code().toString() + response.message())
                Log.d("@@@RESPONSE",response.body()!!.size.toString())
                cards.addAll(response.body()!!)
                adapter.addAll(cards)
            }

            override fun onFailure(call: Call<ArrayList<CardElement>?>, t: Throwable) {
                Log.d("@@@EROR",t.message.toString())
            }
        })

    }
    private fun refreshAdapter() {
        adapter = CardAdapter(MainActivity(),cards)
        recyclerView.adapter = adapter
    }
    private fun openDeatails(){
        val intent = Intent(this,DetailsActivity::class.java)
        startActivity(intent)
    }
}