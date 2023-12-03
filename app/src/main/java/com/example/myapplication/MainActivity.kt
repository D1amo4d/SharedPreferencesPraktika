package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        saveData()

        binding.btnSave.setOnClickListener {
            ladData();
        }

    }

    private fun ladData() {
        val etData = binding.etData.text.toString()
        binding.tvData.text = etData

        val dd = binding.siTf
        val sharedPrefereces = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
        val editor = sharedPrefereces.edit()
        editor.apply {
            putBoolean(SWIVT_KEY, dd.isChecked)
            putString(TV_DATA_KEY, etData)

        }.apply()
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show()
    }

    private fun saveData() {

        val sharedPrefereces = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
        val tvSaveData = sharedPrefereces.getString(TV_DATA_KEY, null)
        val switchDataSave = sharedPrefereces.getBoolean(SWIVT_KEY, false)

        binding.siTf.isChecked = switchDataSave
        binding.tvData.text = tvSaveData
    }


    companion object {
        const val PREF_KEY = "pref.key"
        const val TV_DATA_KEY = "tv.data.key"
        const val SWIVT_KEY = "swivt.key"
    }
}
