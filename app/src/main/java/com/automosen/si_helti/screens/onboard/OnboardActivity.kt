package com.automosen.si_helti.screens.onboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.screens.login.LoginActivity
import kotlinx.android.synthetic.main.activity_onboard.*

class OnboardActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_onboard
    }

    override fun setToolbar(): Toolbar? {
        return null
    }

    override fun initView(savedInstanceState: Bundle?) {
        val adapter = OnboardAdapter(supportFragmentManager)
        var pos = 0

        container.adapter = adapter
        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                pos = position

                skip_button.visibility =
                    if(position == 0) View.VISIBLE
                    else View.GONE
                previous_button.visibility =
                    if(position == 0) View.GONE
                    else View.VISIBLE
                button_next.visibility =
                    if(position == 2) View.GONE
                    else View.VISIBLE
                button_finish.visibility =
                    if(position == 2) View.VISIBLE
                    else View.GONE
            }

        })
    }

    override fun initListener() {
        val onClick = View.OnClickListener{
            when(it.id){
                R.id.skip_button -> {
                    LoginActivity.startActivity(this)
                    finish()
                }
                R.id.previous_button -> container.setCurrentItem(container.currentItem - 1,true)

                R.id.button_next -> container.setCurrentItem(container.currentItem + 1,true)
                R.id.button_finish-> {
                    LoginActivity.startActivity(this)
                    finish()
                }
            }
        }

        button_finish.setOnClickListener(onClick)
        button_next.setOnClickListener(onClick)
        previous_button.setOnClickListener(onClick)
        skip_button.setOnClickListener(onClick)
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, OnboardActivity::class.java))
        }
    }
}
