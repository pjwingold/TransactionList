package au.com.pjwin.transaction_list

import au.com.pjwin.commonlib.BaseApplication
import au.com.pjwin.commonlib.Common
import au.com.pjwin.transaction_list.util.AppConfig

open class TransactionApp : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        initCommon()
    }

    protected open fun initCommon() {
        Common.init(applicationContext, AppConfig())
    }
}