package com.example.androidmvp.login

import android.os.Handler
import android.text.TextUtils
import androidx.core.os.HandlerCompat.postDelayed

class LoginInteractor {
    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }


    fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        Handler().postDelayed({
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError()
                return@postDelayed Handler().postDelayed() as Unit
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError()
                return@postDelayed Handler().postDelayed() as Unit
            }
            listener.onSuccess()
        }, 2000)
    }
}

private fun Handler.postDelayed(): Any {
 return postDelayed()
}

