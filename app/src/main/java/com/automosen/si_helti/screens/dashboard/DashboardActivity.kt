package com.automosen.si_helti.screens.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.utils.BottomNavigationBehaviour
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_dashboard
    }

    override fun setToolbar(): Toolbar? {
        return null
    }

    override fun initView(savedInstanceState: Bundle?) {
        loadFragment(DashboardFragment())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loadFragment(DashboardFragment())
    }

    override fun initListener() {
    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fm_container, fragment)
        transaction.commit()
    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,DashboardActivity::class.java))
        }
    }
}
