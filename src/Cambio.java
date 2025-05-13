public record Cambio(ConversionRates conversion_rates) {
    public record ConversionRates(
        double USD,
        double EUR,
        double JPY,
        double BRL,
        double ARS,
        double CNY
    ) {}
}