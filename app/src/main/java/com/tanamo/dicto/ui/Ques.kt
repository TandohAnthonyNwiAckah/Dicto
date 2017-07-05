package com.tanamo.dicto.ui

/*
 * Copyright (C) 2016 Tanamo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.tanamo.dicto.R
import com.tanamo.dicto.mod.Apc

/**
* Created by ${TANDOH} on ${6/20/2017}.
*/
class Ques : Apc() {
    var medi: MediaPlayer? = null
    var b: RadioButton? = null
    var b1: RadioButton? = null
    var b2: RadioButton? = null
    var b3: RadioButton? = null
    var b4: RadioButton? = null
    var e: EditText? = null
    var txt: TextView? = null
    private var n1: String? = null
    private var n2: String? = null
    private var n3: String? = null
    private var n4: String? = null
    private var n5: String? = null
    private var n6: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.ques)

        Timer(30000)

        medi = MediaPlayer.create(this, R.raw.trv)
        medi!!.start()


    }

    fun init(v: View) {


        var score = 0

        // Q1
        b = findViewById(R.id.r2) as RadioButton
        if (b!!.isChecked) score++

        // Q2
        b1 = findViewById(R.id.r4) as RadioButton
        if (b1!!.isChecked) score++

        // Q3
        e = findViewById(R.id.e1) as EditText
        val strr = e!!.text.toString()
        if (strr.equals(getString(R.string.ques_3_1), ignoreCase = true)) score++


        // Q4
        b2 = findViewById(R.id.r6) as RadioButton
        if (b2!!.isChecked) score++

        // Q5
        b3 = findViewById(R.id.r9) as RadioButton
        if (b3!!.isChecked) score++

        // Q6
        b4 = findViewById(R.id.r13) as RadioButton
        if (b4!!.isChecked) score++

        n1 = b!!.text.toString()
        n2 = b1!!.text.toString()
        n3 = b2!!.text.toString()
        n4 = b3!!.text.toString()
        n5 = b4!!.text.toString()
        n6 = e!!.text.toString()


        if (TextUtils.isEmpty(n1) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || TextUtils.isEmpty(n4) || TextUtils.isEmpty(n5) || TextUtils.isEmpty(n6)) {
            Toast.makeText(this, "Answer All", Toast.LENGTH_SHORT).show()

        } else {


            val strScore: String
            if (score == 6) {
                strScore = "Excellent! You score $score out 6!"
                dia!!.show()
                medi!!.stop()
                sec!!.cancel()
                title?.text = strScore
            } else {
                strScore = "You score  $score out 6."
                dia!!.show()
                medi!!.stop()
                sec!!.cancel()
                title!!.text = strScore
            }


        }


    }


    override fun onResume() {
        super.onResume()

        sec!!.start()
        medi!!.start()
    }

    override fun onPause() {
        super.onPause()
        sec!!.cancel()
        medi!!.pause()
    }

    fun Timer(time: Int) {
        txt = findViewById(R.id.timmer) as TextView
        sec = object : CountDownTimer(time.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tm = "" + millisUntilFinished / 1000
                txt!!.text = tm

            }

            override fun onFinish() {
                sec!!.cancel()
                txt!!.text = ""
                if (!isFinishing) {
                    dia!!.show()
                    medi!!.stop()
                    title!!.text = "Try Again"
                }

            }

        }.start()
    }

    override fun onBackPressed() {
        sec!!.cancel()
        finish()
        medi!!.stop()

    }

    companion object {
        var sec: CountDownTimer? = null
        var tm: String = ""
    }

}