package com.automosen.si_helti.screens.disease.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import kotlinx.android.synthetic.main.item_diagnosa_things_point.view.*

class DiseaseDetailAdapter(private val children : List<String>)
    : RecyclerView.Adapter<DiseaseDetailAdapter.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v =  LayoutInflater.from(parent.context)
                .inflate(R.layout.item_diagnosa_things_point,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]

        holder.initData(child)
        holder.initListener(context,child)
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun initData(child : String){
            itemView.tv_things_title.text = child
        }

        fun initListener(context : Context, child : String){
            // TODO : Initiate Listener Here
            itemView.setOnClickListener{
                // TODO : Do Something after item click
            }
        }
    }
}
