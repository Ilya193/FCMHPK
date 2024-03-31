package ru.kraz.pushonesignal

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import com.google.firebase.messaging.FirebaseMessaging
import com.huawei.hms.aaid.HmsInstanceId
import com.huawei.hms.api.HuaweiApiAvailability
import com.huawei.hms.common.internal.HmsClient
import com.huawei.hms.push.HmsMessaging
import com.onesignal.notifications.bridges.OneSignalHmsEventBridge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val permission = registerForActivityResult(ActivityResultContracts.RequestPermission()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(Dispatchers.IO) {
            val phoneIs = HuaweiApiAvailability.getInstance()
                .isHuaweiMobileServicesAvailable(this@MainActivity)
            if (phoneIs == 1) {
                FirebaseMessaging.getInstance().subscribeToTopic("topic1")
            } else {
                val token = HmsInstanceId.getInstance(this@MainActivity).getToken("110274235", "HCM")
                HmsMessaging.getInstance(this@MainActivity).subscribe("topic1")
            }

            //OneSignalHmsEventBridge.onNewToken(this@MainActivity, token)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_DENIED
            ) {
                permission.launch(android.Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}