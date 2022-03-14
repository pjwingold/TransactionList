package au.com.pjwin.transaction_list.domain

import au.com.pjwin.transaction_list.model.Account
import au.com.pjwin.transaction_list.model.Atm
import au.com.pjwin.transaction_list.model.Transaction
import java.io.Serializable
import java.math.BigDecimal

class AccountTransactionMapper(
    val account: Account,
    val formattedTransactions: List<Transaction>,
    val atms: List<Atm>,
    val pendingTotal: BigDecimal
): Serializable