package com.example.vaccinationschedule.myJSON

import android.os.AsyncTask
import com.example.vaccinationschedule.BasicFunctions.globalStrings
import com.example.vaccinationschedule.Model.CurrentUserEntity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class mJSON {


    fun getEmailEntity(email: String) {
        var url = "http://hackathonv1.azurewebsites.net/home/test2?email=" + email
        myAsyncTask().execute(url)
    }

    inner class myAsyncTask : AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: String?): String {
            try {

                var url = URL(p0[0])
                val urlConnect = url.openConnection() as HttpURLConnection
                urlConnect.connectTimeout = 7000

                var inString = convertStreamToString(urlConnect.inputStream)
                publishProgress(inString)
            } catch (ex: Exception) {

            }
            return null!!
        }

        override fun onProgressUpdate(vararg values: String?) {
            try {
                var json = JSONObject(values[0])
                val language = json.getJSONObject(globalStrings.email_language) as String
                val ALevalFormat = json.getJSONObject(globalStrings.email_ALevalFormat)as String
                val ULevalFormat = json.getJSONObject(globalStrings.email_ULevalFormat)as String
                val UserName = json.getJSONObject(globalStrings.email_UserName)as String
                val DomainName = json.getJSONObject(globalStrings.email_DomainName)as String
                val TLD = json.getJSONObject(globalStrings.email_TLD)as String

                //use this object
                CurrentUserEntity(language,ALevalFormat,ULevalFormat,UserName,DomainName,TLD)

            } catch (ex: Exception) {

            }
        }

        override fun onPostExecute(result: String?) {

        }

    }

    fun convertStreamToString(inputstream: InputStream): String {
        val bufferReader = BufferedReader(InputStreamReader(inputstream))
        var line: String?
        var allStrings: String = ""

        try {
            do {
                line = bufferReader.readLine()
                if (line != null) {
                    allStrings += line
                }
            } while (line != null)
            inputstream.close()
        } catch (ex: Exception) {
        }
        return allStrings
    }
}