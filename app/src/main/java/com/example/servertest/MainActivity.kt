package com.example.servertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.coroutines.*
//import kotlinx.serialization.decodeFromString
//import kotlinx.serialization.json.Json
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseUrl: String = "http://192.168.0.111:8080"
        val client = HttpClient(){
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
        }
        val url2: String = "$baseUrl/rest/students/"

        System.out.println(url2)

        GlobalScope.launch(Dispatchers.IO) {
            val data = client.get<List<Item<Student>>>{
                url(url2)
            }
//            val json = Json.decodeFromString<List<Item<Student>>>(data)
//            System.out.println(json)
        }
    }
}