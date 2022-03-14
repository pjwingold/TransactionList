package au.com.pjwin.transaction_list

import au.com.pjwin.commonlib.util.BaseApiTest
import org.robolectric.annotation.Config

@Config(application = TransactionTestApp::class, sdk = [28])
abstract class BaseTransApiTest: BaseApiTest()