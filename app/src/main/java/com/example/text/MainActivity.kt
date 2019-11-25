package com.example.text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.util.Base64
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.nio.charset.Charset
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decodeToString("Q1RGSUNPTntOZXRCeXRlU2VjfQ==")
    }

    fun decodeToString(encodedString : String){

        val encoded : ByteArray = encodedString.toByteArray(Charsets.UTF_8)
        val plain = Base64.decode(encoded, Base64.DEFAULT)
        val text = String(plain, Charsets.UTF_8)
        println("Decoded = $text")

        val s1: String = text.substring(0,8)
        val s2: String = text.substring(18)

        val mask: String = s1 + "********" + s2

        //view
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = mask

    }
}
