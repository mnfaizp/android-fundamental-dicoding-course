package com.example.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.fundamental.databinding.ActivityJsonBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class JsonActivity : AppCompatActivity() {

    companion object {
        private val TAG = JsonActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityJsonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRandomQuote()

        binding.btnShowQuotes.setOnClickListener {
            startActivity(Intent(this@JsonActivity, ListQuotesActivity::class.java))
        }
    }

    private fun getRandomQuote() {
        binding.pgQuotes.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://quote-api.dicoding.dev/random"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
                binding.pgQuotes.visibility = View.INVISIBLE

                val result = String(responseBody!!)
                Log.d(TAG, result)

                try {
                    val responseObject = JSONObject(result)

                    val quote = responseObject.getString("en")
                    val author = responseObject.getString("author")

                    binding.tvQuoteBody.text = quote
                    binding.tvQuotesAuthor.text = author
                } catch (e: Exception) {
                    Toast.makeText(this@JsonActivity, e.message, Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                binding.pgQuotes.visibility = View.INVISIBLE

                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Toast.makeText(this@JsonActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}