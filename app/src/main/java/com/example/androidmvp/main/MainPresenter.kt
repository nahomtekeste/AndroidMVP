package com.example.androidmvp.main

internal class MainPresenter(
    mainView: MainView,
    private val findItemsInteractor: FindItemsInteractor
) {

    var mainView: MainView? = null
        private set

    init {
        this.mainView = mainView
    }
    fun onResume() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        findItemsInteractor.findItems(({
            val it = null
            it?.let { it1 -> this.onFinished(it1) }
        }))

    }


    fun onItemClicked(item: String) {
        if (mainView != null) {
            mainView!!.showMessage(String.format("%s clicked", item))
        }
    }

    fun onDestroy() {
        mainView = null
    }

    fun onFinished(items: List<String>) {
        if (mainView != null) {
            mainView!!.setItems(items)
            mainView!!.hideProgress()
        }
    }

    fun onItemClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}