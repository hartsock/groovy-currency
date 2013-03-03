package currency

import static currency.soapclient.CurrencyCode.*
import groovy.transform.Immutable
import currency.soapclient.CurrencyCode
import currency.soapclient.CurrencyService
import currency.soapclient.ICurrencyService
import currency.soapclient.Currency

@Immutable
class Money {
    BigDecimal value
    CurrencyCode currencyCode

    // format the number string to preserve only 2 decimal places
    String toString() { String.format("%.2f %s",value,currencyCode.value()) }

    static init() { Number.mixin(NumberCategory) }

    // returns true if the presented code could be a CurrencyCode enum
    static boolean isCurrencyCode(String name) {
        CurrencyCode.enumConstants.find { code ->
            code.value().equalsIgnoreCase(name)
        }
    }

    // convert one type of Money into another type of Money
    Money to(CurrencyCode code) {
        CurrencyService currencyService = new CurrencyService()
        ICurrencyService service =
            currencyService.getBasicHttpBindingICurrencyService()
        Currency rate =
            service.getConversionRate(currencyCode,code)

        def val = value * rate.rate
        new Money(value: val,currencyCode: code)
    }

    // allow groovy to do some type casting magic in places where necessary
    Money to(toCurrencyCode) {
        // groovy can convert strings into enums automatically
        CurrencyCode code = toCurrencyCode as CurrencyCode
        to(code)
    }

    // allow code synthesis of new methods...
    // parses the currency code from the method name
    // unknown methods are considered identity transformations
    def methodMissing(String name, args) {
        (name.length() == 5 && name.startsWith("to")) ?
            to(name.substring(2,5)) : this
    }

    boolean equals(Money rhs) {
        value == normalize(rhs).value
    }

    int compareTo(Money rhs) {
        Money other = normalize(rhs)
        value.compareTo(other.value)
    }

    // normalizes the right hand side (rhs) of an expression with the left hand side (lhs)
    // this allows for direct comparison of different types of Money.
    public Money normalize(Money rhs) {
        (rhs.currencyCode == currencyCode) ? rhs : rhs.to(currencyCode)
    }
}