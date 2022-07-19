package com.denniscode.swooh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton

class SkillActivity : AppCompatActivity() {
    lateinit var person: Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        person = intent.getParcelableExtra<Person>(EXTRA_VALUE)!!
        val begginerBtn : ToggleButton = findViewById(R.id.beginnerBtn)
        val ballerBtn : ToggleButton = findViewById(R.id.ballerBtn)
        begginerBtn.setOnClickListener {
            ballerBtn.isChecked = false
            person.skills = "Beginner"
        }
        ballerBtn.setOnClickListener {
            begginerBtn.isChecked = false
            person.skills = "Baller"
        }
        val finishBtn : Button = findViewById(R.id.finishBtn)
        finishBtn.setOnClickListener {
            if (person.skills != "") {
                val intent = Intent(this, FinishActivity ::class.java)
                intent.putExtra(EXTRA_VALUE, person)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
            }
        }
    }
}