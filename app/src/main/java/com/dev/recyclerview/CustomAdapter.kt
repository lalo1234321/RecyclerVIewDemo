package com.dev.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.recyclerview.interfaces.ClickListener
import com.dev.recyclerview.models.Platillo

//De esta forma se crea el contexto sin necesidad de mapear el dato
class CustomAdapter(var context:Context, items:ArrayList<Platillo>, var listener: ClickListener):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    var items:ArrayList<Platillo>? = null
    init {
        this.items = items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Crear el viewHolder, meter el archivo xml(el template) en la variable vista
        val vista = LayoutInflater.from(context).inflate(R.layout.template_platillos, parent, false)
        val viewHolder = ViewHolder(vista, listener)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto?.setImageResource(item?.foto!!)
        holder.nombre?.text = item?.nombre!!
        holder.precio?.text = "$ "+item?.precio.toString()!!
        holder.rating?.rating = item?.rating!!

    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }
    class ViewHolder(vista:View, listener:ClickListener): RecyclerView.ViewHolder(vista) ,View.OnClickListener{
        var vista= vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var precio:TextView? = null
        var rating:RatingBar? = null
        var listener:ClickListener? = null
        init {
            foto = vista.findViewById(R.id.foto)
            nombre = vista.findViewById(R.id.tvNombre)
            precio = vista.findViewById(R.id.tvPrecio)
            rating = vista.findViewById(R.id.txRating)
            this.listener = listener
            //viewholder recibe el evento clicklistener y lo mapea en la interfaz custom para poder ocuparlo desde la activity
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //adapter position devuelve la posición actual del elemento
            //El viewholder debe de implementar OnClickLister, se cutomiza el procesamiento del onclick por medio de otra interfaz
            //
            this.listener?.onClick(v!!, adapterPosition)
        }
    }
}