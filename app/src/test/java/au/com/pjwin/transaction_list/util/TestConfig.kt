package au.com.pjwin.transaction_list.util


class TestConfig : au.com.pjwin.commonlib.Common.Config {

    override fun host() = "0.0.0.0"

    override fun port(): Int = 8081

    override fun schema(): String = "http"

    override fun contextRoot() = ""

    override fun readTimeout(): Long = 10

    override fun connectionTimeout(): Long = 10

    override fun debug(): Boolean = true
}