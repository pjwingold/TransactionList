package au.com.pjwin.transaction_list

import android.app.Application
import au.com.pjwin.commonlib.Common
import au.com.pjwin.transaction_list.util.AppConfig

open class TransactionApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initCommon()
    }

    protected open fun initCommon() {
        Common.init(applicationContext, AppConfig())
    }
}