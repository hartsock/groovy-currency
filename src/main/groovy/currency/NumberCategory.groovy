package currency
import currency.soapclient.CurrencyCode
@Category(Number)
class NumberCategory {
    static init() { Number.mixin(NumberCategory) }

    static get(Number value, String name) {
        if(Money.isCurrencyCode(name)) {
            CurrencyCode code = name.toUpperCase()
            return new Money(value: value,currencyCode: code)
        }
        return value
    }
}
