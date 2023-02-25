import java.math.BigDecimal;
import java.util.Arrays;

public class ExchangeService {
    private final BigDecimal BASE_CURRENCY_VALUE = new BigDecimal("1.0000");

    public ExchangeRate[] getExchangeRate() {
        return new ExchangeRate[]{
                new ExchangeRate(Currency.USD, new BigDecimal("2.7981")),
                new ExchangeRate(Currency.EUR, new BigDecimal("2.9769")),
                new ExchangeRate(Currency.CNH, new BigDecimal("0.4073")),
                new ExchangeRate(Currency.GBP, new BigDecimal("3.3791")),
                new ExchangeRate(Currency.RUB, new BigDecimal("0.0376"))
        };
    }


    public BigDecimal exchange(Currency currencyIn, BigDecimal sum, Currency currencyToConvert) {
        ExchangeRate[] rates = getExchangeRate();
        BigDecimal curIn = new BigDecimal(0);
        BigDecimal curTo = new BigDecimal(0);
        for (ExchangeRate rate : rates) {
            if (currencyIn == rate.getCurrency()) {
                curIn = rate.getValueInBYN();
            }
            if (currencyToConvert == rate.getCurrency()) {
                curTo = rate.getValueInBYN();
            }
            if (currencyIn == Currency.BYN) {
                curIn = BASE_CURRENCY_VALUE;
            }
            if (currencyToConvert == Currency.BYN) {
                curTo = BASE_CURRENCY_VALUE;
            }

        }
        BigDecimal amountInBYN = sum.multiply(curIn);
        return amountInBYN.divide(curTo, 4);
    }

}