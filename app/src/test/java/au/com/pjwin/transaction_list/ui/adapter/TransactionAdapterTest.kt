package au.com.pjwin.transaction_list.ui.adapter

import au.com.pjwin.commonlib.ui.adapter.ListClickListener
import au.com.pjwin.transaction_list.BaseTransRecyclerAdapterTest
import au.com.pjwin.transaction_list.R
import au.com.pjwin.transaction_list.model.Transaction
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.math.BigDecimal
import java.util.Date

class TransactionAdapterTest : BaseTransRecyclerAdapterTest<TransactionAdapter>() {

    override fun buildAdapter() = TransactionAdapter(activity,
        listOf(
            Transaction(BigDecimal(1.0), "1", true, effectiveDate = Date()),
            Transaction(BigDecimal(2.0), "2", true, effectiveDate = Date())),
        object : ListClickListener<Transaction> {
            override fun onClick(data: Transaction, pos: Int) {
            }
        }
    )

    @Test
    fun testCreate() {
        assertNotNull(adapter)

        var layoutId = adapter.layoutIdByViewType(TransactionAdapter.ItemType.HEADER.ordinal)
        assertEquals(layoutId, R.layout.view_trans_header)

        layoutId = adapter.layoutIdByViewType(TransactionAdapter.ItemType.CONTENT.ordinal)
        assertEquals(layoutId, R.layout.view_transaction)
    }
}