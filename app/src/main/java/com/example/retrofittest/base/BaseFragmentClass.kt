package com.example.retrofittest.base

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.retrofittest.BlankFragment
import com.example.retrofittest.R

open class BaseFragmentClass : Fragment(), FragmentInterface {


    val CHANNEL_ID = "my_channel_1"
    override fun addFragment(frag: Fragment, flag: Boolean) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()?.apply {
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            replace(R.id.frameLayout, frag)
            if (flag)
                addToBackStack(null)
        }


        transaction?.commit()
    }

    override fun setFragment(frag: Fragment, flag: Boolean) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.add(R.id.frameLayout, frag)
        fragmentTransaction?.commit()
    }


    override fun setNotifuication(title: String, body: String, intent: String) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager? =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager?.createNotificationChannel(channel)
        }

        //intent
        var blank = intent
        val intent = Intent(context, blank::class.java).apply {
            flags =  Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)


        val builder = context?.let {
            NotificationCompat.Builder(it, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }

        with(context?.let { NotificationManagerCompat.from(it) }) {
            // notificationId is a unique int for each notification that you must define
            builder?.build()?.let { this?.notify(1, it) }
        }
    }
}