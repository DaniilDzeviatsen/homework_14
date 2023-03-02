import java.math.BigDecimal;

public class ExchangeRate {
    private final Currency currency;
    private final BigDecimal valueInBYN;

    public ExchangeRate(Currency currency, BigDecimal valueInBYN) {
        this.currency = currency;
        this.valueInBYN = valueInBYN;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getValueInBYN() {
        return valueInBYN;
    }
}

