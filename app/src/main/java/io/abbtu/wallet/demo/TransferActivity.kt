package io.abbtu.wallet.demo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import io.abbtu.wallet.demo.bean.GameAccountBean
import io.abbtu.wallet.demo.bean.GameTransferBean

class TransferActivity : AppCompatActivity() {

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val back = findViewById<View>(R.id.back) as ImageButton
        val ok = findViewById<View>(R.id.button) as Button
        val tvTo = findViewById<View>(R.id.tvTo) as TextView

        back.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }


        val toAvvount = intent.data?.getQueryParameter(WithdrawalActivity.RDATA)
        if (!toAvvount.isNullOrBlank()) {
            tvTo.text = "$toAvvount"
        }

        ok.setOnClickListener {
            Toast.makeText(this,"转账成功",Toast.LENGTH_SHORT).show()
            val intent = Intent()
            val accountBean = GameTransferBean("0xb1cc25d88e0cf3e7767280f3eebc7d327433ac72","3W3pNNtQc6ZUh1UYTjo5XSs8ZLQuoPsJiA5X6fqm6XKXvzibCWyPpRUfT3SAUHdbiRkDW4ivRg7TaLVGVpGtoEKx")
            intent.putExtra(WithdrawalActivity.RESULT, gson.toJson(accountBean))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}