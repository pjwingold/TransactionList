package au.com.pjwin.transaction_list.ui

import au.com.pjwin.transaction_list.BaseTransFragmentTest
import io.mockk.mockk
import org.junit.Assert.assertNotNull
import org.junit.Test

class AccountTransactionDetailsFragmentTest : BaseTransFragmentTest<AccountTransactionDetailsFragment>(AccountTransactionDetailsFragment::class.java) {

    override fun buildFragment(): AccountTransactionDetailsFragment {
        return AccountTransactionDetailsFragment().apply {
            arguments = AccountTransactionDetailsFragmentArgs(mockk()).toBundle()
        }
    }

    @Test
    fun testOnCreate() {
        assertNotNull(fragment)
    }
}
