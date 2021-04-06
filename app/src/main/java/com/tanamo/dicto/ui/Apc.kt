package com.tanamo.dicto.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.tanamo.dicto.R

/**
 * Created by TANDOH on 6/22/2017.
 */

open class Apc : AppCompatActivity() {
    lateinit var dia: Dialog
    var ctx: Context = this@Apc
    private var imag: ImageView? = null
    private var imag2: ImageView? = null
    private var imag3: ImageView? = null
    var title: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ap)

        shwDialog()

    }

    private fun shwDialog() {

        dia = Dialog(ctx)
        dia.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dia.setContentView(R.layout.ap)
        dia.setCancelable(false)
        dia.setCanceledOnTouchOutside(false)

        title = dia.findViewById(R.id.title)

        imag = dia.findViewById(R.id.quit)

        imag2 = dia.findViewById(R.id.replay)

        imag3 = dia.findViewById(R.id.nxt)


        imag!!.setOnClickListener {
            finish()
        }

        imag2!!.setOnClickListener {
            val intent = Intent(ctx, Ques::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        imag3!!.setOnClickListener {
            val intent = Intent(ctx, Ques2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }


    }

}
