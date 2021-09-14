package com.qbo.appfullstackandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.qbo.appfullstackandroid.api.RetrofitCliente
import com.qbo.appfullstackandroid.databinding.ActivityListaCursoBinding
import com.qbo.appfullstackandroid.model.Curso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R

class ListaCursoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListaCursoBinding
    var listaCurso = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val call : Call<List<Curso>> = RetrofitCliente.retrofitService.listarCurso()
        call.enqueue(object : Callback<List<Curso>>{
            override fun onResponse(call: Call<List<Curso>>, response: Response<List<Curso>>) {
                for (objCurso in response.body()!!){
                    listaCurso.add(objCurso.nombre)
                }
                val adapter = ArrayAdapter(
                    applicationContext,
                    R.layout.simple_list_item_1,
                    listaCurso
                )
                binding.lvcursos.adapter = adapter
            }

            override fun onFailure(call: Call<List<Curso>>, t: Throwable) {

            }

        })
    }
}