package au.com.pjwin.transaction_list

import au.com.pjwin.commonlib.ui.BaseActivity
import au.com.pjwin.commonlib.util.BaseActivityTest
import org.robolectric.annotation.Config

@Config(application = TransactionTestApp::class, sdk = [28])
abstract class BaseTransActivityTest<T : BaseActivity<*, *, *>>(activityClz: Class<T>) : BaseActivityTest<T>(activityClz)