package com.automosen.si_helti.screens.appoinment.form

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.screens.appoinment.result.AppoinmentResultActivity
import kotlinx.android.synthetic.main.activity_appoinment_form.*
import kotlinx.android.synthetic.main.activity_diagnosa_form.*

class AppoinmentFormActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_appoinment_form
    }

    override fun setToolbar(): Toolbar? {
        return null
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initListener() {
        btn_appoinment_form.setOnClickListener {
            AppoinmentResultActivity.startActivity(this)
        }
    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,AppoinmentFormActivity::class.java))
        }
    }
}
