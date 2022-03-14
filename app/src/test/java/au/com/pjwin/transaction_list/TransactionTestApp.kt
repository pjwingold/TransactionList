package au.com.pjwin.transaction_list

import au.com.pjwin.commonlib.Common
import au.com.pjwin.transaction_list.util.TestConfig

class TransactionTestApp : TransactionApp() {

    override fun initCommon() {
        Common.init(applicationContext, TestConfig(), true)
    }
}