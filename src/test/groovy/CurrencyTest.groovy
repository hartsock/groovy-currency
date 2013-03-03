
import org.junit.Test
import org.junit.Before;

import static currency.soapclient.CurrencyCode.*
import currency.NumberCategory
import currency.Money
import currency.soapclient.CurrencyService
import currency.soapclient.ICurrencyService
/**
 *
 */

public class CurrencyTest {

    @Before
    void init() {
        Number.mixin NumberCategory
    }

    @Test
    void testCurrencyValueCategory() {

        def val = 1.USD
        assert val.value == 1
        assert val.currencyCode == USD

        assert val.toString() == "1.00 USD"

        val = 21.EUR
        assert val.value == 21
        assert val.currencyCode == EUR

        assert val.toString() == "21.00 EUR"

        val = 97.7.eur
        assert val.value == 97.7
        assert val.currencyCode == EUR

        assert "97.70 EUR".equals(val.toString())

        val = 32.foo
        assert val.value == 32
        assert !val.properties.containsKey('currencyCode')
    }


    @Test
    void testCurrencyConversion() {

        Money euros1 = 1.USD.to EUR

        assert euros1.value != null
        assert euros1.value != 1
        assert euros1.currencyCode == EUR
        println "1.00 USD ~= ${euros1}"

        def euros2 = 25.USD.to 'EUR'

        CurrencyService currencyService = new CurrencyService()
        ICurrencyService service = currencyService.getBasicHttpBindingICurrencyService()
        def rate = service.getConversionRate(USD,EUR)

        assert euros2.value
        assert euros2.value == 25 * rate.rate
        assert euros2.currencyCode == EUR

        println "25.00 USD ~= ${euros2}"

        rate = service.getConversionRate(EUR,USD)
        def euros3 = 27.EUR.toUSD()
        assert euros3.value
        assert euros3.value == 27 * rate.rate
        assert euros3.currencyCode == USD

        println "27.00 EUR ~= ${euros3}"
    }

}
