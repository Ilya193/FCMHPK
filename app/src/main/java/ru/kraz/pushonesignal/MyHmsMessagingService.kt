package ru.kraz.pushonesignal

import com.huawei.hms.push.HmsMessageService
import com.huawei.hms.push.RemoteMessage

class MyHmsMessagingService : HmsMessageService() {

    override fun onNewToken(p0: String?) {
        super.onNewToken(p0)
        println("s149 onNewToken $p0")
    }

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)
        println("s149 onMessageReceived ${p0?.data}")
    }
}