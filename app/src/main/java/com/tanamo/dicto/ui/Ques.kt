package com.tanamo.dicto.ui


import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.tanamo.dicto.R
import kotlinx.android.synthetic.main.ques.*

/**
 * Created by ${TANDOH} on ${6/20/2017}.
 */
class Ques : Apc() {
    var medi: MediaPlayer? = null
    private var n1: String = ""
    private var n2: String = ""
    private var n3: String = ""
    private var n4: String = ""
    private var n5: String = ""
    private var n6: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.ques)

        myTimer(30000)

        medi = MediaPlayer.create(this, R.raw.trv)
        medi!!.start()


    }

    fun init(v: View) {

        var score = 0

        // Q1
        if (r2.isChecked) score++

        // Q2
        if (r4!!.isChecked) score++

        // Q3
        val strr = e1.text.toString()
        if (strr.equals(getString(R.string.ques_3_1), ignoreCase = true)) score++


        // Q4
        if (r6.isChecked) score++

        // Q5
        if (r9.isChecked) score++

        // Q6
        if (r13.isChecked) score++

        n1 = r2.text.toString()
        n2 = r4.text.toString()
        n3 = r6.text.toString()
        n4 = r9.text.toString()
        n5 = r13.text.toString()
        n6 = e1.text.toString()


        if (TextUtils.isEmpty(n1) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || TextUtils.isEmpty(n4) || TextUtils.isEmpty(n5) || TextUtils.isEmpty(n6)) {
            Toast.makeText(this, getString(R.string.ansall), Toast.LENGTH_SHORT).show()

        } else {


            val strScore: String
            if (score == 6) {
                strScore = "Excellent! You score $score out 6!"
                dia.show()
                medi!!.stop()
                sec!!.cancel()
                title?.text = strScore
            } else {
                strScore = "You score  $score out 6."
                dia.show()
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


    private fun myTimer(time: Int) {

        sec = object : CountDownTimer(time.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tm = "" + millisUntilFinished / 1000
                timmer.text = tm

            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                sec!!.cancel()
                timmer.text = ""
                if (!isFinishing) {
                    dia.show()
                    medi!!.stop()
                    title!!.text = getString(R.string.tryagain)
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