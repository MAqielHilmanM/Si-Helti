package com.automosen.si_helti.screens.appoinment.result

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.model.Hospital
import kotlinx.android.synthetic.main.activity_appoinment_result.*
import android.net.Uri


class AppoinmentResultActivity : BaseActivity() {
    var data : Hospital? = null
    var date : String? = null

    override fun setView(): Int {
        return com.automosen.si_helti.R.layout.activity_appoinment_result
    }

    override fun setToolbar(): Toolbar? {
        toolbar.title = ""
        return toolbar
    }

    override fun initView(savedInstanceState: Bundle?) {

        data = intent.getSerializableExtra(EXTRA_DATA) as Hospital
        date = intent.getStringExtra(EXTRA_DATE) as String
        tv_hospital_location.text = data?.name
        tv_hospital_address.text = data?.address
        tv_appoinment_result_date.text = date
    }

    override fun initListener() {
        btn_appoinment_direction.setOnClickListener {
            val intent = Intent(
                android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=${data?.latitude},${data?.longitude}")
            )
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_DATE = "extra_date"
        fun startActivity(context: Context, data : Hospital, date : String){
            val intent = Intent(context,AppoinmentResultActivity::class.java)
            intent.putExtra(EXTRA_DATA,data)
            intent.putExtra(EXTRA_DATE,date)
            context.startActivity(intent)
        }
    }

}
