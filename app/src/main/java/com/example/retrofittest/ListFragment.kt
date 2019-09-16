package com.example.retrofittest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.adapter.CustomAdapter
import com.example.retrofittest.listener.AdapterListener
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    var adapter: CustomAdapter? = null

    var vm: MainActivityViewModel? = null
    val CHANNEL_ID = "my_channel_1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


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
        val builder = context?.let {
            NotificationCompat.Builder(it, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                //  .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }

        with(context?.let { NotificationManagerCompat.from(it) }) {
            // notificationId is a unique int for each notification that you must define
            builder?.build()?.let { this?.notify(1, it) }
        }
        vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        vm?.data?.observe(this, object : Observer<List<DataModel>> {
            /**
             * Called when the data is changed.
             * @param t  The new data
             */
            override fun onChanged(t: List<DataModel>?) {
                adapter = context?.let { CustomAdapter(it, t) }
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = adapter


            }


        })
        vm?.GetData()


        adapter?.Alistener = object : AdapterListener {
            override fun listener(pos: Int) {
                Toast.makeText(context, "this is listner!!!!!!!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT)
                    .show()

                val newFragment = BlankFragment()
                /* Bundle args = Bundle()
                 args.putInt(ArticleFragment.ARG_POSITION, position)
                 newFragment.arguments = args*/

                val transaction = activity?.supportFragmentManager?.beginTransaction()?.apply {
                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    replace(R.id.frameLayout, newFragment)
                    addToBackStack(null)
                }

// Commit the transaction
                transaction?.commit()
            }
        }

    }
}




