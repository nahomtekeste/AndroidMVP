package com.example.androidmvp.login

class LoginPresenter internal constructor(
    private var loginView: LoginView?,
    private val loginInteractor: LoginInteractor
) : LoginInteractor.OnLoginFinishedListener {

    fun validateCredentials(username: String, password: String) {
        if (loginView != null) {
            loginView!!.showProgress()
        }
        loginInteractor.login(username, password, this)
    }
    fun onDestroy() {
        loginView = null
    }

    override fun onUsernameError() {
        if (loginView != null) {
            loginView!!.setUsernameError()
            loginView!!.hideProgress()
        }
    }


    override fun onPasswordError() {
        if (loginView != null) {
            loginView!!.setPasswordError()
            loginView!!.hideProgress()
        }
    }

    override fun onSuccess() {
        if (loginView != null) {
            loginView!!.navigateToHome()
        }
    }
}