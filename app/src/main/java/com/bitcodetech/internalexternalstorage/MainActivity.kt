package com.bitcodetech.internalexternalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //part 1
        /*val fout : FileOutputStream =
            openFileOutput("my_profile.txt", Activity.MODE_PRIVATE or Activity.MODE_APPEND)
        fout.write("My Name is Vishal\n".toByteArray())
        fout.close()

        val fin : FileInputStream =
            openFileInput("my_profile.txt")

        val data = ByteArray(1024 * 1)
        var count = 0

        count = fin.read(data)
        while( count != -1) {
            mt( String(data, 0, count))
            count = fin.read(data)
        }
        fin.close()
        */

        //deleteFile("my_profile.txt")

        /*val fileNames = fileList()
        for(fileName in fileNames) {
            mt(fileName)
        }*/

        /*val appRootDir = filesDir //getFilesDir
        mt("app root files dir on internal storage: ${appRootDir.absolutePath}")

        val myPics = File(appRootDir, "my_pics")
        if(!myPics.exists()) {
            myPics.mkdir()
        }

        val myProfile = File(myPics, "myprofile.txt")
        if(!myProfile.exists()) {
            myProfile.createNewFile()
        }

        val fout = FileOutputStream(myProfile)
        fout.write("this is sample data".toByteArray())
        fout.close()

        val fin = FileInputStream(myProfile)
        val data = ByteArray(1024)

        var count = 0
        count = fin.read(data)
        if(count != -1) {
            mt(String(data, 0, count))
        }

        val files = filesDir.listFiles()
        for(file in files) {
            mt(file.absolutePath)
            if(file.isDirectory) {
                val files1 = file.listFiles()
                for(file1 in files1) {
                    mt("\t${file1.absolutePath}")
                }
            }
        }*/

        /*val tempDir = File(filesDir, "temp")
        if(!tempDir.exists()) {
            tempDir.mkdir()
        }

        mt("cache dir: ${cacheDir.absolutePath}")*/

        //External Storage
        val extStorageState = Environment.getExternalStorageState()
        when(extStorageState){
            Environment.MEDIA_MOUNTED ->
                mt("External storage available for RW")
            Environment.MEDIA_MOUNTED_READ_ONLY ->
                mt("External storage available for R")
            Environment.MEDIA_UNKNOWN ->
                mt("External storage state unknowns")
        }

        val extStorageRootDir = Environment.getExternalStorageDirectory()
        mt("Ext Storage dir: ${extStorageRootDir.absolutePath}")

        /*val extStorageRootDir1 = Environment.getExternalStoragePublicDirectory(null)
        mt("Ext Storage dir1: ${extStorageRootDir1.absolutePath}")*/

        /*val extDcimDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
        mt("ext dcim: ${extDcimDir.absolutePath}")


        val bitcodeDir = File(extDcimDir, "bitcode_new")
        if(!bitcodeDir.exists()) {
            mt("dir created: " + bitcodeDir.mkdir() )
        }

        val someFile = File(bitcodeDir, "somefile.txt")
        if(!someFile.exists()) {
            someFile.createNewFile()
        }

        val fout = FileOutputStream(someFile)
        fout.write("some data".toByteArray())
        fout.close()

        val fin = FileInputStream(someFile)
        val data = ByteArray(200)
        val count = fin.read(data)
        mt("data: ${String(data, 0, count)}")
        fin.close()*/

        val extAppRootDir = getExternalFilesDir(null)
        mt("Ext App Root dir: ${extAppRootDir?.absolutePath}")
        val bitcodeDir = File(extAppRootDir, "bitcode_new")
        if(!bitcodeDir.exists()) {
            mt("dir created: " + bitcodeDir.mkdir() )
        }

        val someFile = File(bitcodeDir, "somefile.txt")
        if(!someFile.exists()) {
            someFile.createNewFile()
        }

        val fout = FileOutputStream(someFile)
        fout.write("some data".toByteArray())
        fout.close()

        val fin = FileInputStream(someFile)
        val data = ByteArray(200)
        val count = fin.read(data)
        mt("data: ${String(data, 0, count)}")
        fin.close()

        val extAppMoviesDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        mt("ext app movies dir: ${extAppMoviesDir?.absolutePath}")

        mt("app ext cache dir: " + externalCacheDir?.absolutePath)
    }

    private fun mt(text : String) {
        Log.e("data", text)
    }
}