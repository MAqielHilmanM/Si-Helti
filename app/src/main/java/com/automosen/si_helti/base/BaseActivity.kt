package com.automosen.si_helti.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes
    protected abstract fun setView(): Int

    protected abstract fun setToolbar(): Toolbar?

    protected abstract fun initView(savedInstanceState: Bundle?)

    protected abstract fun initListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setView() != 0) {
            setContentView(setView())
        }
        initToolbar(setToolbar())
        initView(savedInstanceState)
        initListener()
    }

    private fun initToolbar(toolbar: Toolbar?) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }
}