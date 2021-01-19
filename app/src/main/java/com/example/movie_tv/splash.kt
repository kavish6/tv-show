package com.example.movie_tv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.movie_tv.data.model.User
import com.example.movie_tv.data.viewmodel.UserViewModel

class splash : AppCompatActivity() {
    val splash_time = 3000
    lateinit var topanim : Animation
    lateinit var bottomanim : Animation
    lateinit var imageView: ImageView
    lateinit var text: TextView
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        imageView= findViewById(R.id.logoImage)
        text=findViewById(R.id.logoText)

        imageView.animation = topanim
        text.animation = bottomanim

        val intent = Intent(this@splash,MovieTabs::class.java)
        Handler().postDelayed( {
            startActivity(intent)
            finish()
        },splash_time.toLong())
    }
}