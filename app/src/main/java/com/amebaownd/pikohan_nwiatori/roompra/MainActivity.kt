package com.amebaownd.pikohan_nwiatori.roompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.lifecycle.Observer
import com.amebaownd.pikohan_nwiatori.roompra.database.AppDatabase
import com.amebaownd.pikohan_nwiatori.roompra.database.Message
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val messageList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getDatabase(this)

        val editText = findViewById<EditText>(R.id.message_editText)
        val listView = findViewById<ListView>(R.id.message_list)

        val addButton = findViewById<Button>(R.id.add_button)
        addButton.setOnClickListener {

            if(!editText.text.isNullOrEmpty()){
                thread {
                    db.messageDao().insert(Message(message = editText.text.toString()))
                }
            }
        }

        db.messageDao().getMessage().observe(this, Observer {
            val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,it)
                listView.adapter = arrayAdapter
        })
    }
}
