package au.com.pjwin.transaction_list.ui.adapter

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import au.com.pjwin.commonlib.ui.adapter.ListClickListener
import au.com.pjwin.commonlib.ui.adapter.RecyclerListAdapter
import au.com.pjwin.transaction_list.R
import au.com.pjwin.transaction_list.databinding.ViewTransHeaderBinding
import au.com.pjwin.transaction_list.databinding.ViewTransactionBinding
import au.com.pjwin.transaction_list.model.Transaction

class TransactionAdapter(
    context: Context, transList: List<Transaction>, onClickListener: ListClickListener<Transaction>,
) :
    RecyclerListAdapter<Transaction, ViewDataBinding, RecyclerView.ViewHolder>(context, transList, onClickListener) {

    override fun layoutId() = 0

    override fun layoutIdByViewType(viewType: Int): Int {
        return when (viewType) {
            ItemType.HEADER.ordinal -> R.layout.view_trans_header

            else -> R.layout.view_transaction
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).id == "") ItemType.HEADER.ordinal else ItemType.CONTENT.ordinal
    }

    override fun bindData(binding: ViewDataBinding, data: Transaction) {
        if (binding is ViewTransHeaderBinding) {
            binding.transaction = data

        } else if (binding is ViewTransactionBinding) {
            binding.transaction = data
        }
    }

    enum class ItemType {
        HEADER, CONTENT
    }
}