package com.example.superheroe

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superheroe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //1- Añadimos dataBinding

        var binding = ActivityMainBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //2-Le damos funcionalidad al boton
        binding.saveButton.setOnClickListener{
            val superHeroName = binding.etHeroname.text.toString()
            val alterego = binding.etAlterego.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.powerBar.rating
            openDetailActivity(superHeroName, alterego, bio, power)
        }
    }

    //3- Creamos la funcion que genera un Intent y nos lleva a detalle
    //7- Añadimos los valores en el metodo para pasarselo al activity
    private fun openDetailActivity(
        superHeroName: String,
        alterego: String,
        bio: String,
        power: Float
    ) {
        TODO("Not yet implemented")
        //4- Vamos a abrir RegisterActivity, el Intent debe tener muy claro desde donde se le llama y a donde va
        val intent = Intent(this, RegisterActivity::class.java)

        //8- Añado los valores al Intent con la funcion putExtra
        intent.putExtra("heroName", superHeroName)
        intent.putExtra("alterEgo", alterego)
        intent.putExtra("bio", bio)
        intent.putExtra("power", power)
        //5- Para utilizar el intent tenemos que llamar a startActivity
        startActivity(intent)
    }
}