package com.automosen.si_helti.screens.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.screens.dashboard.DashboardActivity
import com.automosen.si_helti.screens.login.LoginActivity
import com.automosen.si_helti.screens.onboard.OnboardActivity
import com.automosen.si_helti.utils.PreferenceUtils

class SplashActivity : BaseActivity() {
    override fun setToolbar(): Toolbar? {
        return null
    }

    override fun setView(): Int {
        return R.layout.activity_splash
    }

    override fun initView(savedInstanceState: Bundle?) {
        val sp = PreferenceUtils(this)
        val userId = sp.get(String::class,"userId","") as String

        Handler().postDelayed(
            {
                if(userId.isNotEmpty()){
                    DashboardActivity.startActivity(this)
                    finish()
                }else{
                    OnboardActivity.startActivity(this)
                    finish()
                }
            },
            2000
        )

    }

    override fun initListener() {

    }

}
