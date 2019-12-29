package com.example.dosomethingonfirstappstartonlywithsharedpreferences

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstStart =
            getSharedPreferences("sp", Context.MODE_PRIVATE).getBoolean("firstStart", false)
        if (!firstStart) {
            showAlertDialogOnFirstAppStartOnly()
        }
    }//onCreate

    fun showAlertDialogOnFirstAppStartOnly() {
        AlertDialog.Builder(this)
            .setTitle("Do Something On App First Start Only")
            .setMessage("This Alert Dialog appears only once at App First Start ")
            .setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            }).create().show()
        getSharedPreferences("sp", Context.MODE_PRIVATE).edit()
            .putBoolean("firstStart", true).apply()
    }


}//MainActivity
