package com.automosen.si_helti.screens.appoinment.result

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import kotlinx.android.synthetic.main.activity_appoinment_result.*

class AppoinmentResultActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_appoinment_result
    }

    override fun setToolbar(): Toolbar? {
        toolbar.title = ""
        return toolbar
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initListener() {
        btn_appoinment_direction.setOnClickListener {

        }
    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,AppoinmentResultActivity::class.java))
        }
    }

}
