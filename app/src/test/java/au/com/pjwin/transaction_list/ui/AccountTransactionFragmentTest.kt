package au.com.pjwin.transaction_list.ui

import au.com.pjwin.commonlib.ui.NavGraphModel
import au.com.pjwin.commonlib.util.MockResource
import au.com.pjwin.transaction_list.BaseTransFragmentTest
import au.com.pjwin.transaction_list.R
import au.com.pjwin.transaction_list.databinding.FragmentTransactionListBinding
import au.com.pjwin.transaction_list.domain.AccountTransactionMapper
import au.com.pjwin.transaction_list.model.AccountLoadError
import au.com.pjwin.transaction_list.model.Transaction
import au.com.pjwin.transaction_list.viewmodel.TransactionViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.robolectric.annotation.LooperMode
import org.robolectric.fakes.RoboMenuItem
import org.robolectric.shadows.ShadowLooper
import java.math.BigDecimal
import java.util.Date

@LooperMode(LooperMode.Mode.LEGACY)
class AccountTransactionFragmentTest : BaseTransFragmentTest<AccountTransactionFragment>(AccountTransactionFragment::class.java) {

    private lateinit var transactionViewModel: TransactionViewModel

    override fun navGraph() = NavGraphModel(R.navigation.navigation_trans)

    @Test
    fun testOnCreate() {
        assertNotNull(fragment)
        transactionViewModel = mockedVM as TransactionViewModel

        val menuItem = RoboMenuItem()
        menuItem.itemId = R.id.menu_refresh_trans
        fragment.onOptionsItemSelected(menuItem)

        verify { transactionViewModel.loadAccountTransactions() }

        val spyFragment = spyk(fragment)
        spyFragment.onError(AccountLoadError())
        verify { spyFragment.showError(R.string.transaction_load_error) }

        spyFragment.onError(UnknownError())
        verify { spyFragment.showError(R.string.transaction_unknown_error) }

        spyFragment.onData(mockk(relaxed = true) {
            every { formattedTransactions } returns listOf(
                Transaction(BigDecimal(1.0), "1", true, effectiveDate = Date()),
                Transaction(BigDecimal(2.0), "2", true, effectiveDate = Date())
            )
        })

        getBinding<FragmentTransactionListBinding>()!!.run {
            ShadowLooper.runUiThreadTasksIncludingDelayedTasks()
            transList.run {
                //need this so findViewHolderForAdapterPosition() will return value
                measure(0, 0)
                layout(0, 0, 100, 100)
                findViewHolderForAdapterPosition(0)?.itemView?.performClick()
                verifyCurrentDestination(R.id.account_transaction_details_fragment)
            }
        }
    }
}
