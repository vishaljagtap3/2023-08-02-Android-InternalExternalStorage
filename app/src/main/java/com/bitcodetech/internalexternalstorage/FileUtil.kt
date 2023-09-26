package com.bitcodetech.internalexternalstorage

import android.content.Context
import java.io.File

object FileUtil {

    fun createDirectory(context: Context, dirName: String) : Boolean {
        val newDir = File(
            context.filesDir,
            dirName
        )
        if(!newDir.exists()) {
            return newDir.mkdir()
        }

        return true
    }

}