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

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.tanamo.dicto.R
import com.tanamo.dicto.db.Dict
import com.tanamo.dicto.mod.Kons.COUNTS
import com.tanamo.dicto.mod.Kons.TAG


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
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

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


        dict = Dict(this@Flash)
        dict!!.getDict()


        Handler().postDelayed({
            val i = Intent(this@Flash, MainActivity::class.java)
            startActivity(i)
            finish()
        }, COUNTS.toLong())


    }


}
