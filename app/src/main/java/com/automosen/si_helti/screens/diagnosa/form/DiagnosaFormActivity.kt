package com.automosen.si_helti.screens.diagnosa.form

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.screens.diagnosa.DiagnosaActivity
import com.automosen.si_helti.utils.Tools
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

    fun isValid() : Boolean{
        if(seekbar_diagnosis_scale_value.progress == 0){
            Tools.buildSnackbar(coordinator,"please select pain scale")
            return false
        }
        if(et_diagnosis_pain_form.text.isNullOrEmpty()){
            et_diagnosis_pain_form.error = "required"
            et_diagnosis_pain_form.requestFocus()
            return false
        }
        if(et_diagnosis_desc_form.text.isNullOrEmpty()){
            et_diagnosis_desc_form.error = "required"
            et_diagnosis_desc_form.requestFocus()
            return false
        }
        if(et_diagnosis_long_form.text.isNullOrEmpty()){
            et_diagnosis_long_form.error = "required"
            et_diagnosis_long_form.requestFocus()
            return false
        }
        return true

    }
    override fun initListener() {
        btn_diagnose_form.setOnClickListener {
            if(isValid()){
                val pb = Tools.showProgressDialog(this)
                Handler().postDelayed(
                    {
                        pb.dismiss()
                        DiagnosaActivity.startActivity(this)
                        finish()
                    },
                    2000
                )
            }
        }
    }



    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,DiagnosaFormActivity::class.java))
        }
    }
}
