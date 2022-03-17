package com.example.sherzod_jurabekov_6_modul.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sherzod_jurabekov_6_modul.R
import com.example.sherzod_jurabekov_6_modul.database.AppDatabase
import com.example.sherzod_jurabekov_6_modul.database.entity.CardEntity
import com.example.sherzod_jurabekov_6_modul.model.CardElement
import com.example.sherzod_jurabekov_6_modul.networking.ApiService

class DetailsActivity : AppCompatActivity() {

    lateinit var newcardnumber: EditText
    lateinit var newName: EditText
    lateinit var newday: EditText
    lateinit var newmonth: EditText
    lateinit var cvv: EditText
    lateinit var btnNewCard: Button
    private lateinit var apiService: ApiService
    private lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initView()
    }

    private fun initView() {
        newName = findViewById(R.id.edt_name_card_new)
        newcardnumber = findViewById(R.id.edt_number_card_new)
        newday = findViewById(R.id.edt_day_new_card)
        newmonth = findViewById(R.id.edt_month_new_card)
        cvv = findViewById(R.id.edt_cvv_new_card)
        btnNewCard = findViewById(R.id.btn_new_card)


        btnNewCard.setOnClickListener {
            if (newName.text.isNotEmpty() &&
                newName.text.isNotEmpty() &&
                (newName.text.isNotEmpty() &&
                        newName.text.isNotEmpty()) &&
                cvv.text.isNotEmpty()
            ) {
                save()
            } else {
                Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun save() {
        val name = newName.text.toString()
        val month = newmonth.text.toString()
        val day = newday.text.toString()
        val number = newcardnumber.text.toString()
        val cvv = cvv.text.toString()
        val newCard = CardElement(name, month, number, cvv, day, "")
        createCard(newCard)
        val newEntityCard = CardEntity(0, name, cvv, day, month, number)
        appDatabase.cardDao().createCard(newEntityCard)
    }

    private fun createCard(card: CardElement) {
        apiService.createCards(card)
    }

}