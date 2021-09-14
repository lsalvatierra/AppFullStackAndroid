package com.qbo.appfullstackandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.qbo.appfullstackandroid.api.ApiCursoService
import com.qbo.appfullstackandroid.api.RetrofitCliente
import com.qbo.appfullstackandroid.databinding.ActivityMainBinding
import com.qbo.appfullstackandroid.model.Curso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnguardar.setOnClickListener {
            val nuevoCurso = Curso(0,
                binding.etnomcurso.text.toString(),
                binding.etcredcurso.text.toString().toInt(),
                binding.etcategcurso.text.toString(),
            )
            val call: Call<Curso> =  RetrofitCliente.retrofitService.registrarCurso(nuevoCurso)
                call.enqueue(
                object: Callback<Curso>{
                    override fun onResponse(call: Call<Curso>, response: Response<Curso>) {
                        if(response.isSuccessful){
                            Toast.makeText(applicationContext,
                            "Curso registrado", Toast.LENGTH_LONG).show()
                        }
                    }
                    override fun onFailure(call: Call<Curso>, t: Throwable) {
                        Toast.makeText(applicationContext,
                            "Error al conectar al API", Toast.LENGTH_LONG).show()
                    }

                }
            )
        }
        binding.btnverlista.setOnClickListener {
            startActivity(Intent(applicationContext,
                ListaCursoActivity::class.java))
        }
    }
}