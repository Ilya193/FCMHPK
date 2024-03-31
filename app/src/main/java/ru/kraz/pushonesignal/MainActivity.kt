package ru.kraz.pushonesignal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
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

        lifecycleScope.launch(Dispatchers.IO) {
            val token = HmsInstanceId.getInstance(this@MainActivity).getToken("110274235", "HCM")
            HmsMessaging.getInstance(this@MainActivity).subscribe("topic1")
            //OneSignalHmsEventBridge.onNewToken(this@MainActivity, token)
        }
    }
}