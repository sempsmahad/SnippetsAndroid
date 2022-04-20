package com.kh69.snippetsandroid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var path:Uri
    private lateinit var parentView:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    private fun initComponents() {
        parentView = findViewById(R.id.parent_view)
        findViewById<Button>(R.id.btn_aud_pick).setOnClickListener {
            val intent_upload = Intent()
            intent_upload.type = "audio/*"
            intent_upload.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent_upload, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            path = data.data!!
            Snackbar.make(parentView, "Picked Successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}