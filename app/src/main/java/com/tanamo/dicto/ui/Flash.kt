package com.tanamo.dicto.ui


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.tanamo.dicto.R
import com.tanamo.dicto.db.Dict
import com.tanamo.dicto.util.Constant.COUNTS
import com.tanamo.dicto.util.Constant.TAG


/**
 * Created by ${TANDOH} on ${6/20/2017}.
 */
class Flash : AppCompatActivity() {


    private var dict: Dict? = null

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)

/*
        relativeLayout {
            backgroundResource = R.drawable.ic_bg

            progressBar {
                id = View.generateViewId()
                gravity = Gravity.CENTER
                //indeterminateDrawable

            }.lparams{
                padding = dip(16)
                margin = dip(16)
                gravity = CENTER
                gravity = Gravity.CENTER

            }


            textView {
                gravity = Gravity.CENTER
                id = View.generateViewId()
                hint = "tts"
                textSize = 25f
                text = "loading"
                padding = dip(16)
            }.lparams(matchParent, matchParent)


        }
*/
        setContentView(R.layout.flash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)



        dict = Dict(this@Flash)
        dict!!.getDict()


        Handler().postDelayed({
            val i = Intent(this@Flash, MainActivity::class.java)
            startActivity(i)
            finish()
        }, COUNTS.toLong())


    }


}
