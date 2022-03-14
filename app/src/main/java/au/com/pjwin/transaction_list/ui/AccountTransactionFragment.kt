package au.com.pjwin.transaction_list.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import au.com.pjwin.commonlib.ui.BaseFragment
import au.com.pjwin.commonlib.ui.adapter.ListClickListener
import au.com.pjwin.transaction_list.R
import au.com.pjwin.transaction_list.databinding.FragmentTransactionListBinding
import au.com.pjwin.transaction_list.domain.AccountTransactionMapper
import au.com.pjwin.transaction_list.model.AccountLoadError
import au.com.pjwin.transaction_list.model.AccountTransactions
import au.com.pjwin.transaction_list.model.Transaction
import au.com.pjwin.transaction_list.ui.adapter.TransactionAdapter
import au.com.pjwin.transaction_list.viewmodel.TransactionViewModel
import java.io.Serializable

class AccountTransactionFragment :
    BaseFragment<AccountTransactionMapper, TransactionViewModel, FragmentTransactionListBinding>() {

    private lateinit var adapter: TransactionAdapter

    override fun layoutId() = R.layout.fragment_transaction_list

    override fun getViewModelBinding() = ViewModelBinding.NAVIGATION.apply {
        navId = R.id.navigation_trans
    }

    override fun pageTitle() = R.string.title_view_transaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        initAdapter()
        loadTransactions()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.transList.adapter = adapter
    }

    private fun initAdapter() {
        adapter = TransactionAdapter(
            requireContext(),
            listOf(),
            object : ListClickListener<Transaction> {
                override fun onClick(data: Transaction, pos: Int) {
                    navigateTo(
                        AccountTransactionFragmentDirections.startTransactionDetailsFragment(
                            data
                        )
                    )
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_trans, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_refresh_trans) {
            loadTransactions()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadTransactions() {
        viewModel.loadAccountTransactions()
    }

    override fun onData(data: AccountTransactionMapper?) {
        data?.run {
            binding.run {
                account = data.account
                pendingTotal = data.pendingTotal
                adapter.list = data.formattedTransactions
            }
        }
    }

    override fun onError(throwable: Throwable?) {
        //TODO fullscreen error
        when (throwable) {
            is AccountLoadError -> {
                showError(R.string.transaction_load_error)
            }
            is UnknownError -> {
                showError(R.string.transaction_unknown_error)
            }
            else -> {
                super.onError(throwable)
            }
        }
    }
}