package com.example.apigithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var paramsPage = 1
        val remote3 = Connection.createService(Repository::class.java)

        val callPostRepository: Call<Domain.Items> = remote3.list("language:Java", "stars", paramsPage++)
        var i = 0

        fun setEndlessScroll() {
            var scrollListener = object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                }
            }
        }

        val response3 = callPostRepository.enqueue(object :
            Callback<Domain.Items> {
            override fun onFailure(call: Call<Domain.Items>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                println(t.message)
            }

            override fun onResponse(
                call: Call<Domain.Items>,
                response: Response<Domain.Items>
            ) {
                if (response.isSuccessful) {
                    var repo: Domain.Items = response.body()!!
                    rec.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = Adapter(repo)
                    rec.adapter = adapter
                    i++
                }
            }
        })
    }
}