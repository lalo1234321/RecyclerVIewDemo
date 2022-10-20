package com.dev.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.recyclerview.interfaces.ClickListener
import com.dev.recyclerview.models.Platillo

class  MainActivity : AppCompatActivity() {

    var lista:RecyclerView? = null

    var customAdapter:CustomAdapter? = null
    //se gestionar un layout vertical u horizontal
    var layoutManager:RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val platillos = ArrayList<Platillo>()
        platillos.add(Platillo("Platillo 1", 250.0, 2.5F, R.drawable.platillo01))
        platillos.add(Platillo("Platillo 2", 220.0, 1.5F, R.drawable.platillo02))
        platillos.add(Platillo("Platillo 3", 220.0, 1.5F, R.drawable.platillo03))
        platillos.add(Platillo("Platillo 4", 220.0, 1.5F, R.drawable.platillo04))
        platillos.add(Platillo("Platillo 5", 220.0, 1.5F, R.drawable.platillo05))
        platillos.add(Platillo("Platillo 6", 220.0, 1.5F, R.drawable.platillo06))
        platillos.add(Platillo("Platillo 7", 220.0, 1.5F, R.drawable.platillo07))
        platillos.add(Platillo("Platillo 8", 220.0, 1.5F, R.drawable.platillo08))
        platillos.add(Platillo("Platillo 9", 220.0, 1.5F, R.drawable.platillo09))
        platillos.add(Platillo("Platillo 10", 220.0, 1.5F, R.drawable.platillo10))
        lista = findViewById(R.id.lista)
        lista?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        //Desde donde quiero que se muestre la lista
        lista?.layoutManager = layoutManager
        //de esta forma se implementa el método de la intefaz onClick
        customAdapter = CustomAdapter(this, platillos, object:ClickListener{
            override fun onClick(vista: View, index: Int) {
                Toast.makeText(applicationContext, platillos.get(index).nombre,Toast.LENGTH_SHORT).show()
            }

        })
        lista?.adapter = customAdapter

    }
}