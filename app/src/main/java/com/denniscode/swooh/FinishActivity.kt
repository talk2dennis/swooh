package com.denniscode.swooh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinishActivity : AppCompatActivity() {
    lateinit var person: Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val msgTv = findViewById<TextView>(R.id.msgTv)
        person = intent.getParcelableExtra<Person>(EXTRA_VALUE)!!
        msgTv.text = "Looking for a ${person.player} ${person.skills} league near you"
    }
}