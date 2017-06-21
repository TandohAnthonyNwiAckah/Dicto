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

    val COUNTS = 1000
    val BISA = 1024
    val TAG = "tanamo"
    val RWORD: Byte = 1
    val RMEANING: Byte = 2
    val UWORD: Byte = 3
    val DWORD: Byte = 4
    @SuppressLint("SdCardPath")
    val DB_PATH = "/data/data/com.tanamo.dicto/databases/"
    val DB_NAME = "dicto.db"
    val TABLE_NAME = "tanamo_db"
    var WORD = "word"
    var MEANING = "meaning"
    val VERSION = 1
    val ZERO = 0
    val AUTHOR_EMAIL_ADDRESS = "tanamoinc@gmail.com"
    val App_name = "com.tanamo.dicto"


    fun suV(code: () -> Unit) {
        sVersion(code, 21)
    }

    fun sVersion(code: () -> Unit, sdk: Int) {
        if (Build.VERSION.SDK_INT >= sdk) {
            code.invoke()
        }
    }

    fun getAppName(ctx: Context, pkgName: String): String {
        try {
            val pm = ctx.packageManager
            val appInfo = pm.getApplicationInfo(pkgName, 0)
            val label = pm.getApplicationLabel(appInfo).toString()
            return label
        } catch (e: PackageManager.NameNotFoundException) {
            return ""
        }

    }

    fun getAppVersionName(ctx: Context, pkgName: String): String {
        try {
            val pm = ctx.packageManager
            val pkgInfo = pm.getPackageInfo(pkgName, 0)
            val ver = pkgInfo.versionName
            return ver
        } catch (e: PackageManager.NameNotFoundException) {
            return "0"
        }

    }


}
