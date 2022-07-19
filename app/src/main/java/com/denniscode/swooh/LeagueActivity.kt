package com.denniscode.swooh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton

class LeagueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        val mensBtn : ToggleButton = findViewById(R.id.mensBtn)
        val womensBtn = findViewById<ToggleButton>(R.id.womensBtn)
        val coEdBtn = findViewById<ToggleButton>(R.id.coEdBtn)
        val nextSkillBtn : Button = findViewById(R.id.nextSkillBtn)
        var person = Person(player = "", skills = "")
        mensBtn.setOnClickListener(){
            womensBtn.isChecked = false
            coEdBtn.isChecked = false
            person.player = "Mens"
        }
        womensBtn.setOnClickListener {
            mensBtn.isChecked = false
            coEdBtn.isChecked = false
            person.player = "Womens"
        }
        coEdBtn.setOnClickListener {
            womensBtn.isChecked = false
            mensBtn.isChecked = false
            person.player = "Co-ed"
        }
        nextSkillBtn.setOnClickListener() {
            if (person.player == "") {
                Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent (this, SkillActivity :: class.java)
                intent.putExtra(EXTRA_VALUE, person)
                startActivity(intent)
            }
        }
    }
}