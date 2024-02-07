package ru.kraz.pushonesignal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.huawei.hms.aaid.HmsInstanceId
import com.huawei.hms.common.internal.HmsClient
import com.huawei.hms.push.HmsMessaging
import com.onesignal.notifications.bridges.OneSignalHmsEventBridge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val token = HmsInstanceId.getInstance(this@MainActivity).getToken("110274235", "HCM")
            Log.i("s149", token)
            HmsMessaging.getInstance(this@MainActivity).subscribe("test_topic")
        }
    }
}