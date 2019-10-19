package com.automosen.si_helti.screens.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.model.Disease
import com.automosen.si_helti.screens.disease.DiseaseActivity
import com.automosen.si_helti.screens.disease.detail.DiseaseDetailActivity

class DashboardAdapterDisease(private val children : List<Disease>)
    : RecyclerView.Adapter<DashboardAdapterDisease.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v =  LayoutInflater.from(parent.context)
                .inflate(R.layout.item_dashboard_disease,parent,false)
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
        fun initData(child : Disease){
            // TODO : Initiate Variable Here
        }

        fun initListener(context : Context, child : Disease){
            // TODO : Initiate Listener Here
            itemView.setOnClickListener{
                // TODO : Do Something after item click
                DiseaseDetailActivity.startActivity(context)
            }
        }
    }
}
