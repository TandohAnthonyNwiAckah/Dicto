package com.tanamo.dicto.mod

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
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.tanamo.dicto.R
import com.tanamo.dicto.mod.Kons.getAppName
import com.tanamo.dicto.mod.Kons.getAppVersionName

/**
* Created by ${TANDOH} on ${6/20/2017}.
*/

class About(val mCtx: Context) {

    fun show() {
        val factory = LayoutInflater.from(mCtx)

        @SuppressLint("InflateParams")
        val dialogView = factory.inflate(R.layout.about, null)


        innerUpdate(dialogView)

        val adBuilder = AlertDialog.Builder(mCtx)
                .setTitle(R.string.app_name)
                .setIcon(R.drawable.ic_launcher)
                .setCancelable(true)
                .setPositiveButton("OK", null)
                .setView(dialogView)

        adBuilder.show()

    }

    @SuppressLint("SetTextI18n")
    fun innerUpdate(dialogView: View) {

        val appName = dialogView.findViewById<View>(R.id.app_name) as TextView

        val author = dialogView.findViewById<View>(R.id.author) as TextView

        val need = dialogView.findViewById<View>(R.id.needs) as TextView

        val website = dialogView.findViewById<View>(R.id.website) as TextView

        val face = dialogView.findViewById<View>(R.id.face) as TextView

        val bugs = dialogView.findViewById<View>(R.id.bugs) as TextView


        // app name & version
        val appText = "${getAppName(mCtx, mCtx.packageName)} v ${getAppVersionName(mCtx, mCtx.packageName)}"
        appName.text = appText
        appName.setTextColor(Color.parseColor("#00b8d4"))

        // author
        author.text = "Developed by:${mCtx.getString(R.string.author)}"

        // text
        need.setText(R.string.about_text)

        // website
        website.text = "${mCtx.getString(R.string.website)}:\n${mCtx.getString(R.string.website_url)}"
        website.setTextColor(Color.parseColor("#00b8d4"))

        // Github
        bugs.text = "${mCtx.getString(R.string.github)}:\n${mCtx.getString(R.string.github_link)}"
        bugs.setTextColor(Color.parseColor("#00b8d4"))

        // face
        face.text = "${mCtx.getString(R.string.face)}:\n${mCtx.getString(R.string.face_url)}"
        face.setTextColor(Color.parseColor("#00b8d4"))


    }

}
