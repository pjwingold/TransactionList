package au.com.pjwin.transaction_list

import au.com.pjwin.commonlib.ui.BaseFragment
import au.com.pjwin.commonlib.util.BaseFragmentTest
import org.robolectric.annotation.Config

@Config(application = TransactionTestApp::class, sdk = [28])
abstract class BaseTransFragmentTest<T: BaseFragment<*, *, *>>(fragmentClz: Class<T>) : BaseFragmentTest<T>(fragmentClz)