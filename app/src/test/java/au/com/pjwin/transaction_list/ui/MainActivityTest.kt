package au.com.pjwin.transaction_list.ui

import au.com.pjwin.transaction_list.BaseTransActivityTest
import org.junit.Assert.assertNotNull
import org.junit.Test

class MainActivityTest : BaseTransActivityTest<MainActivity>(MainActivity::class.java) {

    @Test
    fun testOnCreate() {
        assertNotNull(activity)
    }
}
