public enum Currency {
    BYN("Белорусский рубль"), RUB("Российский рубль"),
    EUR("Евро"), USD("Доллар"),
    GBP("Фунт-стерлинг"), CNH("Юань");
    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

