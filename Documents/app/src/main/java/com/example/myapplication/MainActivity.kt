package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_teste_card_v.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote3 = Connection.createService(PostRepoOficial::class.java)
        val call3: Call<List<PostRepositoryOficial.PostRepository>> = remote3.list()

        val response3 = call3.enqueue(object : Callback<List<PostRepositoryOficial.PostRepository>> {
            override fun onFailure(call: Call<List<PostRepositoryOficial.PostRepository>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                println(t.message)
            }

            override fun onResponse(
                call: Call<List<PostRepositoryOficial.PostRepository>>,response: Response<List<PostRepositoryOficial.PostRepository>>) {
                if (response.isSuccessful) {
                    var repo: List<PostRepositoryOficial.PostRepository> = response.body()!!
                    recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = Adapter(repo)
                    recycler.adapter = adapter
                }
            }
        })
    }
}
