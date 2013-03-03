import currency.*
import currency.soapclient.*
import static currency.soapclient.CurrencyCode.*
import org.junit.Test

class MoneyOperatorTests {
    @Test
    void testEquals() {
        Money.init()
        assert 1.USD == 1.USD
        assert 1.USD != 1.JPY
        def usd = 1000.JPY.to(USD)
        assert usd == 1000.JPY
    }
}
