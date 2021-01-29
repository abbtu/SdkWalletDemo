package io.abbtu.wallet.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.gson.Gson
import io.abbtu.wallet.demo.bean.GameAccountBean

class WithdrawalActivity : AppCompatActivity() {

    companion object {
        val RDATA = "gameData"
        val RESULT = "result"
    }

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_withdrawal)

        val back = findViewById<View>(R.id.back) as ImageButton
        val tvAmount = findViewById<View>(R.id.tvAmount) as TextView
        val btnNext = findViewById<View>(R.id.btnNext) as Button

        back.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        val amount = intent.data?.getQueryParameter(RDATA)
        if (!amount.isNullOrBlank()) {
            tvAmount.text = "$amount EOS"
        }

        btnNext.setOnClickListener {
            val intent = Intent()
            val accountBean = GameAccountBean("starteosio33")
            intent.putExtra(RESULT, gson.toJson(accountBean))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
    }
}