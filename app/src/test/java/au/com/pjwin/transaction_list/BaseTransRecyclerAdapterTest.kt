package au.com.pjwin.transaction_list

import au.com.pjwin.commonlib.ui.adapter.RecyclerListAdapter
import au.com.pjwin.commonlib.util.BaseRecyclerAdapterTest
import au.com.pjwin.commonlib.util.BaseTest
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(application = TransactionTestApp::class, sdk = [28])
abstract class BaseTransRecyclerAdapterTest<T : RecyclerListAdapter<*, *, *>> : BaseRecyclerAdapterTest<T>()