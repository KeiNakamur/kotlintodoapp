package com.example.kotlintodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*

//リファクタリングを後ほど実行
class NewActivity : AppCompatActivity() {

    private val spinnerItems = arrayOf(
        "選択してください",
        "仕事",
        "趣味"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        //viewの取得
        val closeImage = findViewById<ImageView>(R.id.close_image)
        val etTask = findViewById<EditText>(R.id.etTask)
        val etDeadline = findViewById<EditText>(R.id.etDeadline)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val btnDisabled = findViewById<ImageView>(R.id.btnDisabled)
        val btnBlue = findViewById<Button>(R.id.btnBlue)

        btnBlue.visibility = View.INVISIBLE
        btnDisabled.visibility = View.VISIBLE

        //タスク名
        etTask.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //テキストが編集される前に発生するイベント
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //テキストが変更された直後
            }

            override fun afterTextChanged(s: Editable?) {
                //テキストの変更が確定された直後
                btnBlue.visibility = View.VISIBLE
                btnDisabled.visibility = View.INVISIBLE
                if(etTask.getText().toString() == ""){
                    btnBlue.visibility = View.INVISIBLE
                    btnDisabled.visibility = View.VISIBLE
                }
            }
        })
        //期限
        etDeadline.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //テキストが編集される前に発生するイベント
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //テキストが変更された直後
            }

            override fun afterTextChanged(s: Editable?) {
                //テキストの変更が確定された直後
                btnBlue.visibility = View.VISIBLE
                btnDisabled.visibility = View.INVISIBLE
                if(etTask.getText().toString() == ""){
                    btnBlue.visibility = View.INVISIBLE
                    btnDisabled.visibility = View.VISIBLE
                }
            }
        })
        //詳細
        etDescription.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //テキストが編集される前に発生するイベント
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //テキストが変更された直後
            }

            override fun afterTextChanged(s: Editable?) {
                //テキストの変更が確定された直後
                btnBlue.visibility = View.VISIBLE
                btnDisabled.visibility = View.INVISIBLE
                if(etTask.getText().toString() == ""){
                    btnBlue.visibility = View.INVISIBLE
                    btnDisabled.visibility = View.VISIBLE
                }
            }
        })

        //spinner(プルダウン)実装
        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            spinnerItems
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        //以下にspinnerItemが選択された時の処理


        //×ボタンがクリックされた時の挙動
        closeImage.setOnClickListener(){
            finish()
        }

        //すべての入力フォームに値が入った場合のみbtnBlueを使用可能にする必要がある
        btnBlue.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            val taskName = etTask.text.toString()
            val deadline = etDeadline.text.toString()
            val description = etDescription.text.toString()

            intent.putExtra("taskName", taskName)
            intent.putExtra("deadline", deadline)
            intent.putExtra("description", description)

            startActivity(intent)
        }
    }
}