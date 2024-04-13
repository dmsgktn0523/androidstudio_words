package com.hello.words2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hello.words2.databinding.ActivityAddWordsBinding
import com.hello.words2.databinding.ContentMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ContentMainBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        binding.tvList.adapter = adapter

        binding.btnGetText.setOnClickListener {
            val resultText = binding.tvText.text.toString()
            binding.tvResult.text = resultText
            adapter.add(resultText)
            //changes, update test for github
        }
    }

    override fun onStart() {
        super.onStart()
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddWordsActivity::class.java)
            startActivity(intent)
        }
    }
}