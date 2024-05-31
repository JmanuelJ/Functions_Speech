package com.example.functionsspeech.utils

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import kotlin.io.path.pathString
import kotlin.io.path.writeBytes

class CreateFileSound {
    lateinit var file: File

    fun createSound(array: ByteArray?): File{
        if(array!!.isNotEmpty()){
            val temMp3 = kotlin.io.path.createTempFile("example", ".mp3")
            temMp3.writeBytes(array)
            file = File(temMp3.pathString)
        }
        return file
    }

    fun createUri(file: File, context: Context): Uri{
        return FileProvider
            .getUriForFile(
                context
                ,"com.example.functionsspeech.fileprovider",
                file)
    }
}