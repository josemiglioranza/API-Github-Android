package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote3 = Connection.createService(PostRepoOficial::class.java)
        val call3: Call<PostRepositoryOficial.PostRepository> = remote3.list()

        val response3 = call3.enqueue(object : Callback<PostRepositoryOficial.PostRepository> {
            override fun onFailure(call: Call<PostRepositoryOficial.PostRepository>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                println(t.message)
            }

            override fun onResponse(
                call: Call<PostRepositoryOficial.PostRepository>,response: Response<PostRepositoryOficial.PostRepository>) {
                if (response.isSuccessful) {
                    var repo: PostRepositoryOficial.PostRepository = response.body()!!
                    recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = Adapter(repo)
                    recycler.adapter = adapter
                }
            }
        })
    }
}
