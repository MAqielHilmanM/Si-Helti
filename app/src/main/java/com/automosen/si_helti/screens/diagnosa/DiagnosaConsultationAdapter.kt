package com.automosen.si_helti.screens.diagnosa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.model.Hospital
import com.automosen.si_helti.screens.appoinment.form.AppoinmentFormActivity
import kotlinx.android.synthetic.main.item_diagnosa_consultation_hospital.view.*

class DiagnosaConsultationAdapter(private val children : List<Hospital>)
    : RecyclerView.Adapter<DiagnosaConsultationAdapter.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v =  LayoutInflater.from(parent.context)
                .inflate(R.layout.item_diagnosa_consultation_hospital,parent,false)
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
        fun initData(child : Hospital){
            // TODO : Initiate Variable Here
            itemView.tv_hospital_location.text = child.name
        }

        fun initListener(context : Context, child : Hospital){
            // TODO : Initiate Listener Here
            itemView.setOnClickListener{
                // TODO : Do Something after item click
                AppoinmentFormActivity.startActivity(context,child)
            }
        }
    }
}
