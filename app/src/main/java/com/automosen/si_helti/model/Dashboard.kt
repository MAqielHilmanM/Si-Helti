package com.automosen.si_helti.model

data class Dashboard (
    val viewType : DashboardType,
    val title : String,
    val lists : List<Any>
)

enum class DashboardType{
    Disease,
    History
}