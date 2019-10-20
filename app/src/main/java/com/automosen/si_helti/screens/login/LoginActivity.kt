package com.automosen.si_helti.screens.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.screens.dashboard.DashboardActivity
import com.automosen.si_helti.utils.PreferenceUtils
import com.automosen.si_helti.utils.Tools
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_login
    }

    override fun setToolbar(): Toolbar? {
        return null
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initListener() {
        btn_login_submit.setOnClickListener {
            if(validate()){
                val pd = Tools.showProgressDialog(this)
                Handler().postDelayed(
                    {
                        pd.dismiss()
                        val sp = PreferenceUtils(this)
                        sp.set("userId",et_login_username.text.toString())
                        DashboardActivity.startActivity(this)
                        finish()
                    },
                    2000
                )

            }
        }
    }

    fun validate() : Boolean{
        if(et_login_username.text.isNullOrEmpty()){
            et_login_username.error = "Required"
            et_login_username.requestFocus()
            return false
        }
        if(et_login_password.text.isNullOrEmpty()){
            et_login_password.error = "Required"
            et_login_password.requestFocus()
            return false
        }
        return true
    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,LoginActivity::class.java))
        }
    }

}
