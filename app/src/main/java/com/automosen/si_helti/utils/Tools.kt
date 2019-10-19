package com.automosen.si_helti.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.FileProvider
import com.automosen.si_helti.R
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import java.io.File
import java.sql.Timestamp
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import android.app.ProgressDialog



class Tools {
    companion object {
        const val FULLDATE_FORMAT = "dd/MMM/yyyy HH:mm"
        const val DATE_FORMAT = "EEEE, dd/MMM/yyyy"
        const val SIMPLE_DATE_FORMAT = "dd/MM/yyyy"
        const val TIME_FORMAT = "hh:mm a"

        fun showError(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun converterPrice(price: Double): String {
            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
            return formatRupiah.format(price)
        }
//
//        fun convertTimestamp(timestamp: Timestamp, format: String): String {
//            val sdf = SimpleDateFormat(format)
//            sdf.timeZone = TimeZone.getTimeZone("GMT+7")
//            val date = timestamp.toDate()
//            return sdf.format(date)
//        }
//
//        fun convertTimestamp(timestamp: Timestamp): Long {
//            val date = timestamp.toDate()
//            return date.time /1000
//        }
//
//        fun convertTimestamp(calendar: Calendar): Long {
//            val date = calendar.time
//            return date.time /1000
//        }

        fun loadImage(imageView: ImageView, url: String?) {
            if (!TextUtils.isEmpty(url) && url?.contains("http") == true) {
                Picasso.get()
                    .load(url)
                    .placeholder(com.automosen.si_helti.R.color.colorPrimaryDark)
                    .error(android.R.color.holo_red_light)
                    .into(imageView)
            }
        }

        fun buildAlertDialog(
            context: Context,
            message: String,
            negativeListener: DialogInterface.OnClickListener?,
            positiveListener: DialogInterface.OnClickListener?
        ) {
            var builder = AlertDialog.Builder(context)
            builder = builder.setMessage(message)

            if (negativeListener != null)
                builder = builder.setNegativeButton("TIDAK", negativeListener)
            if (positiveListener != null)
                builder = builder.setPositiveButton("YA", positiveListener)

            builder.create().show()
        }

        fun buildSnackbar(layout : CoordinatorLayout, message : String, actionName: String? = null, onClickListener: View.OnClickListener? = null){
            var snackbar = Snackbar.make(layout,message, Snackbar.LENGTH_LONG)
            if(actionName != null && onClickListener != null){
                snackbar = snackbar.setAction(actionName, onClickListener)
            }
            snackbar.show()
        }

        fun openFile(context: Context, file: File) {
            val uri = FileProvider.getUriForFile(context, context.applicationContext.packageName + ".provider", file)
            val intent = Intent(Intent.ACTION_VIEW)
            if (file.toString().contains(".doc")
                || file.toString().contains(".docx")) {
                // Word document
                intent.setDataAndType(uri, "application/msword")
            } else if (file.toString().contains(".pdf")) {
                // PDF file
                intent.setDataAndType(uri, "application/pdf")
            } else if (file.toString().contains(".ppt")
                || file.toString().contains(".pptx")) {
                // Powerpoint file
                intent.setDataAndType(uri, "application/vnd.ms-powerpoint")
            } else if (file.toString().contains(".xls")
                || file.toString().contains(".xlsx")) {
                // Excel file
                intent.setDataAndType(uri, "application/vnd.ms-excel")
            } else if (file.toString().contains(".zip")
                || file.toString().contains(".rar")) {
                // WAV audio file
                intent.setDataAndType(uri, "application/x-wav")
            } else if (file.toString().contains(".rtf")) {
                // RTF file
                intent.setDataAndType(uri, "application/rtf")
            } else if (file.toString().contains(".wav")
                || file.toString().contains(".mp3")) {
                // WAV audio file
                intent.setDataAndType(uri, "audio/x-wav")
            } else if (file.toString().contains(".gif")) {
                // GIF file
                intent.setDataAndType(uri, "image/gif")
            } else if (file.toString().contains(".jpg")
                || file.toString().contains(".jpeg")
                || file.toString().contains(".png")
            ) {
                // JPG file
                intent.setDataAndType(uri, "image/jpeg")
            } else if (file.toString().contains(".txt")) {
                // Text file
                intent.setDataAndType(uri, "text/plain")
            } else if (file.toString().contains(".3gp")
                || file.toString().contains(".mpg")
                || file.toString().contains(".mpeg")
                || file.toString().contains(".mpe")
                || file.toString().contains(".mp4")
                || file.toString().contains(".avi")
            ) {
                // Video files
                intent.setDataAndType(uri, "video/*")
            } else {
                //if you want you can also define the intent type for any other file
                intent.setDataAndType(uri, "*/*")
            }

            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

        fun showProgressDialog(context: Context) : ProgressDialog{
            val pd = ProgressDialog(context)
            pd.setMessage("loading")
            pd.show()
            return pd
        }
    }

}