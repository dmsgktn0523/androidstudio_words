package com.hello.words2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hello.words2.databinding.ActivityAddWordsBinding
import com.hello.words2.databinding.ContentMainBinding
import com.hello.words2.databinding.AppBarMainBinding
import android.content.Intent
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.hello.words2.databinding.DictionaryMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ContentMainBinding
    private lateinit var binding: DictionaryMainBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //contentmain은 아래
        //binding = ContentMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)


        //이건 dictionary main
        binding = DictionaryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dictionaryWebNaver.settings.javaScriptEnabled = true // 인터넷의 자바 스크립트 허용
        //웹 뷰에서 새 창을 뜨지 않도록
        binding.dictionaryWebNaver.webViewClient = WebViewClient()
        binding.dictionaryWebNaver.webChromeClient = WebChromeClient()
        binding.dictionaryWebNaver.loadUrl("https://en.dict.naver.com/#/main")


//이건 add하면 리스트로 바로 들어가는 코드임
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
//        binding.tvList.adapter = adapter
//
//        binding.btnGetText.setOnClickListener {
//            val resultText = binding.tvText.text.toString()
//            binding.tvResult.text = resultText
//            adapter.add(resultText)
//            //changes, update test for github, test again 4/14
//        }
    }

    override fun onBackPressed() {
        if(binding.dictionaryWebNaver.canGoBack()){
            binding.dictionaryWebNaver.goBack()
        }
        else{
            super.onBackPressed()
        }

    }

    //    override fun onStart() {
//        super.onStart()
//        binding.btnAdd.setOnClickListener {
//            val intent = Intent(this, AddWordsActivity::class.java)
//            startActivity(intent)
//        }
//    }
}