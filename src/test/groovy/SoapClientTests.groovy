import currency.soapclient.CurrencyService
import currency.soapclient.ICurrencyService
import currency.soapclient.CurrencyCode
import org.junit.Test
/**
 * 
 */
class SoapClientTests {

    @Test
    void testSoapClient() {
        CurrencyService currencyService = new CurrencyService()
        ICurrencyService service = currencyService.getBasicHttpBindingICurrencyService()
        def rate = service.getConversionRate(CurrencyCode.USD,CurrencyCode.EUR)
        assert rate
        assert rate.rate
        assert rate.fromCurrency
        assert rate.toCurrency
        assert rate.fromCurrency == CurrencyCode.USD
        assert rate.toCurrency == CurrencyCode.EUR
        println rate.rate

    }
}
