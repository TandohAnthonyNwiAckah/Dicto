package com.tanamo.dicto.ui


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.tanamo.dicto.R
import com.tanamo.dicto.util.Constant.getAppName
import com.tanamo.dicto.util.Constant.getAppVersionName
import kotlinx.android.synthetic.main.about.view.*

/**
 * Created by ${TANDOH} on ${6/20/2017}.
 */

class About(private val mCtx: Context) {

    fun show() {
        val factory = LayoutInflater.from(mCtx)

        @SuppressLint("InflateParams")
        val vie = factory.inflate(R.layout.about, null)


        innerUpdate(vie)

        val adBuilder = AlertDialog.Builder(mCtx)
                .setTitle(R.string.app_name)
                .setIcon(R.drawable.ic_launcher)
                .setCancelable(true)
                .setPositiveButton("OK", null)
                .setView(vie)

        adBuilder.show()

    }

    @SuppressLint("SetTextI18n")
    private fun innerUpdate(vie: View) {

        // app name & version
        val appText = "${getAppName(mCtx, mCtx.packageName)} v ${getAppVersionName(mCtx, mCtx.packageName)}"
        vie.app_name.text = appText

        // author
        vie.author.text = "Developed by:${mCtx.getString(R.string.author)}"

        // text
        vie.needs.setText(R.string.about_text)

        // website
        vie.website.text = "${mCtx.getString(R.string.website)}:\n${mCtx.getString(R.string.website_url)}"

        // Github
        vie.bugs.text = "${mCtx.getString(R.string.github)}:\n${mCtx.getString(R.string.github_link)}"

        // face
        vie.face.text = "${mCtx.getString(R.string.face)}:\n${mCtx.getString(R.string.face_url)}"


    }

}
