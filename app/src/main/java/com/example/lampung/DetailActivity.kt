package com.example.lampung

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val name = intent.getStringExtra(EXTRA_NAME)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDetail: TextView = findViewById(R.id.tv_detail)
        val tvPhoto: ImageView = findViewById(R.id.tv_foto)

        tvName.text = name
        tvDetail.text = detail
        Glide.with(this)
                .load(photo)
                .apply(RequestOptions())
                .into(tvPhoto)

        val button: Button = findViewById(R.id.btn_Share_lampung)

        button.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name: $detail")
            }
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

}
