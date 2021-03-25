package com.example.fundamental

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.text.DecimalFormat

class GetCurrentWeatherJobService : JobService() {

    companion object {
        private val TAG = GetCurrentWeatherJobService::class.java.simpleName

        //city name
        internal const val CITY = "Bukittinggi"

        //API Key
        internal const val APP_ID = "caab4f03f4f4f0b87e0d69427f1f5a43"
    }

    private fun getCurrentWeather(params: JobParameters?) {
        Log.d(TAG, "getCurrentWeather: Start")

        val client = AsyncHttpClient()
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$CITY&appid=$APP_ID"
        Log.d(TAG, "getCurrentWeather: $url")

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                val result = String(responseBody!!)
                Log.d(TAG, result)

                try {
                    val responseObject = JSONObject(result)

                    val currentWeather = responseObject.getJSONArray("weather").getJSONObject(0).getString("main")
                    val description = responseObject.getJSONArray("weather").getJSONObject(0).getString("description")
                    val tempKelvin = responseObject.getJSONObject("main").getDouble("temp")

                    val tempCelsius = tempKelvin - 273
                    val temperature = DecimalFormat("##.##").format(tempCelsius)
                    val notificationId = 100

                    val title = "Current Weather"
                    val message = "$currentWeather, $description with $temperature celsius"

                    showNotification(applicationContext, title, message, notificationId)

                    jobFinished(params, false)

                } catch (e: Exception) {
                    jobFinished(params, true)
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Log.d(TAG, "onFailure: Fail")
                jobFinished(params, true)
            }
        })
    }

    private fun showNotification(applicationContext: Context?, title: String, message: String, notificationId: Int) {
        val CHANNEL_ID = "channel_id"
        val CHANNEL_NAME = "scheduler_channel"

        val notificationManagerCompat = applicationContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.ic_baseline_date_range_24)
            .setContentText(message)
            .setColor(ContextCompat.getColor(applicationContext, android.R.color.black))
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setSound(alarmSound)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(1000, 1000, 1000, 1000, 1000)
            builder.setChannelId(CHANNEL_ID)
            notificationManagerCompat.createNotificationChannel(channel)
        }

        val notification = builder.build()

        notificationManagerCompat.notify(notificationId, notification)
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d(TAG, "onStartJob(): ")
        getCurrentWeather(params)

        return true
    }



    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d(TAG, "onStopJob(): ")
        return true
    }
}