package com.automosen.si_helti.screens.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity

class RegisterActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_register
    }

    override fun setToolbar(): Toolbar? {
        return null
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initListener() {

    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,RegisterActivity::class.java))
        }
    }
}
