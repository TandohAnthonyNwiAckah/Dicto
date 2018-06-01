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
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

/**
 * Created by ${TANDOH} on ${6/20/2017}.
 */
object Kons {

    const val COUNTS = 3000
    const val BISA = 1024
    const val TAG = "tanamo"
    const val RWORD: Byte = 1
    const val RMEANING: Byte = 2
    const val UWORD: Byte = 3
    const val DWORD: Byte = 4
    @SuppressLint("SdCardPath")
    val DB_PATH = "/data/data/com.tanamo.dicto/databases/"
    const val DB_NAME = "dicto.db"
    const val TABLE_NAME = "tanamo_db"
    var WORD = "word"
    var MEANING = "meaning"
    const val VERSION = 1
    const val ZERO = 0
    const val AUTHOR_EMAIL_ADDRESS = "tanamoinc@gmail.com"
    const val App_name = "com.tanamo.dicto"


    fun suV(code: () -> Unit) {
        sVersion(code, 21)
    }

    private fun sVersion(code: () -> Unit, sdk: Int) {
        if (Build.VERSION.SDK_INT >= sdk) {
            code.invoke()
        }
    }

    fun getAppName(ctx: Context, pkgName: String): String {
        return try {
            val pm = ctx.packageManager
            val appInfo = pm.getApplicationInfo(pkgName, 0)
            val label = pm.getApplicationLabel(appInfo).toString()
            label
        } catch (e: PackageManager.NameNotFoundException) {
            ""
        }

    }

    fun getAppVersionName(ctx: Context, pkgName: String): String {
        return try {
            val pm = ctx.packageManager
            val pkgInfo = pm.getPackageInfo(pkgName, 0)
            val ver = pkgInfo.versionName
            ver
        } catch (e: PackageManager.NameNotFoundException) {
            "0"
        }

    }


}
