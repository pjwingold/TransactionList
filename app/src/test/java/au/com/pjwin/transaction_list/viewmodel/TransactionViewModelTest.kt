package au.com.pjwin.transaction_list.viewmodel

import au.com.pjwin.transaction_list.BaseTransApiTest
import io.mockk.impl.annotations.SpyK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.math.BigDecimal

class TransactionViewModelTest : BaseTransApiTest() {

    @SpyK
    private var viewModel = TransactionViewModel()

    @ExperimentalCoroutinesApi
    @Test
    fun `test Load AccountTransactions`() = runBlockingTest {
        loadAndEnqueue("exercise.json")
        viewModel.loadAccountTransactions()

        verify { viewModel.onData(any()) }
        val transList = viewModel.liveData.value?.formattedTransactions
        assertEquals(transList?.size, 51)

        assertTrue(transList?.get(0)?.amount?.compareTo(BigDecimal(0)) == 0)

        assertTrue(transList?.get(1)?.amount?.compareTo(BigDecimal(-14.19).setScale(2, BigDecimal.ROUND_HALF_UP)) == 0)
    }
}