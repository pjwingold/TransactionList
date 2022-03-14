package au.com.pjwin.transaction_list.domain

import au.com.pjwin.transaction_list.model.Transaction
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.Date

class AccountTransactionDomainTest {

    private val transactionDomain = AccountTransactionDomain()

    @Test
    fun `test calculatePendingTotal`() {
        val list = mutableListOf<Transaction>() +
                Transaction(amount = BigDecimal("10.5"), isPending = true, effectiveDate = Date()) +
                Transaction(amount = BigDecimal("5.4"), isPending = true, effectiveDate = Date()) +
                Transaction(amount = BigDecimal("15"), isPending = true, effectiveDate = Date()) +
                Transaction(amount = BigDecimal("15"), effectiveDate = Date())

        val total = transactionDomain.calculatePendingTotal(list)
        assertEquals(total, BigDecimal("30.9"))
    }

    @Test
    fun `test formatData`() {
        val dateFormat = SimpleDateFormat("yyyy-dd-mm")
        val list = mutableListOf<Transaction>() +
                Transaction(
                    amount = BigDecimal("10.5"),
                    effectiveDate = dateFormat.parse("2021-08-08")
                ) +
                Transaction(
                    amount = BigDecimal("5.4"),
                    effectiveDate = dateFormat.parse("2021-08-08")
                ) +
                Transaction(
                    amount = BigDecimal("15"),
                    effectiveDate = dateFormat.parse("2021-08-08")
                ) +
                Transaction(
                    amount = BigDecimal("15"),
                    effectiveDate = dateFormat.parse("2021-08-09")
                )

        val formattedList = transactionDomain.formatData(list)
        assertEquals(formattedList.size, 6)
    }
}