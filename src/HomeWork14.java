
import java.math.BigDecimal;
import java.util.Arrays;

import java.util.Scanner;


public class HomeWork14 {


    public static void main(String[] args) {

        ExchangeService exchangeService = new ExchangeService();
        ExchangeRate[] rates = exchangeService.getExchangeRate();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello user, choose operation");
        System.out.printf("%s\n%s\n", "press 1 so as to get view of current rates", "press 2 so as to convert money");
        int numOfOperation = Integer.parseInt(sc.nextLine());
        switch (numOfOperation) {
            case 1 -> {
                System.out.printf("%-16s %s%5s%n", "Валюта", "Код", "Курс");
                for (ExchangeRate rate : rates) {
                    System.out.printf("%-16s %s%7s%n", rate.getCurrency().getName(), rate.getCurrency(), rate.getValueInBYN());
                }
            }
            case 2 -> {
                System.out.println("Enter currency code you want to convert");
                Currency currencyCode = Currency.valueOf(sc.nextLine());
                System.out.println("Enter sum you want to convert");
                BigDecimal sum = BigDecimal.valueOf(Integer.parseInt(sc.nextLine()));
                System.out.println("Enter currency you want to convert in");
                Currency currencyCodeToConv = Currency.valueOf(sc.nextLine());
                System.out.println("You'll get");
                System.out.println(exchangeService.exchange(currencyCode, sum, currencyCodeToConv) + " " + currencyCodeToConv.getName());
            }
            default -> System.out.println("Wrong data input");
        }

    }
}
