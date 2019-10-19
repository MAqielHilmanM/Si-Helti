package com.automosen.si_helti.screens.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.model.Dashboard
import com.automosen.si_helti.model.DashboardType
import com.automosen.si_helti.model.Disease
import com.automosen.si_helti.model.History
import com.automosen.si_helti.screens.disease.DiseaseActivity
import kotlinx.android.synthetic.main.item_dashboard.view.*

class DashboardAdapter(private val children : List<Dashboard>)
    : RecyclerView.Adapter<DashboardAdapter.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v =  LayoutInflater.from(parent.context)
                .inflate(R.layout.item_dashboard,parent,false)
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
        fun initData(child : Dashboard){
            itemView.tv_dashboard_item_title.text = child.title
            itemView.tv_dashboard_item_more.setOnClickListener {
                DiseaseActivity.startActivity(context)
            }
            if(child.viewType == DashboardType.Disease){
                itemView.spacer.visibility = View.GONE
                itemView.rv_dashboard.apply {
                    layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
                    adapter = DashboardAdapterDisease(child.lists as List<Disease>)
                    setRecycledViewPool(this.recycledViewPool)
                    hasFixedSize()
                }
                itemView.btn_show_maps.setOnClickListener {
                    DiseaseActivity.startActivity(context)
                }
            }else{
                itemView.spacer.visibility = View.GONE
                itemView.btn_show_maps.visibility = View.GONE
                itemView.tv_dashboard_item_subtitle.visibility = View.GONE
                itemView.rv_dashboard.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = DashboardAdapterHistory(child.lists as List<History>)
                    setRecycledViewPool(this.recycledViewPool)
                    hasFixedSize()
                }

                if(child.lists.isEmpty()){
                    itemView.tv_empty.visibility = View.VISIBLE
                    itemView.rv_dashboard.visibility = View.GONE
                }else{
                    itemView.tv_empty.visibility = View.GONE
                    itemView.rv_dashboard.visibility = View.VISIBLE
                }
            }
        }

        fun initListener(context : Context, child : Dashboard){
            // TODO : Initiate Listener Here
            itemView.setOnClickListener{
                // TODO : Do Something after item click
            }
        }
    }
}
