package au.com.pjwin.transaction_list.domain

import androidx.annotation.VisibleForTesting
import au.com.pjwin.commonlib.repo.retrofit.NetworkResult
import au.com.pjwin.transaction_list.model.Transaction
import au.com.pjwin.transaction_list.repo.TransactionRepo
import kotlinx.coroutines.flow.collect
import java.math.BigDecimal
import java.util.Date


class AccountTransactionDomain {

    suspend fun getAccountTransactions(): NetworkResult<AccountTransactionMapper> {
        var networkResult: NetworkResult<AccountTransactionMapper>? = null
        TransactionRepo.getAccountTransactions().collect {
            when {
                it.data != null -> {
                    val transList = formatData(it.data.transactions)
                    val pendingTotal = calculatePendingTotal(it.data.transactions)
                    val transMapper = AccountTransactionMapper(
                        it.data.account,
                        transList,
                        it.data.atms,
                        pendingTotal
                    )
                    networkResult = NetworkResult.Success(transMapper)
                }
                it.error != null -> {
                    networkResult = NetworkResult.Error(it.error)
                }
                else -> {
                    networkResult = NetworkResult.Error(UnknownError())
                }
            }
        }

        return networkResult!!
    }

    @VisibleForTesting
    fun formatData(transactions: List<Transaction>): List<Transaction> {
        val map = mutableMapOf<Date, Transaction>()

        val dateDistinctMap = transactions.sortedByDescending {
            it.effectiveDate
        }.distinctBy {
            it.effectiveDate
        }.map {
            it.effectiveDate
        }.associateByTo(
            map,
            { it },
            { Transaction(effectiveDate = it) }
        )

        val combinedList = ArrayList<Transaction>(dateDistinctMap.size + transactions.size)
        transactions.forEach {
            val dateTrans = dateDistinctMap[it.effectiveDate]
            if (dateTrans != null && !combinedList.contains(dateTrans)) {
                combinedList.add(dateTrans)
            }
            combinedList.add(it)
        }

        return combinedList
    }

    @VisibleForTesting
    fun calculatePendingTotal(transList: List<Transaction>): BigDecimal {
        var total = BigDecimal(0)
        transList.forEach {
            if (it.isPending) {
                total += it.amount
            }
        }
        return total
    }
}