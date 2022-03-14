package au.com.pjwin.transaction_list.model

abstract class AccountError : Exception()

class AccountLoadError : AccountError()

class UnknownError : AccountError()