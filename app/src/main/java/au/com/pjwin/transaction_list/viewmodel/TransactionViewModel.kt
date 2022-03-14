package au.com.pjwin.transaction_list.viewmodel

import au.com.pjwin.commonlib.viewmodel.DataViewModel
import au.com.pjwin.transaction_list.domain.AccountTransactionDomain
import au.com.pjwin.transaction_list.domain.AccountTransactionMapper
import javax.inject.Inject

class TransactionViewModel @Inject constructor() : DataViewModel<AccountTransactionMapper>() {

    private val transactionDomain = AccountTransactionDomain()

    fun loadAccountTransactions() {
        launchJob(true) {
            val result = transactionDomain.getAccountTransactions()

            when {
                result.data != null -> {
                    onData(result.data)
                }

                result.error != null -> {
                    onError(result.error)
                }
            }
        }
    }
}