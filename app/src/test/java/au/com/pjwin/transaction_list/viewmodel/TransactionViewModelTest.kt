package au.com.pjwin.transaction_list.viewmodel

import au.com.pjwin.transaction_list.BaseTransApiTest
import io.mockk.impl.annotations.SpyK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

class TransactionViewModelTest : BaseTransApiTest() {

    @SpyK
    private var viewModel = TransactionViewModel()

    @ExperimentalCoroutinesApi
    @Test
    fun `test Load AccountTransactions`() = runBlockingTest {
        loadAndEnqueue("exercise.json")
        viewModel.loadAccountTransactions()

        verify { viewModel.onData(any()) }
        assertEquals(viewModel.liveData.value?.formattedTransactions?.size, 51)
    }
}