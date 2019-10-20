package com.automosen.si_helti.screens.appoinment.form

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.model.Hospital
import com.automosen.si_helti.screens.appoinment.result.AppoinmentResultActivity
import kotlinx.android.synthetic.main.activity_appoinment_form.*
import java.io.Serializable

class AppoinmentFormActivity : BaseActivity() {

    var data : Hospital? = null

    override fun setView(): Int {
        return R.layout.activity_appoinment_form
    }

    override fun setToolbar(): Toolbar? {
        return null
    }

    override fun initView(savedInstanceState: Bundle?) {
        data = intent.getSerializableExtra(EXTRA_DATA) as Hospital
        tv_hospital_location.text = data?.name
    }

    override fun initListener() {
        btn_appoinment_form.setOnClickListener {
            AppoinmentResultActivity.startActivity(this,data!!,et_appoinment_date_value.text.toString())
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
        fun startActivity(context: Context, data: Hospital) {
            val intent = Intent(context, AppoinmentFormActivity::class.java)
            intent.putExtra(EXTRA_DATA, data as Serializable)
            context.startActivity(intent)
        }
    }
}
