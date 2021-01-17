package com.example.lampung

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.lampung.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data: Lampung = intent.getParcelableExtra<Lampung>(EXTRA_DATA) as Lampung

        binding.tvName.text = data.name
        binding.tvDetail.text = data.detail
        Glide.with(this)
            .load(data.photo)
            .apply(RequestOptions())
            .into(binding.tvFoto)

        binding.btnShareLampung.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${data.name}: ${data.detail}")
            }
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

}
