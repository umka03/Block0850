
package com.example.block0850

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telecom.TelecomManager
import android.telephony.TelephonyManager

class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
        val number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

        if (state == TelephonyManager.EXTRA_STATE_RINGING && number != null) {
            if (
                number.startsWith("0850") ||
                number.startsWith("444") ||
                number.startsWith("0212")
            ) {
                val tm = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
                tm.endCall()
            }
        }
    }
}

