package com.example.dialogfragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        findViewById<Button>(R.id.open).setOnClickListener {
            val dialog = DialogOneFragment()
            val ft = supportFragmentManager.beginTransaction()
            dialog.show(ft, DialogOneFragment::class.java.simpleName)
        }
    }

}
