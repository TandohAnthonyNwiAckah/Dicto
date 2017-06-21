package com.tanamo.dicto.db

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


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.tanamo.dicto.mod.Kons.BISA
import com.tanamo.dicto.mod.Kons.DB_NAME
import com.tanamo.dicto.mod.Kons.DB_PATH
import com.tanamo.dicto.mod.Kons.MEANING
import com.tanamo.dicto.mod.Kons.TABLE_NAME
import com.tanamo.dicto.mod.Kons.TAG
import com.tanamo.dicto.mod.Kons.VERSION
import com.tanamo.dicto.mod.Kons.WORD
import com.tanamo.dicto.mod.Kons.ZERO
import java.io.FileOutputStream
import java.io.IOException

/**
* Created by ${TANDOH} on ${6/20/2017}.
*/
class Dict(val context: Context) : SQLiteOpenHelper(context, DB_NAME, null, VERSION) {


    override fun onCreate(db: SQLiteDatabase) {

        Log.d(TAG, "onCreate: ")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.d(TAG, "onUpgrade: ")
    }

    fun getDict() {
        Log.d(TAG, "getDict: ")
        val fil = context.getDatabasePath(DB_PATH +DB_NAME)

        if (!fil.exists()) {
            this@Dict.writableDatabase
            try {
                val ins = context.assets.open(DB_NAME)
                val ous = FileOutputStream(fil)

                val buffer = ByteArray(BISA)
                while (ins.read(buffer) > ZERO)
                    ous.write(buffer)
                ins.close()
                ous.flush()
                ous.close()

            } catch (e: IOException) {
                Log.e("", "Try Again Later")

            }

        }

    }

    fun getWord(): ArrayList<String> {
        Log.d(TAG, "getWord: ")
        val lis = ArrayList<String>()
        val query = "SELECT $WORD FROM $TABLE_NAME"
        val db: SQLiteDatabase = this@Dict.readableDatabase
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            lis.add(cursor.getString(0))
            cursor.moveToNext()
        }
        cursor.close()
        db.close()

        return lis
    }

    @Synchronized fun getMeaning(word: String): String {
        Log.d(TAG, "getMeaning: ")
        var meaning: String = ""
        val query = "SELECT $MEANING FROM $TABLE_NAME WHERE $WORD = '$word'"

        val db = this@Dict.readableDatabase
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        if (cursor.count > ZERO) meaning = cursor.getString(ZERO)
        cursor.close()
        db.close()
        return meaning
    }

    @Synchronized fun addDict(word: String, meaning: String) {
        Log.d(TAG, "addDict: ")
        val cvs = ContentValues()
        cvs.put(WORD, word)
        cvs.put(MEANING, meaning)
        val db = this@Dict.writableDatabase
        db.insert(TABLE_NAME, null, cvs)
        db.close()
    }

    @Synchronized fun delDict(word: String, meaning: String) {
        val db = this@Dict.writableDatabase
        val sel = "$WORD LIKE ? AND $MEANING LIKE ?"
        val selArgs = arrayOf(word, meaning)
        db.delete(TABLE_NAME, sel, selArgs)
        db.close()
    }


}
