package com.automosen.si_helti.screens.diagnosa.form

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.screens.diagnosa.DiagnosaActivity
import kotlinx.android.synthetic.main.activity_diagnosa_form.*

class DiagnosaFormActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_diagnosa_form
    }

    override fun setToolbar(): Toolbar? {
        toolbar.title = ""
        return toolbar
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initListener() {
        btn_diagnose_form.setOnClickListener {
            DiagnosaActivity.startActivity(this)
        }
    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,DiagnosaFormActivity::class.java))
        }
    }
}
