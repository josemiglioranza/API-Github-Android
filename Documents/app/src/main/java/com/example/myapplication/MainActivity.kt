package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IndexOutOfBoundsException

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //A variável call3 não influencia no crash do aplicativo
        var paramsPage = 1
        val remote3 = Connection.createService(PostRepoOficial::class.java)

        val callPostRepository: Call<PostRepositoryOficial.PostRepository> = remote3.list("language:Java", "stars", paramsPage++)
        var i = 0

        fun setEndlessScroll() {
            var scrollListener = object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    
                }
            }
        }

        val response3 = callPostRepository.enqueue(object : Callback<PostRepositoryOficial.PostRepository> {
            override fun onFailure(call: Call<PostRepositoryOficial.PostRepository>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                println(t.message)
            }

            override fun onResponse(
                call: Call<PostRepositoryOficial.PostRepository>,
                response: Response<PostRepositoryOficial.PostRepository>
            ) {
                if (response.isSuccessful) {
                    var repo: PostRepositoryOficial.PostRepository = response.body()!!
                    recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = Adapter(repo)
                    recycler.adapter = adapter
                    i++
                }
            }
        })
    }
}


