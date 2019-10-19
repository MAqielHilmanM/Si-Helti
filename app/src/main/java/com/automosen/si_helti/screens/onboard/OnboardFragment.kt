package com.automosen.si_helti.screens.onboard

import android.os.Bundle
import android.view.View
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_onboard.*

class OnboardFragment :
    BaseFragment() {
    override fun setView(): Any {
        return R.layout.fragment_onboard
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        val pos = arguments?.getInt(EXTRA_DATA)?: 0
        when(pos){
            1 -> {
                title.text = "Diagnosis of Your Health"
                deskripsi.text = "Diagnose yourself before anything goes wrong"
                gambar.setImageResource(R.drawable.onboard)
            }
            2 -> {
                title.text = "Diagnosis of Your Health"
                deskripsi.text = "Easily diagnose your health by your condition through a simple text input"
                gambar.setImageResource(R.drawable.onboard)
            }
            3 -> {
                title.text = "Diagnosis of Your Health"
                deskripsi.text = "The system will response to your input and show predicted decease that come into possibility base on your diagnosis"
                gambar.setImageResource(R.drawable.onboard)
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
        fun newInstance(pos : Int) : OnboardFragment {
            val fragment = OnboardFragment()
            val args = Bundle()
            args.putInt(EXTRA_DATA,pos)
            fragment.arguments = args
            return fragment
        }

    }
}
